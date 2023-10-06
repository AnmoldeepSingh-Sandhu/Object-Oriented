import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;



public class ColorButtonsFx extends Application {
    private Button redButton;
    private Button blueButton;
    private Rectangle background;
    private Ellipse moon;
    private CheckBox moonColor;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        redButton = new Button("RED!");
        redButton.setLayoutX(50);
        redButton.setLayoutY(350);
        blueButton = new Button("BLUE!");
        blueButton.setLayoutX(150);
        blueButton.setLayoutY(350);
        moonColor = new CheckBox("Moon Color");
        moonColor.setLayoutX(250);
        moonColor.setLayoutY(350);
        moonColor.setTextFill(Color.WHITE);
        background = new Rectangle(0, 0, 400, 400);
        moon = new Ellipse(200, 100, 50, 50);
        moon.setFill(Color.LIGHTGRAY);

        ColorEventHandler listner = new ColorEventHandler();
        redButton.setOnAction(listner);
        blueButton.setOnAction(listner);
        moonColor.setOnAction(listner);

        Pane root = new Pane();
        root.getChildren().addAll(background, moon, redButton, blueButton,
                moonColor);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("FX Change Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ColorEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent e) {

            if (e.getSource() == redButton) {


                background.setFill(Color.RED);

            }

            if (e.getSource() == blueButton) {

                background.setFill(Color.BLUE);

            }

            if (moonColor.isSelected()) {

                moon.setFill(Color.YELLOW);

            }else{
                moon.setFill(Color.LIGHTGRAY);
            }

        }
    }

}
