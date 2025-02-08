import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

private String[][] data;

  
  public MyStory(String[][] data) {
     this.data = data;
  }

  
  public void firstScene() {
    drawImage(data[0][0], 0, 0, 410);
    playSound(data[1][0]);	
    pause(4);
    
  }

  // public void secondScene() {
  //   drawImage(images[1], 0, 0, 400);
  //   setTextHeight(30);
  //   setTextColor("White");
  //   setTextStyle(Font.MONO, FontStyle.BOLD);
  //   pause(1);
  //   drawText("Choose Your Race!",53, 350);
  //   playSound(sounds[1]);	
  //   pause(1);
  //   ImageFilter sceneTwo = new ImageFilter(images[1]);
  //   sceneTwo.pixelate(4);
  //   drawImage(sceneTwo, 0, 0, 400);
  //   pause(2);
  // }

  // public void protossScene() {
  //   drawImage(images[2], 0, 0, 400);
  //   playSound(sounds[2]);	
  //   setTextHeight(30);
  //   setTextColor("White");
  //   setTextStyle(Font.MONO, FontStyle.BOLD);
  //   drawText("Protoss",53, 350);
  //   pause(2);   
  //   ImageFilter protossScene = new ImageFilter(images[2]);
  //   protossScene.highlightBlue();
  //   drawImage(protossScene, 0, 0, 400);
  //   pause(2);
  // }

  // public void zergScene() {
  //   drawImage(images[3], 0, 0, 400);
  //   playSound(sounds[3]);	
  //   setTextHeight(30);
  //   setTextColor("White");
  //   setTextStyle(Font.MONO, FontStyle.BOLD);
  //   drawText("Zerg",53, 350);
  //   pause(2);   
  //   ImageFilter zergScene = new ImageFilter(images[3]);
  //   zergScene.makePurple(1);
  //   drawImage(zergScene, 0, 0, 400);
  //   pause(2);
  // }

  // public void terranScene() {
  //   drawImage(images[4], 0, 0, 400);
  //   playSound(sounds[4]);	
  //   setTextHeight(30);
  //   setTextColor("White");
  //   setTextStyle(Font.MONO, FontStyle.BOLD);
  //   drawText("Terran",53, 350);
  //   pause(3);   
  //   ImageFilter terranScene = new ImageFilter(images[4]);
  //   terranScene.motionBlur(10, "horizontal");
  //   drawImage(terranScene, 0, 0, 400);
  //   pause(2);
  // }

public void drawAllScene() {
  setTextHeight(30);
  setTextColor("White");
  setTextStyle(Font.MONO, FontStyle.BOLD);  
for (int i = 1; i < 5; i++){
  drawImage(data[0][i], 0, 0, 400);
  playSound(data[1][i]);	
  pause(2);   
  ImageFilter img = new ImageFilter(data[0][i]);
  String race = extractRace(i);
 if (i==1){
    drawText("Choose Your Race!",53, 350);
    pause(1);
    img.pixelate(4);
 }
 if (i==2){
    drawText(race,53, 350);
    pause(1);
    img.highlightBlue();
  }
 if (i==3){
    drawText(race,53, 350);
    pause(2);   
    img.makePurple(1);
    pause(2);
 }
  if (i==4){
    drawText(race,53, 350);
    pause(2);   
    img.motionBlur(10, "horizontal");
    pause(2); 
  }
  drawImage(img, 0, 0, 400);
  pause(2);
 }
}
    
  public void createScene() {
    firstScene();
    // secondScene();
    // protossScene();
    // zergScene();
    // terranScene();
    drawAllScene();
  }
  
  // public String extractRace(String S) {
  //   int space = S.indexOf(" ");
  //   return S.substring(0,space);
  // }

  public String extractRace(int col) {
    int space = data[1][col].indexOf(" ");
    return data[1][col].substring(0,space);
  }

  
}