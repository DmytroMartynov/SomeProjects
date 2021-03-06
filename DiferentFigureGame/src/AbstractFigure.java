import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class AbstractFigure implements Shape {

    protected double diameter = 30;

    protected transient GraphicsContext gc;
    protected double x;
    protected double y;
    protected transient  List< Shape > shapes;

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public List< Shape > getShapes() {
        return shapes;
    }

    public void setShapes(List< Shape > shapes) {
        this.shapes = shapes;
    }

    public AbstractFigure(GraphicsContext gc, double x, double y, List< Shape > shapes) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.shapes = shapes;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public AbstractFigure(AbstractFigure figure) {
        this(figure.gc, figure.x, figure.y, figure.shapes);
        this.diameter = figure.diameter;
    }
    public AbstractFigure(){

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

