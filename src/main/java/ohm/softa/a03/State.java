package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();

    private int t = 0;

    private final int duration;

    public State(int duration) {
        this.duration = duration;
    }

    public int getTime() {
        return this.t;
    }

    public int getDuration() {
        return this.duration;
    }

    final public State tick(Cat cat){
        if (duration < 0){
            return this;
        }

        t = t+1;

        if(duration > t){
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        }
        else{
            return successor(cat);
        }
    }

    public abstract State successor(Cat cat);
}
