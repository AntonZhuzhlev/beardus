package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
		Group root = new Group();
		Scene theScene = new Scene(root);
		ps.setScene(theScene);	
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);	
		AnimatedImage beardus1 = new AnimatedImage();
		Image[] imageArray1 = new Image[4];
		AnimatedImage beardus2 = new AnimatedImage();
		Image[] imageArray2 = new Image[4];
		for (int i = 0; i < 4; i ++) {
			imageArray1[i] = new Image("birdus2.0_" + i + ".png");		
		}
		for (int i = 0; i < 4; i ++) {
			imageArray2[i] = new Image("birdus2.1_" + i + ".png");		
		}
		
		beardus1.frames = imageArray1;
		beardus1.duration = 0.013;	
		beardus2.frames = imageArray2;
		beardus2.duration = 0.013;	
		GraphicsContext gc = canvas.getGraphicsContext2D();
		final long startNanoTime = System.nanoTime();
		System.out.println(startNanoTime);	
		new AnimationTimer() {
			@Override
			public void handle(long t) {
				double diff = (t - startNanoTime) / 10000000000.0;
				gc.drawImage(beardus2.getFrame(diff),0,0);
				gc.drawImage(beardus1.getFrame(diff),0,200);
				
			}
		}.start();
		ps.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}