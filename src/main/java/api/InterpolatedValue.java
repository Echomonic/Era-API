package api;

/**
 * A generic interface representing an interpolated value of type T over time.
 *
 * @param <T> the type of value to interpolate (e.g., Number, Vector2, Color, etc.)
 *
 * Implementations should define how to interpolate between two values of type T.
 */
public interface InterpolatedValue<T> {

    /**
     * Sets the starting value for interpolation.
     *
     * @param start the initial value
     */
    void start(T start);

    /**
     * Sets the ending value for interpolation.
     *
     * @param end the final value
     */
    void end(T end);

    /**
     * Computes an interpolated value based on the given time.
     *
     * @param time a normalized value (0 to 1) where 0 = start, 1 = end
     * @return the interpolated value at the given time
     *
     * Example: if time = 0.5, returns the midpoint between start and end.
     */
    T interpolate(double time);

}

