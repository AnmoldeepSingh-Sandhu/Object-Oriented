import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Scenery extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        Tree t1 = new Tree (100, 420);
        root.getChildren().addAll(t1.getAllNodes());

        Tree t2 = new Tree(200, 440);
        root.getChildren().addAll(t2.getAllNodes());

        Tree t3 = new Tree(300, 400);
        root.getChildren().addAll(t3.getAllNodes());

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
