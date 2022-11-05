public class Layer {
    int size;
    Neuron[] neurons;

    public Layer(int size) {
        this.size = size;
    }

    public void populate(Neuron[] neurons) {
        this.neurons = neurons;
    }
    public double calculateOutput() {
        double output = 0;
        for (Neuron neuron : neurons) {
            output += neuron.calculateOutput();
        }
        return output;
    }


}
