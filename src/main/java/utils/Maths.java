package utils;

public class Maths {

    // A very small value used for floating-point comparisons to avoid precision errors.
    public static final double EPSILON = 1e-10;

    /**
     * Linearly interpolates between two numbers.
     *
     * @param start the starting value
     * @param end   the ending value
     * @param time  a value between 0 and 1 representing the interpolation factor
     * @return the interpolated double value
     *
     * Example: lerp(10, 20, 0.5) → 15
     * If time < 0 or > 1, the method will extrapolate beyond the range.
     */
    public static double lerp(Number start, Number end, double time){
        return (start.doubleValue() + (end.doubleValue() - start.doubleValue()) * time);
    }

    /**
     * Flips a value in the [0, 1] range.
     *
     * @param elapsedTime a normalized time value (0 to 1)
     * @return 1 - elapsedTime, effectively reversing progress
     *
     * Example: flip(0.25) → 0.75
     * Useful for reversing animation curves or progress.
     */
    public static double flip(double elapsedTime) {
        return 1 - elapsedTime;
    }

    /**
     * Calculates the number of decimal places in a double.
     *
     * @param decimal the double value to check
     * @return number of digits after the decimal point
     *
     * Example: getPrecision(3.14159) → 5
     * Note: This is based on string conversion, so floating-point imprecision may affect results.
     */
    public static int getPrecision(double decimal) {
        String doubleString = Double.toString(decimal);
        int index = doubleString.indexOf('.');
        return doubleString.length() - index - 1;
    }

    /**
     * Zeroes out very small values close to 0 to avoid floating-point noise.
     *
     * @param value   the value to sanitize
     * @param epsilon the threshold below which the value is considered zero
     * @return 0.0 if |value| < epsilon, otherwise returns the value
     *
     * Example: sanitize(1e-11, 1e-10) → 0.0
     * This is useful for avoiding issues with tiny residuals in floating-point math.
     */
    public static double sanitize(double value, double epsilon) {
        return Math.abs(value) < epsilon ? 0.0 : value;
    }
}
