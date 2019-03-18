import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board   {

    public static GraphicsContext gc;

    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        /*shapes.add(new Ball(gc, 10, 20));
        shapes.add(new Ball(gc, 500, 500));
        shapes.add(new Ball(gc, 400, 400));
        shapes.add(new Ball(gc, 12, 20));
        shapes.add(new Ball(gc, 150, 20));
        shapes.add(new Ball(gc, 330, 400));
        shapes.add(new Ball(gc, 7, 20));
        shapes.add(new Ball(gc, 78, 20));
        shapes.add(new Ball(gc, 87, 400));
        shapes.add(new Ball(gc, 180, 1000));
        shapes.add(new Square(gc, 25, 300));
        shapes.add(new CombineFigure(gc,100,100));*/


            Random random = new Random();
            shapes.add(new CombineFigure(this,gc, 100,100));
            for (int i = 0; i < 5; i++) {
                shapes.add(new Ball(this, gc, random.nextInt(100), random.nextInt(100)));
            }

        }


    public void move() {
        for (Shape shape : shapes) {
            shape.move();

            }
        }



    public void draw() {
        clean();
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    public List<Shape> getShapes() {
        return shapes;
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}

