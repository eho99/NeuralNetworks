package Cost;

public interface Cost {

    public double calcCost(double[] predictedOut, double[] expectedOut);

    public double derivative(double predictedOut, double expectedOut);

    public Costs.CostType getCostType();
}
