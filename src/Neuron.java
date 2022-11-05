import Activation.Activation;

public class Neuron {
    double[] inputs;
    double[] weights;
    double bias;
    Activation activation;

    public Neuron(double[] inputs, double[] weights, double bias, Activation activation) {
        this.inputs = inputs;
        this.weights = weights;
        this.bias = bias;
        this.activation = activation;
    }

    public double calculateOutput() {
        double output = 0;
        for (int i = 0; i < inputs.length; ++i) {
            output += inputs[i] * weights[i];
        }
        output += this.bias;
        return this.activation.ReLu.Activate(output);
    }

}
