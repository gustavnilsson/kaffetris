
import se.lth.cs.pt.dots.events.DotWindow;
import se.lth.cs.pt.dots.*;

class TetrisWindow extends DotWindow {

    private int width, height;

    private final Color BACKGROUND = new Color (0, 0, 0);

    private final Color BORDER = new Color(100, 100, 100);

    private final Color BLOCK = new Color(250, 0, 0);
    
    public TetrisWindow(int width, int height) {
	super(width, height, 20);
	fillWith(BACKGROUND);
	this.width = width;
	this.height = height;
	drawBorder();
    }

    private void drawBorder() {
	for(int i = 0; i < height; i++) {
	    setDot(0, i, BORDER);
	    setDot(width-1, i, BORDER);
	}

	for(int i = 0; i < width; i++) {
	    //setDot(i, 0, BORDER);
	    setDot(i, height-1, BORDER);
	}
    }

    public void setDot(int x, int y) {
	setDot(x, y, BLOCK);
    }

    public void resetDot(int x, int y) {
	setDot(x, y, BACKGROUND);
    }

    public boolean dotFree(int x, int y) {
	return BACKGROUND.equals(getDot(x, y));
    }

    
}
