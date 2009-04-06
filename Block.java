import se.lth.cs.pt.dots.*;
import java.util.*;

class Block {

    protected TetrisWindow w;

    protected int center_x, center_y;

    protected List<Point> points = new LinkedList<Point>();

    protected int nbrOfRots;

    protected Color c;
    
    public Block (TetrisWindow w) {
	this.w = w;
	c = new Color(255,0,0);
	redraw();
	
    }

    public boolean moveDown() {
	if (!possibleMove(0, 1)) {
	    return false;
	}
	removeBlocks();
	for (Point p : points) {
	    p.addY();
	}
	center_y++;
	redraw();
	return true;
    }

    public boolean moveRight() {
	
	if (!possibleMove(1, 0)) {
	    return false;
	}
	center_x++;
	removeBlocks();
	for (Point p : points) {
	    p.addX();
	}

	redraw();
	return true;
    }

    public boolean moveLeft() {
	if (!possibleMove(-1, 0)) {
	    return false;
	}
	center_x--;
	removeBlocks();
	for (Point p : points) {
	    p.subX();
	}

	redraw();
	return true;
    }

    

    public boolean rotate() {
	List <Point> pn = new LinkedList<Point>();

	
	for(Point p : points) {
	    int newx = center_x, newy = center_y;
	    switch(nbrOfRots) {
	    case 0:
		newx += p.getY()-center_y;
		newy += p.getX()-center_x;
		break;
	    case 1:
		newx += center_y - p.getY();
		newy += center_x - p.getX();
		break;
	    case 2:

		newx -= center_y - p.getY();
		newy -= center_x - p.getX();

		break;
	    case 3:
		newx -= p.getY()-center_y;
		newy -= p.getX()-center_x;		
		break;
	    }
	    if(!dotFree(newx, newy)) {
		return false;
	    }
	    pn.add(new Point(newx, newy));
	}
	removeBlocks();
	points = pn;
	redraw();
	nbrOfRots = ++nbrOfRots % 4;
	return true;
    }

    private boolean dotFree(int x, int y) {
	    if(w.dotFree(x,y) || eigenPoint(x,y) ) {
		return true;
	    }
	    return false;
    }

    private boolean possibleMove(int relX, int relY) {
	for (Point p : points) {
	    if(!dotFree(p.getX()+relX, p.getY() + relY)) {
		return false;
	    }
	}
	return true;
    }

    private boolean eigenPoint(int x, int y) {
	for (Point p : points) {
	    if(p.getX() == x && p.getY() == y) {
		return true;
	    }
	}
	return false;
    }
    
    private void redraw() {
	for(Point p : points) {
	    w.setDot(p.getX(),p.getY(),c);
	}
    }

    private void removeBlocks() {
	for (Point p : points) {
	    w.resetDot(p.getX(), p.getY());
	}
    }

}


