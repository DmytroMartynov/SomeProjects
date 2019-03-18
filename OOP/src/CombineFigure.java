import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class CombineFigure  implements Shape {
    private static final double DIAMETER = 80;
    private Board board;
    private GraphicsContext gc;
    private double x;
    private double y;

    private double xSpeed;
    private double ySpeed;
    public CombineFigure(Board board,GraphicsContext gc, double x, double y) {
        this.board = board;
        this.gc = gc;
        this.x = x;
        this.y = y;

        Random random = new Random();
        xSpeed = 2 + random.nextInt(2);
        ySpeed = 2 + random.nextInt(1);
    }

    @Override
    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (handleСollision()) {
            return;
        }
        if (x > gc.getCanvas().getWidth() - 2 * DIAMETER) {
            setDirectionLeft();

        } else if (x < DIAMETER) {
            setDirectionRight();
        }

        if (y > gc.getCanvas().getHeight() - 2 * DIAMETER) {
            setDirectionTop();

        } else if (y < DIAMETER) {
            setDirectionBottom();
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

    @Override
    public void draw() {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(4);
        gc.fillRect(x, y, DIAMETER, DIAMETER);
        gc.strokeRect(x, y, DIAMETER, DIAMETER);
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.ORANGE);
        gc.setLineWidth(4);
        gc.fillOval(x - DIAMETER, y, DIAMETER, DIAMETER);
        gc.strokeOval(x - DIAMETER, y, DIAMETER, DIAMETER);
        gc.fillOval(x + DIAMETER, y, DIAMETER, DIAMETER);
        gc.strokeOval(x + DIAMETER, y, DIAMETER, DIAMETER);
        gc.fillOval(x, y - DIAMETER, DIAMETER, DIAMETER);
        gc.strokeOval(x, y - DIAMETER, DIAMETER, DIAMETER);
        gc.fillOval(x, y + DIAMETER, DIAMETER, DIAMETER);
        gc.strokeOval(x, y + DIAMETER, DIAMETER, DIAMETER);


    }
    @Override
    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
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

    private void setDirectionBottom() {
        ySpeed = Math.abs(ySpeed);
    }
}
