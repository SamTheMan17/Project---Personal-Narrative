import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // String[] Scenes = {"Logo-Scene.png",	"Front-scene.jpeg", "Protos.jpg", "Zerg-Image.jpg", "Terran-Image.jpg"};
    // String[] Sounds = {"Sound 1.wav", 	"Scene two sound.wav", "Protoss Sound.wav", "Zerg Sound.wav", "Terran Sound.wav"};

    String[][] data = {
      {"Logo-Scene.png",	"Front-scene.jpeg", "Protos.jpg", "Zerg-Image.jpg", "Terran-Image.jpg"},
      {"Sound 1.wav", 	"Scene two sound.wav", "Protoss Sound.wav", "Zerg Sound.wav", "Terran Sound.wav"},
    };

MyStory scene = new MyStory(data);

scene.createScene();    

Theater.playScenes(scene);

    // String test = "Hello World1";
    // String result = scene.extractRace(test);
    
    // System.out.println(result);
  }
}