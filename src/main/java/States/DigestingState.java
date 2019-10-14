package States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {
    private final int remainingWakeTime;

    DigestingState(int duration, int remaining){
        super(duration);
        remainingWakeTime = remaining;
    }

    @Override
    public State successor(Cat cat) {
        return new PlayfulState(remainingWakeTime - cat.getDigest());
    }
}
