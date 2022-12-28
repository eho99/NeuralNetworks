package Activation;

public class Activations {

    public enum ActivationType {
        Sigmoid,
        ReLU
    }

    public class ReLu implements Activation {
        public double Activate(double input) {
            return Math.max(0, input);
        }

        public double Derivative(double input) {
            return (input > 0) ? 1 : 0;
        }

        public ActivationType getActivationType() {
            return ActivationType.ReLU;
        }
    }

    public class Sigmoid implements Activation {
        public double Activate(double input) {
            return 1.0 / (1.0 + Math.exp(-input));
        }

        public double Derivative(double input) {
            double s = Activate(input);
            return s * (1.0 - s);
        }

        public ActivationType getActivationType() {
            return ActivationType.Sigmoid;
        }
    }

}
