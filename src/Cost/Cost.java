package Cost;

public interface Cost {

    public double CalcCost(double[] predictedOut, double[] expectedOut);

    public double Derivative(double predictedOut, double expectedOut);

    public Costs.CostType getCostType();
}
