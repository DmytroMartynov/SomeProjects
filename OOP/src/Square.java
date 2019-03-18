import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ConstAndMethods implements Shape {

    private static double DIAMETER = 50;
    public Square(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        initializeRandomMove();
    }

    @Override
    public void draw() {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.fillRect(x, y, DIAMETER, DIAMETER);
        gc.strokeRect(x, y, DIAMETER, DIAMETER);
    }

}

