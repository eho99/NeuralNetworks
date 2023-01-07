package Activation;

public interface Activation {

    public double activate(double input);

    public double derivative(double input);

    public Activations.ActivationType getActivationType();

}