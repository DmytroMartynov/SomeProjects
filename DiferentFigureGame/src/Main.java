import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 600;
    private static final int FPS = 60;

    private boolean closed;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FIGURES GAME");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.show();
        Logger.log("Game started");


        GraphicsContext gc = canvas.getGraphicsContext2D();
        board = new Board(gc);
        board.draw();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case B:
                    board.addFigure(DiferentFigure.BALL);
                    Logger.log("Ball");
                    break;
                case R:
                    board.addFigure(DiferentFigure.RECTANGL);
                    Logger.log("Rectangl");
                    break;
                case T:
                    board.addFigure(DiferentFigure.TRIANGLE);
                    Logger.log("Triangle");
                    break;
                case ALT:
                    board.changeFigure();
                    Logger.log("change figure");
                    break;
                case MINUS:
                    board.deleteFigure();
                    Logger.log("delete figure");
                    break;
                case UP:
                    board.move(DiferentMoves.UP);
                    break;
                case RIGHT:
                    board.move(DiferentMoves.RIGHT);
                    break;
                case DOWN:
                    board.move(DiferentMoves.DOWN);
                    break;
                case LEFT:
                    board.move(DiferentMoves.LEFT);
                    break;
                case C:
                    board.cloneFigure();
                    Logger.log("copy figure");
                    break;
                case Q:
                    board.increseSize(true);
                    Logger.log("increse size");
                    break;
                case E:
                    board.increseSize(false);
                    Logger.log("decrese size");
                    break;
            }
        });

        scene.setOnMousePressed(event -> {
            if (event.isControlDown()) {
                board.merge((int) event.getSceneX(), (int) event.getSceneY());
            }
        });

        new Thread(this::runMainGameLoopInThread).start();
    }

    @Override
    public void stop() {
        closed = true;
    }


    private void runMainGameLoopInThread() {
        while (!closed) {
            // run in UI thread
            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void drawFrame() {
        board.draw();
    }
}



