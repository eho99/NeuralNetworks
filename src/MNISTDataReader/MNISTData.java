package MNISTDataReader;

public class MNISTData {

    private int[][] imageData;

    private int numRows, numCols, label;

    public MNISTData(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        this.imageData = new int[numRows][numCols];
    }

    public int getImgVal(int row, int col) {
        return this.imageData[row][col];
    }

    public void setImgVal(int row, int col, int val) {
        this.imageData[row][col] = val;
    }

    public int getLabel() {
        return this.label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumCols() {
        return this.numCols;
    }
}
