import Activation.*;
import Weight.*;

public class Neuron {
    double[] inputs;
    double[] weights;
    double bias;
    Activation activation;

    public Neuron(Activation activation) {
        this.activation = activation;

        this.initBias();
        this.initWeights();
    }

    public double calculateOutput(double[] inputs) {
        this.inputs = inputs;
        double output = 0;

        for (int i = 0; i < inputs.length; ++i) {
            output += inputs[i] * this.weights[i];
        }

        output += this.bias;
        return this.activation.activate(output);
    }

    public void initWeights() {
        Weight w = new Weights.Xavier();
        if (this.activation.getActivationType() == Activations.ActivationType.ReLU) {
            w = new Weights.He();
        }

        this.weights = w.GenerateWeights(this.inputs.length);
    }

    public void initBias() {
        this.bias = Math.random();
    }

}
