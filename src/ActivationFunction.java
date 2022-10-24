public class ActivationFunction {

    public double ReLu(double input) {
        if (input < 0) {
            return 0;
        } else {
            return input;
        }
    }
}

