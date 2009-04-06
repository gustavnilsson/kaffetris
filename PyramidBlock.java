import se.lth.cs.pt.dots.*;

/*
*     X
*   X X X
*/

class PyramidBlock extends Block {

    public PyramidBlock (TetrisWindow w) {
	super(w);
	this.c = new Color(255,0,255);
	int c = w.getWidth()/2;
	this.points.add(new Point(c-1,1));
	this.points.add(new Point(c,1));
	this.points.add(new Point(c+1,1));
	this.points.add(new Point(c,0));
	this.center_y = 1;
	this.center_x = c;
    }

}
