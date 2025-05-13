package interpolation;


import api.InterpolatedValue;
import utils.Maths;

public class NumberInterpreter implements InterpolatedValue<Number> {

    private Number start, end;

    public NumberInterpreter(Number start, Number end) {
        this.start = start;
        this.end = end;
    }

    public NumberInterpreter() {

    }

    @Override
    public void start(Number start) {
        this.start = start;
    }

    @Override
    public void end(Number end) {
        this.end = end;
    }

    @Override
    public Number interpolate(double time) {
        return Maths.lerp(start, end, time);
    }
}