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
            this.neurons[i] = new Neuron(this.activation);
        }
    }

    public double[] calculateOutputs(double[] inputs) {
        double[] outputs = new double[this.outgoingNodes];

        double layerActivation = 0;
        for (Neuron neuron : neurons) {
            layerActivation += neuron.calculateOutput(inputs);
        }

        for (int i = 0; i < outputs.length; ++i) {
            outputs[i] = layerActivation;
        }

        return outputs;
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

