package utils;

public class EasingMath {


    /**
     * Easing function: Ease-in (quadratic).
     *
     * @param elapsedTime a normalized time value (0 to 1)
     * @return eased value that starts slow and accelerates
     *
     * Example: in(0.5) → 0.25
     * Produces a smooth start by squaring the input: t²
     */
    public static double in(double elapsedTime) {
        return elapsedTime * elapsedTime;
    }

    /**
     * Easing function: Ease-out (quadratic).
     *
     * @param elapsedTime a normalized time value (0 to 1)
     * @return eased value that starts fast and decelerates
     *
     * Example: out(0.5) → 0.75
     * Produces a smooth end using: 1 - (1 - t)²
     */
    public static double out(double elapsedTime) {
        return 1 - (1 - elapsedTime) * (1 - elapsedTime);
    }

    /**
     * Easing function: Ease-in-out (blended).
     *
     * @param elapsedTime a normalized time value (0 to 1)
     * @return eased value that starts slow, speeds up, then slows down again
     *
     * Example: inOut(0.5) → 0.5
     * Uses linear interpolation between the ease-in and ease-out values based on `elapsedTime`.
     * Equivalent to: lerp(in(t), out(t), t)
     */
    public static double inOut(double elapsedTime) {
        return Maths.lerp(in(elapsedTime), out(elapsedTime), elapsedTime);
    }
}
