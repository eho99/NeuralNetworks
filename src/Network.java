import Activation.Activation;

public class Network {
    Layer inputLayer, outputLayer;
    Layer[] hiddenLayers;
    int[] layerSizes;
    Activation[] activations;

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


}
