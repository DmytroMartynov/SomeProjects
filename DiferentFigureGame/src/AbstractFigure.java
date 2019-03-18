import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class AbstractFigure implements Shape {

    protected double diameter = 30;

    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected List< Shape > shapes;

    public AbstractFigure(GraphicsContext gc, double x, double y, List< Shape > shapes) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.shapes = shapes;
    }

    protected AbstractFigure(AbstractFigure figure) {
        this(figure.gc, figure.x, figure.y, figure.shapes);
        this.diameter = figure.diameter;
    }

    public void increseSize(boolean type) {
        if (type) {
            diameter += 5;
        } else {
            if (diameter > 5) {
                diameter -= 5;
            }
        }
    }
    @Override
    public void move(DiferentMoves moves) {
        switch (moves) {
            case UP:
                if (y > 0) {
                    y -= 5;
                }
                break;
            case RIGHT:
                if (x + diameter < gc.getCanvas().getWidth()) {
                    x += 5;
                }
                break;
            case DOWN:
                if (y + diameter < gc.getCanvas().getHeight()) {
                    y += 5;
                }
                break;
            case LEFT:
                if (x > 0) {
                    x -= 5;
                }
                break;
        }
    }



    public double getDiameter() {
        return diameter;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public abstract void draw();

    public abstract void drawStroke();
}

