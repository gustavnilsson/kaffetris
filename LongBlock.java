class LongBlock extends Block {

    public LongBlock (TetrisWindow w) {
	super(w);
	int c = w.getWidth()/2;
	this.points.add(new Point(c,0));
	this.points.add(new Point(c,1));
	this.points.add(new Point(c,2));
	this.points.add(new Point(c,3));
	this.center_y = 1;
	this.center_x = c;
    }

}
