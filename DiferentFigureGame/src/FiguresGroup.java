import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class FiguresGroup extends AbstractFigure {

    protected List< AbstractFigure > figuresGroup = new ArrayList<>();

    protected double maxX;
    protected double maxY;
    protected double minX;
    protected double minY;
    protected double diameterX;
    protected double diameterY;
    protected transient GraphicsContext gc;

    public FiguresGroup(GraphicsContext gc, double x, double y, List< Shape > shapes) {
        super(gc, x, y, shapes);
        this.gc = gc;
        minY = gc.getCanvas().getHeight();
        minX = gc.getCanvas().getWidth();
    }

    public FiguresGroup() {

    }

    public void setFiguresGroup(List< AbstractFigure > figuresGroup) {
        this.figuresGroup = figuresGroup;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setDiameterX(double diameterX) {
        this.diameterX = diameterX;
    }

    public void setDiameterY(double diameterY) {
        this.diameterY = diameterY;
    }

    public List< AbstractFigure > getFiguresGroup() {
        return figuresGroup;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getDiameterX() {
        return diameterX;
    }

    public double getDiameterY() {
        return diameterY;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    @Override
    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }



    public FiguresGroup(AbstractFigure figure) {
        this(figure.gc, 0, 0, figure.shapes);
        for (int i = 0; i < ((FiguresGroup) figure).figuresGroup.size(); i++) {
            AbstractFigure inRangeFigure = ((FiguresGroup) figure).figuresGroup.get(i);

            if (inRangeFigure instanceof Ball) {
                addToGroup(new Ball(inRangeFigure));
            } else if (inRangeFigure instanceof Rectangle) {
                addToGroup(new Rectangle(inRangeFigure));
            } else if (inRangeFigure instanceof Triangle) {
                addToGroup(new Triangle(inRangeFigure));
            } else if (inRangeFigure instanceof FiguresGroup) {
                addToGroup(new FiguresGroup(inRangeFigure));
            }
        }
    }

    @Override
    public void increseSize(boolean type) {
        for (AbstractFigure figure : figuresGroup) {
            if (!type && figure.diameter > 5) {
                figure.diameter -= 5;
            } else if (type) {
                figure.diameter += 5;
            }
        }
    }

    @Override
    public void draw() {
        for (AbstractFigure figure : figuresGroup) {
            figure.draw();
        }
    }

    @Override
    public void drawStroke() {
        for (AbstractFigure figure : figuresGroup) {
            figure.drawStroke();
        }
    }

    @Override
    public void move(DiferentMoves moves) {
        switch (moves) {
            case UP:
                if (minY > 0) {
                    for (AbstractFigure figure : figuresGroup) {
                        figure.y -= 5;
                    }
                    minY -= 5;
                    maxY -= 5;
                }
                break;
            case RIGHT:
                if (maxX + diameterX < gc.getCanvas().getWidth()) {
                    for (AbstractFigure figure : figuresGroup) {
                        figure.x += 5;
                    }
                    minX += 5;
                    maxX += 5;
                }
                break;
            case DOWN:
                if (maxY + diameterY < gc.getCanvas().getHeight()) {
                    for (AbstractFigure figure : figuresGroup) {
                        figure.y += 5;
                    }
                    minY += 5;
                    maxY += 5;
                }
                break;
            case LEFT:
                if (minX > 0) {
                    for (AbstractFigure figure : figuresGroup) {
                        figure.x -= 5;
                    }
                    minX -= 5;
                    maxX -= 5;
                }
                break;
        }
    }



    public void addToGroup(AbstractFigure figure) {
        figuresGroup.add(figure);
        changeParameters();
    }

    private void changeParameters() {
        for (AbstractFigure figure : figuresGroup) {
            if (maxX < figure.x) {
                maxX = figure.x;
                diameterX = figure.diameter;
            }
            if (maxY < figure.y) {
                maxY = figure.y;
                diameterY = figure.diameter;
            }
            if (minX > figure.x) {
                minX = figure.x;
            }
            if (minY > figure.y) {
                minY = figure.y;
            }
        }
    }
}

