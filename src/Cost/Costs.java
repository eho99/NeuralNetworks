package Cost;

public class Costs {

    public enum CostType {
        MeanSquaredError, CrossEntropy;
    }

    public static class MeanSquaredError implements Cost {

        public MeanSquaredError() {
        }

        @Override
        public double calcCost(double[] predictedOut, double[] expectedOut) {
            double cost = 0.0;
            for (int i = 0; i < predictedOut.length; ++i) {
                cost += Math.pow(predictedOut[i] - expectedOut[i], 2);
            }
            return cost;
        }

        @Override
        public double derivative(double predictedOut, double expectedOut) {
            return expectedOut - predictedOut;
        }

        @Override
        public CostType getCostType() {
            return CostType.MeanSquaredError;
        }
    }
}
