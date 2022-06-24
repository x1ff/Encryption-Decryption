package encryptdecrypt;

public class Unicode extends CryptoAlgorithm {
    public int key;

    public Unicode(int key) {
        this.key = key;
    }

    @Override
    public void encode() {
        for (int i = 0; i < inData.length; i++) {
            outData[i] = (char) (inData[i] + key);
        }
    }

    @Override
    public void decode() {
        for (int i = 0; i < inData.length; i++) {
            outData[i] = (char) (inData[i] - key);
        }
    }
}
