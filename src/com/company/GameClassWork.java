package com.company;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

    public class GameClassWork extends Application {

        private static final int BOARD_WIDTH = 500;
        private static final int BOARD_HEIGHT = 500;

        private int x = 10;
        private int y = 10;
        private GraphicsContext gc;


        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Test");
            Canvas canvas = new Canvas();
            canvas.setWidth(BOARD_WIDTH);
            canvas.setHeight(BOARD_HEIGHT);
            BorderPane group = new BorderPane(canvas);
            Scene scene = new Scene(group);
            primaryStage.setScene(scene);
            primaryStage.show();

            gc = canvas.getGraphicsContext2D();
            draw();

            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.LEFT) {
                        System.out.println("LEFT");
                        if (x > 0) {
                            x = x - 5;
                        }
                    }
                    if (event.getCode() == KeyCode.RIGHT) {
                        System.out.println("RIGHT");
                        if (x < gc.getCanvas().getWidth() - 30) {
                            x = x + 5;
                        }
                    }
                    if (event.getCode() == KeyCode.UP) {
                        System.out.println("UP");
                        if (y > 0) {
                            y = y - 5;
                        }
                    }
                    if (event.getCode() == KeyCode.DOWN) {
                        System.out.println("DOWN");
                        if (y < gc.getCanvas().getHeight() - 30) {
                            y = y + 5;
                        }
                    }


                    if (event.getCode() == KeyCode.SHIFT) {
                        gc.setLineWidth(2);
                        gc.setStroke(Color.BLACK);
                        gc.strokeOval(x, y, 30, 30);
                        System.out.println("SHIFT");


                    }
                    clear();
                    draw();


                }
            });
        }



        private void clear() {
            gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        }

        private void draw() {
            gc.setLineWidth(2);
            gc.setStroke(Color.BLACK);
            gc.strokeOval(x, y, 30, 30);
            gc.setFill(Color.RED);
            gc.fillOval(x, y, 30, 30);



        }

    }





