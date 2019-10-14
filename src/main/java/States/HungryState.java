package States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {

    public HungryState(int duration){
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        return new DeathState();
    }

    public State feed(Cat cat){
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
