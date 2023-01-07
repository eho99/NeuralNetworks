import Activation.*;

public class MNISTModel {

    Network net = new Network(25, new int[]{25, 25}, 10, new Activation[]{
            new Activations.ReLu(), new Activations.ReLu(), new Activations.ReLu(), new Activations.ReLu()});

    public MNISTModel() {

    }
}
