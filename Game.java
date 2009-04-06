import se.lth.cs.pt.dots.events.DotWindow;
import se.lth.cs.pt.dots.events.GameEvent;

/* YEP */

abstract class Game {

    protected TetrisWindow w;
    protected int timeStep;

    public Game(int timeStep) {
	this.timeStep = timeStep;
    }

    public void run() {
	setup();
	mainLoop();
    }

    public void mainLoop() {
	w.checkKeys(true, false, false);
	w.timeStep(timeStep);
	for (;;) {
	    GameEvent event = w.getNextEvent();
	    switch (event.getKind()) {
	    case GameEvent.KEY_PRESSED:
		keyPressed(event.getKeyCode());
		break;
	    case GameEvent.TICK:
		tick();
		break;
	    }     
	}
    }

    public abstract void setup();

    public abstract void keyPressed(int keycode);

    public abstract void tick();

}
