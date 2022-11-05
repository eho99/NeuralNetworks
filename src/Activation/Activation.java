package Activation;

public class Activation {

    public enum ActivationType {
        Sigmoid,
        ReLU
    }

    public class ReLu implements ActivationInterface {

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



}
