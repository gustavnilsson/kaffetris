import java.util.Random;


class TetrisGame extends Game {

    Random rng = new Random();

    Block b;
    
    public TetrisGame () {
	super(200);
	      
    }

    private void newBlock() {
	switch(rng.nextInt(5)) {
	case 0:
	    b = new LongBlock(w);
	    break;
	case 1:
	    b = new SquareBlock(w);
	    break;
	case 2:
	    b = new PyramidBlock(w);
	    break;
	case 3:
	    b = new JBlock(w);
	    break;
	case 4:
	    b = new LBlock(w);
	    break;
	}
	
    }
    
    public void setup() {
	w = new TetrisWindow(10, 30);
	System.out.println("Setup");
	newBlock();
    }


    public void keyPressed (int keycode) {
	switch (keycode) {
	case 39:
	    b.moveRight();
	    break;
	case 37:
	    b.moveLeft();
	    break;
	case 40:
	    b.moveDown();
	    break;
	case 38:
	    b.rotate();
	    break;

	}

    }

    public void tick () {
	if(! b.moveDown()) {
	    newBlock();
	    clearFullRows();
	}

    }

    public void clearFullRows () {
	for(int i = 28; i > 0; i--) {
	    if(rowFull(i)) {
		for (int j = 1; j < 9; j++) {
		    w.resetDot(j, i);
		}
	    }
	}
	
    }

    public boolean rowFull(int row) {
	for (int i = 2; i < 9; i++) {
	if(w.dotFree(i, row)) {
	    return false;
	}}
	return true;
    }



}
