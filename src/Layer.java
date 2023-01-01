import Activation.*;
import Weight.*;

public class Layer {
    int size, incomingNodes, outgoingNodes;

    Neuron[] neurons;
    double[] weights, biases; // weights and biases for this layer

    Activation activation;

    public Layer(int size, Activation activation) {
        this.size = size;
        this.weights = new double[incomingNodes];
        this.biases = new double[size];
        this.neurons = new Neuron[size];
        this.activation = activation;

        this.initWeights();
        this.initBiases();
        this.populate();
    }

    public void populate() {
        for (int i = 0; i < this.biases.length; ++i) {
            this.neurons[i] = new Neuron(this.biases[i], this.activation);
        }
    }

    public double calculateOutputs(double[] inputs) {
        double output = 0;
        for (Neuron neuron : neurons) {
            output += neuron.calculateOutput(inputs, this.weights);
        }
        return output;
    }

    public void initWeights() {
        Weight w = new Weights.Xavier();
        if (this.activation.getActivationType() == Activations.ActivationType.ReLU) {
            w = new Weights.He();
        }

        this.weights = w.GenerateWeights(this.incomingNodes);
    }

    public void initBiases() {
        for (int i = 0; i < this.biases.length; ++i) {
            biases[i] = Math.random();
        }
    }

}

