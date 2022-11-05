package Activation;

public interface ActivationInterface {

    public double Activate(double input);

    public double Derivative(double input);

    public Activation.ActivationType getActivationType();

}