package MNISTDataReader;

import java.io.*;

public class DataReader {

    /*
    IDX File Format:
    - Magic Number (int)
    - size in dim 0
    - size in dim 1
    - ...
    - size in dim n
    - data

    For MNIST:
    - Magic Number (int)
    - Number of Images (int)
    - Number of rows in each image (int)
    - Number of cols in each image (int)
    - image data sequentially row-wise
     */
    public MNISTData[] readData(String imgPath, String labelPath) throws IOException {

        /// image data stream
        DataInputStream imgStream = new DataInputStream(new BufferedInputStream(new FileInputStream(imgPath)));
        int imgMagicNum = imgStream.readInt();
        int numImages = imgStream.readInt();
        int numRows = imgStream.readInt();
        int numCols = imgStream.readInt();

        /// label data stream
        DataInputStream labelStream = new DataInputStream(new BufferedInputStream(new FileInputStream(labelPath)));
        int labelMagicNum = labelStream.readInt();
        int numLabels = labelStream.readInt();

        MNISTData[] data = new MNISTData[numImages];

        for (int i = 0; i < numImages; ++i) {
            MNISTData mnistData = new MNISTData(numRows, numCols);
            mnistData.setLabel(labelStream.readUnsignedByte());
            for (int row = 0; row < numRows; ++row) {
                for (int col = 0; col < numCols; ++col) {
                    mnistData.setImgVal(row, col, imgStream.readUnsignedByte());
                }
            }
            data[i] = mnistData;
        }
        imgStream.close();
        labelStream.close();

        return data;
    }

}
