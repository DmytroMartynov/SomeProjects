import java.util.ArrayList;
import java.util.List;

public class Save {
    private List< Shape > listSaver = new ArrayList<>();
    private int activeShape;

    public Save() {
    }

    public Save(List< Shape > listSaver, int activeShape) {
        this.listSaver = listSaver;
        this.activeShape = activeShape;
    }

    public List< Shape > getlistSaver() {
        return listSaver;
    }

    public void setlistSaver(List< Shape > listSaver) {
        this.listSaver = listSaver;
    }

    public int getActiveShape() {
        return activeShape;
    }

    public void setActiveShape(int activeShape) {
        this.activeShape = activeShape;
    }
}
