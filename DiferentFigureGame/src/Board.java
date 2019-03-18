import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private GraphicsContext gc;

    private List< Shape > shapes = new ArrayList<>();
    private AbstractFigure headFigure;

    public Board(GraphicsContext gc) {
        this.gc = gc;
    }

    public void move(DiferentMoves moves) {
        if (headFigure != null) {
            headFigure.move(moves);
        }
    }

    public void draw() {
        clean();

        if (shapes.size() > 0) {
            if (headFigure != null) {
                headFigure.draw();
            }
            for (Shape shape : shapes) {
                shape.drawStroke();
            }
        }
    }

    public void addFigure(DiferentFigure figures) {
        switch (figures) {
            case BALL:
                shapes.add(new Ball(gc, 10, 10, shapes));
                headFigure = (AbstractFigure) shapes.get(shapes.size() - 1);
                break;
            case RECTANGL:
                shapes.add(new Rectangle(gc, 10, 10, shapes));
                headFigure = (AbstractFigure) shapes.get(shapes.size() - 1);
                break;
            case TRIANGLE:
                shapes.add(new Triangle(gc, 10, 10, shapes));
                headFigure = (AbstractFigure) shapes.get(shapes.size() - 1);
                break;
        }
    }

    public void changeFigure() {
        if (headFigure != null && shapes.size() > 1) {
            try {
                headFigure = (AbstractFigure) shapes.get(shapes.indexOf(headFigure) + 1);
            } catch (IndexOutOfBoundsException e) {
                headFigure = (AbstractFigure) shapes.get(0);
            }
        }
    }

    public void deleteFigure() {
        if (headFigure != null && shapes.size() > 0) {
            try {
                AbstractFigure tmp = headFigure;
                shapes.remove(headFigure);
                if (shapes.size() > 0) {
                    headFigure = (AbstractFigure) shapes.get(shapes.indexOf(tmp) + 1);
                } else {
                    clean();
                }
            } catch (IndexOutOfBoundsException e) {
                headFigure = (AbstractFigure) shapes.get(0);
            }
        }
    }

    public void cloneFigure() {
        if (headFigure != null) {
            if (headFigure instanceof Ball) {
                shapes.add(new Ball(headFigure));
            } else if (headFigure instanceof Rectangle) {
                shapes.add(new Rectangle(headFigure));
            } else if (headFigure instanceof Triangle) {
                shapes.add(new Triangle(headFigure));
            } else if (headFigure instanceof FiguresGroup) {
                shapes.add(new FiguresGroup(headFigure));
            }
            headFigure = (AbstractFigure) shapes.get(shapes.size() - 1);
        }
    }

    public void increseSize(boolean type) {
        if (headFigure != null) {
            if (type) {
                headFigure.increseSize(true);
            } else {
                headFigure.increseSize(false);
            }
        }
    }

    public void merge(int findX, int findY) {
        for (Shape shape : shapes) {
            if (shape == headFigure) {
                continue;
            }

            if (!(shape instanceof FiguresGroup)) {
                if (checkDistance((AbstractFigure) shape, findX, findY)) {
                    addToGroup((AbstractFigure) shape);
                    break;
                }
            } else {
                for (int j = 0; j < ((FiguresGroup) shape).figuresGroup.size(); j++) {
                    if (checkDistance(((FiguresGroup) shape).figuresGroup.get(j), findX, findY)) {
                        addToGroup((AbstractFigure) shape);
                        break;
                    }
                }
            }
        }
    }

    private boolean checkDistance(AbstractFigure figure, int findX, int findY) {
        return figure.getX() <= findX
                && figure.getX() + figure.getDiameter() >= findX
                && figure.getY() <= findY
                && figure.getY() + figure.getDiameter() >= findY;
    }

    private void addToGroup(AbstractFigure figure) {
        if ((headFigure instanceof FiguresGroup) && (figure instanceof FiguresGroup)) {
            for (int i = 0; i < ((FiguresGroup) figure).figuresGroup.size(); i++) {
                ((FiguresGroup) headFigure).addToGroup(((FiguresGroup) figure).figuresGroup.get(i));
            }
            shapes.remove(figure);
        } else if (headFigure instanceof FiguresGroup) {
            ((FiguresGroup) headFigure).addToGroup(figure);
            shapes.remove(figure);
        } else if (figure instanceof FiguresGroup) {
            ((FiguresGroup) figure).addToGroup(headFigure);
            shapes.remove(headFigure);
            headFigure = figure;
        } else {
            FiguresGroup group = new FiguresGroup(gc, 0, 0, null);

            group.addToGroup(headFigure);
            shapes.remove(headFigure);

            group.addToGroup(figure);
            shapes.remove(figure);

            shapes.add(group);
            headFigure = group;
        }
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}