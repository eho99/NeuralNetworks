import Activation.*;

public class Neuron {
    double[] inputs;
    double[] weights;
    double bias;
    Activation activation;

    public Neuron(double bias, Activation activation) {
        this.bias = bias;
        this.activation = activation;
    }

    public double calculateOutput(double[] inputs, double[] weights) {
        this.inputs = inputs;
        this.weights = weights;
        double output = 0;

        for (int i = 0; i < inputs.length; ++i) {
            output += inputs[i] * weights[i];
        }
        output += this.bias;
        return this.activation.Activate(output);
    }

}
