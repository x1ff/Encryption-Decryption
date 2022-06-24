package encryptdecrypt;

public class Shift extends CryptoAlgorithm {
    public int key;
    final public int LETTERS_COUNT = 26;

    Shift(int key) {
        this.key = key % LETTERS_COUNT;
    }

    @Override
    public void encode() {
        for (int i = 0; i < inData.length; i++) {
            outData[i] = shiftForward(inData[i]);
        }
    }

    public char shiftForward(char ch) {
        char result = ch;
        if ((int) ch >= (int) 'a' && (int) ch <= (int) 'z') {
            if ((int) ch + this.key >= 'a' && ch + this.key <= 'z') {
                result = (char) (ch + this.key);
            } else {
                result = (char) (ch + this.key - LETTERS_COUNT);
            }
        } else if ((int) ch >= (int) 'A' && (int) ch <= (int) 'Z') {
            if (ch + this.key >= 'A' && ch + this.key <= 'Z') {
                result = (char) (ch + this.key);
            } else {
                result = (char) (ch + this.key - LETTERS_COUNT);
            }
        }
        return result;
    }

    public char shiftBack(char ch) {
        char result = ch;
        if ((int) ch >= (int) 'a' && (int) ch <= (int) 'z') {
            if (ch - this.key >= 'a' && ch - this.key <= 'z') {
                result = (char) (ch - this.key);
            } else {
                result = (char) (ch - this.key + LETTERS_COUNT);
            }
        } else if (ch >= 'A' && ch <= 'Z') {
            if (ch - this.key >= 'A' && ch - this.key <= 'Z') {
                result = (char) (ch - this.key);
            } else {
                result = (char) (ch - this.key + LETTERS_COUNT);
            }
        }
        return result;
    }

    @Override
    public void decode() {
        for (int i = 0; i < inData.length; i++) {
            outData[i] = shiftBack(inData[i]);
        }
    }
}
