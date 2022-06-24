package encryptdecrypt;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Command command = new Command(args);

        AlgorithmSimpleFactory factory = new AlgorithmSimpleFactory(command);
        factory.getAlgorithmClass().exec(command);
    }
}

