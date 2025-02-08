import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{


  public ImageFilter(String filename) {
    super(filename);
  }
  
public void pixelate(int gridSize) {
    Pixel[][] pixels = getPixelsFromImage();
    
    for (int row = 0; row < pixels.length; row += gridSize) {
        for (int col = 0; col < pixels[0].length; col += gridSize) {
            
            int redTotal = 0, greenTotal = 0, blueTotal = 0, count = 0;
            
            int endRow = Math.min(row + gridSize, pixels.length);
            int endCol = Math.min(col + gridSize, pixels[0].length);
            
            // First pass: Calculate the average color in the region
            for (int gridRow = row; gridRow < endRow; gridRow++) {
                for (int gridCol = col; gridCol < endCol; gridCol++) {
                    Pixel pixel = pixels[gridRow][gridCol];
                    redTotal += pixel.getRed();
                    greenTotal += pixel.getGreen();
                    blueTotal += pixel.getBlue();
                    count++;
                }
            }
            
            int avgRed = redTotal / count;
            int avgGreen = greenTotal / count;
            int avgBlue = blueTotal / count;
            
            // Second pass: Set each pixel in the region to the average color
            for (int gridRow = row; gridRow < endRow; gridRow++) {
                for (int gridCol = col; gridCol < endCol; gridCol++) {
                    pixels[gridRow][gridCol].setRed(avgRed);
                    pixels[gridRow][gridCol].setGreen(avgGreen);
                    pixels[gridRow][gridCol].setBlue(avgBlue);
                }
            }
        }
    }
}


  public void highlightBlue() {
   
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)(0 + currentRed);
        int newGreen = (int)(0 + currentGreen);
        int newBlue = (int)(255 - currentBlue);

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }


public void makePurple(int gridSize) {
    Pixel[][] pixels = getPixelsFromImage();
    
    for (int row = 0; row < pixels.length; row += gridSize) {
        for (int col = 0; col < pixels[0].length; col += gridSize) {
            
            int redTotal = 0, greenTotal = 0, blueTotal = 0, count = 0;
            
            int endRow = Math.min(row + gridSize, pixels.length);
            int endCol = Math.min(col + gridSize, pixels[0].length);
            
            // First pass: Calculate the average color in the region
            for (int gridRow = row; gridRow < endRow; gridRow++) {
                for (int gridCol = col; gridCol < endCol; gridCol++) {
                    Pixel pixel = pixels[gridRow][gridCol];
                    redTotal += pixel.getRed();
                    greenTotal += pixel.getGreen();
                    blueTotal += pixel.getBlue();
                    count++;
                }
            }
            
            int avgRed = redTotal / count;
            int avgGreen = greenTotal / count;
            int avgBlue = blueTotal / count;
            
            // Adjust colors to bring out purple hues
            avgRed = Math.min(avgRed + 50, 255); // Slightly boost red component
            avgGreen = (int) (avgGreen * 0.5); // Reduce green component
            avgBlue = Math.min(avgBlue + 80, 255); // Boost blue component
            
            // Second pass: Set each pixel in the region to the adjusted color
            for (int gridRow = row; gridRow < endRow; gridRow++) {
                for (int gridCol = col; gridCol < endCol; gridCol++) {
                    pixels[gridRow][gridCol].setRed(avgRed);
                    pixels[gridRow][gridCol].setGreen(avgGreen);
                    pixels[gridRow][gridCol].setBlue(avgBlue);
                }
            }
        }
    }  
    
}




public void motionBlur(int length, String direction) {

    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        int x = col;
        int y = row;
        int count = 0;

        while (count < length && x < pixels[0].length && y < pixels.length) {
          Pixel currentPixel = pixels[y][x];
          totalRed += currentPixel.getRed();
          totalGreen += currentPixel.getGreen();
          totalBlue += currentPixel.getBlue();
          count++;

          if (direction.equals("horizontal")) {
            x++;
          }
          else if (direction.equals("vertical")) {
            y++;
          }
          else if (direction.equals("diagonal")) {
            x++;
            y++;
          }
        }

        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;

        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(avgRed);
        currentPixel.setGreen(avgGreen);
        currentPixel.setBlue(avgBlue);
      }
    }

   
  }
  
}
