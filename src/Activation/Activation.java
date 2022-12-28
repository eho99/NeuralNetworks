package Activation;

public interface Activation {

    public double Activate(double input);

    public double Derivative(double input);

    public Activations.ActivationType getActivationType();

}