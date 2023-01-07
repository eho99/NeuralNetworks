package Activation;

public class Activations {
    public enum ActivationType {
        Sigmoid,
        ReLU
    }

    public static class ReLu implements Activation {
        @Override
        public double activate(double input) {
            return Math.max(0, input);
        }


        @Override
        public double derivative(double input) {
            return (input > 0) ? 1 : 0;
        }

        @Override
        public ActivationType getActivationType() {
            return ActivationType.ReLU;
        }
    }

    public static class Sigmoid implements Activation {
        public double activate(double input) {
            return 1.0 / (1.0 + Math.exp(-input));
        }

        public double derivative(double input) {
            double s = activate(input);
            return s * (1.0 - s);
        }

        public ActivationType getActivationType() {
            return ActivationType.Sigmoid;
        }
    }

}
