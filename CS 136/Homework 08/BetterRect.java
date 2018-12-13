import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * BetterRect
 */
public class BetterRect extends Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    BetterRect(int x, int y, int width, int height){
        super();
        // Save Varibles
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        // Set Supers with saved varibles
        super.setLocation(this.x, this.y);
        super.setSize(this.width, this.height);
    }

    public int getParameter(){
        return 2*(width + height);
    }

    public int getArea(){
        return width * height;
    }
}