package api;

import java.util.List;

/**
 * A generic interface for evaluating Bezier curves over a list of control points.
 *
 * @param <T> the type of value being interpolated (e.g., Vector2, Double, Color)
 * @param <I> the type of interpolator used to perform interpolation between T values
 *
 * This interface assumes you use an interpolator class (I) to handle the interpolation logic
 * between two values of type T — e.g., linear, cubic, etc.
 */
public interface BezierCurve<T, I> {

    /**
     * Initializes the curve with a list of control points and an interpolator type.
     *
     * @param values a list of control points (minimum 2, ideally more for cubic or higher-degree curves)
     * @param interpolatorClass the class type of the interpolator to use for intermediate value interpolation
     *
     * The interpolatorClass may be used reflectively to create an instance or passed to a factory.
     */
    void start(List<T> values, Class<I> interpolatorClass);

    /**
     * Evaluates the Bezier curve at the given time.
     *
     * @param time a normalized value from 0 to 1
     * @return the interpolated value on the curve at the specified time
     *
     * Internally, implementations may use De Casteljau’s algorithm or Bernstein polynomials.
     */
    T interpolate(double time);
}
