import javafx.scene.canvas.GraphicsContext;

import java.sql.SQLOutput;
import java.util.Random;

abstract class ConstAndMethods  {
    Board board;
    public static final int BOARD_WIDTH = 1400;
    public static final int BOARD_HEIGHT = 1000;
    public static final int FPS = 60;
    private static double DIAMETER = 50;
    protected static GraphicsContext gc;
    protected  double x;
    protected  double y;
    protected double xSpeed;
    protected double ySpeed;

    public void initializeRandomMove() {
        Random random = new Random();
        xSpeed = 10 + random.nextInt(5);
        ySpeed = 10 + random.nextInt(5);
    }

    public void move() {

        x += xSpeed;
        y += ySpeed;

        if (x > (gc.getCanvas().getWidth() - DIAMETER)) {
            xSpeed = -xSpeed;
        }
        if (y > (gc.getCanvas().getHeight() - DIAMETER)) {
            ySpeed = -ySpeed;
        }
        if (x < 0) {
            xSpeed = -xSpeed;

        }
        if (y < 0) {
            ySpeed = -ySpeed;

        }

    }
        private boolean handleСollision() {
            for (Shape shape : board.getShapes()) {
                if (shape == this) {
                    continue;
                }
                if (shape.getDistance(x, y) < DIAMETER) {
                    if (x < shape.getX()) {
                        setDirectionLeft();
                    } else {
                        setDirectionRight();
                    }

                    if (y < shape.getY()) {
                        setDirectionTop();
                    } else {
                        setDirectionBottom();
                    }

                    return true;
                }
            }
            return false;
        }

        public double getX() {
            return x;
        }


        public double getY() {
            return y;
        }

        private void setDirectionLeft() {
            xSpeed = -Math.abs(xSpeed);
        }

        private void setDirectionRight() {
            xSpeed = Math.abs(xSpeed);
        }

        private void setDirectionTop() {
            ySpeed = -Math.abs(ySpeed);
        }

        private void setDirectionBottom(){
            ySpeed = Math.abs(ySpeed);
        }
    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    }






