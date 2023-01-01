package Cost;

public class Costs {

    public enum CostType {
        MeanSquaredError,
        CrossEntropy;
    }

    public class MeanSquaredError implements Cost {

        @Override
        public double CalcCost(double[] predictedOut, double[] expectedOut) {
            double cost = 0.0;
            for (int i = 0; i < predictedOut.length; ++i) {
                cost += Math.pow(predictedOut[i] - expectedOut[i], 2);
            }
            return cost;
        }

        @Override
        public double Derivative(double predictedOut, double expectedOut) {
            return expectedOut - predictedOut;
        }

        @Override
        public CostType getCostType() {
            return CostType.MeanSquaredError;
        }
    }
}
