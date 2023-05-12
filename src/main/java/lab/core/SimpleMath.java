package lab.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for calculating integral
 *
 * @author BarbaraKorpak
 * @version 1.2
 */
public class SimpleMath {

    /**
     * Declare a private list to store the trapezoidal area
     */
    private List<Double> areaTrapezoidal = new ArrayList<>();

    /**
     * Method calculates integral
     *
     * @param min lower limit of integral
     * @param max upper limit of integral
     * @param numberOfTrapezoids calculation accuracy
     * @throws IncorrectParamsException exception with wrong parameters
     * @return integral value
     */
    public double integral(double min, double max, int numberOfTrapezoids) throws IncorrectParamsException {
        if (min >= max) {
            throw new IncorrectParamsException("min has to be less than max");
        }
        if (numberOfTrapezoids <= 0) {
            throw new IncorrectParamsException("You can't divide by 0 and accuracy can't be negative. Please run program with correct parameters");
        }
        double height = (max - min) / numberOfTrapezoids;
        double sum = 0;
        for (double i = min; i < max; i = i + height) {
            double result = (functionValue(min) + functionValue(min + height)) * height * 0.5;
            areaTrapezoidal.add(result);
            sum += result;
            min = min + height;

        }

        return sum;

    }

    /**
     * A method that allows you to pass a list from the model to the controller
     *
     * @return trapezoidal area
     */
    public List<Double> getAreaTrapezoidal() {
        return areaTrapezoidal;
    }

    /**
     * A method that returns a function value for a given argument.
     *
     * @param x function argument
     * @return function value
     */
    private double functionValue(double x) {

        return 2 * x + 5;
    }
}
