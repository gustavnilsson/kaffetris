import se.lth.cs.pt.dots.*;

class SquareBlock extends Block {

    public SquareBlock (TetrisWindow w) {
	super(w);
	this.c = new Color(0,255,0);
	int c = w.getWidth()/2;
	this.points.add(new Point(c,0));
	this.points.add(new Point(c,1));
	this.points.add(new Point(c+1,1));
	this.points.add(new Point(c+1,0));
	this.center_y = 1;
	this.center_x = c;
    }

    public boolean rotate() {
	return true;
    }

}
