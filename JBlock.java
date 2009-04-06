import se.lth.cs.pt.dots.*;

class JBlock extends Block {

    public JBlock (TetrisWindow w) {
	super(w);
	this.c = new Color(0, 255, 255);
	int c = w.getWidth()/2;
	this.points.add(new Point(c,0));
	this.points.add(new Point(c,1));
	this.points.add(new Point(c,2));
	this.points.add(new Point(c-1,2));
	this.center_y = 1;
	this.center_x = c;
    }

}
