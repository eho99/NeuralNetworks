package Weight;

public class Weights {

    public enum WeightType {
        Xavier, // non linear activations (Sigmoid, etc.)
        He; // ReLu activation
    }

    public static class Xavier implements Weight {

        public Xavier() {
        }

        @Override
        public double[] GenerateWeights(int numNodesIn) {
            double lower = -(1.0 / Math.sqrt(numNodesIn)), upper = (1.0 / Math.sqrt(numNodesIn));
            double[] weights = new double[numNodesIn];

            for (int i = 0; i < numNodesIn; ++i) {
                weights[i] = (Math.random() * (upper - lower)) + lower;
            }

            return weights;
        }

        @Override
        public WeightType getWeightType() {
            return WeightType.Xavier;
        }
    }


    public static class He implements Weight {

        public He() {
        }

        @Override
        public double[] GenerateWeights(int numNodesIn) {
            double scale = Math.sqrt(2.0 / numNodesIn);
            double[] weights = new double[numNodesIn];

            for (int i = 0; i < numNodesIn; ++i) {
                weights[i] = Math.random() * scale;
            }

            return weights;
        }

        @Override
        public WeightType getWeightType() {
            return WeightType.He;
        }
    }

}
