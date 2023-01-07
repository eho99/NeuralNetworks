import Activation.Activation;
import Cost.*;

public class Network {
    double[] inputs, outputs;
    Layer inputLayer, outputLayer;
    Layer[] hiddenLayers;
    int[] layerSizes;
    Activation[] activations;
    Cost cost = new Costs.MeanSquaredError();

    public Network(int inputSize, int[] layerSizes, int outputSize, Activation[] activations) {
        this.inputLayer = new Layer(inputSize, activations[0]);
        this.layerSizes = layerSizes;
        this.outputLayer = new Layer(outputSize, activations[activations.length - 1]);
        this.activations = activations;

        hiddenLayers = new Layer[layerSizes.length];
        for (int i = 0; i < layerSizes.length; ++i) {
            hiddenLayers[i] = new Layer(layerSizes[i], this.activations[i + 1]);
        }
    }

    public double[] calculateOutputs(double[] inputs) {
        this.inputs = inputs; // storing original inputs
        inputs = this.inputLayer.calculateOutputs(inputs);

        for (Layer l : this.hiddenLayers) {
            inputs = l.calculateOutputs(inputs);
        }

        return this.outputLayer.calculateOutputs(inputs);
    }




}
