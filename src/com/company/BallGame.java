package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class BallGame extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 500, Color.ALICEBLUE);
        Circle ballGame = new Circle(25, Color.CADETBLUE);
        ballGame.relocate(10, 10);
        canvas.getChildren().add(ballGame);
        primaryStage.setTitle("Test ball Game");
        primaryStage.setScene(scene);
        primaryStage.show();


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500),
                new EventHandler<ActionEvent>() {

                    double dx = 10;
                    double dy = 8;

                    @Override
                    public void handle(ActionEvent t) {

                        ballGame.setLayoutX(ballGame.getLayoutX() + dx);
                        ballGame.setLayoutY(ballGame.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        if(ballGame.getLayoutX() <= (bounds.getMinX() + ballGame.getRadius()) ||
                                ballGame.getLayoutX() >= (bounds.getMaxX() - ballGame.getRadius()) ){

                            dx = -dx;

                        }

                        if((ballGame.getLayoutY() >= (bounds.getMaxY() - ballGame.getRadius())) ||
                                (ballGame.getLayoutY() <= (bounds.getMinY() + ballGame.getRadius()))){

                            dy = -dy;

                        }
                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


}