package curves;

import api.BezierCurve;
import api.InterpolatedValue;
import lombok.SneakyThrows;

import java.util.List;

public class QuadraticCurve<T, I> implements BezierCurve<T, I> {

    private InterpolatedValue<T> start, end;
    private Class<I> interpolatorClass;

    @Override
    public void start(List<T> interpolatedValues, Class<I> interpolatorClass) {
        if (interpolatedValues.size() > 3)
            throw new RuntimeException("Quadratic curves cannot have more than 3 points");

        T start = interpolatedValues.get(0);
        T middle = interpolatedValues.get(1);
        T end = interpolatedValues.get(2);

        this.start = getInstance(interpolatorClass, start, middle);
        this.end = getInstance(interpolatorClass, middle, end);

        this.interpolatorClass = interpolatorClass;
    }

    @Override
    public T interpolate(double time) {
        InterpolatedValue<T> elapsedPose = getInstance(interpolatorClass, start.interpolate(time), end.interpolate(time));

        return elapsedPose.interpolate(time);
    }

    @SneakyThrows
    private InterpolatedValue<T> getInstance(Class<I> interpolatorClass, T... points) {

        InterpolatedValue<T> instance = (InterpolatedValue<T>) interpolatorClass.getConstructor().newInstance();

        if (points != null) {
            instance.start(points[0]);
            instance.end(points[1]);
        }
        return instance;
    }
}