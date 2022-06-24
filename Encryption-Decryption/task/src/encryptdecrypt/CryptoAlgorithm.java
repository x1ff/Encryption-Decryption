package encryptdecrypt;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public abstract class CryptoAlgorithm {
    public char[] inData;
    public char[] outData;

    public abstract void encode();

    public abstract void decode();

    public void setDataIn(Command command) throws FileNotFoundException {
        if (command.getInSource().equals("console")) {
            inData = command.getData();
        } else if (command.getInSource().equals("file")) {
            File inFile = new File(command.getInFilePath());
            try (Scanner sc = new Scanner(inFile)) {
                inData = sc.nextLine().toCharArray();
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Error " + e);
            }
        }
    }

    public void outData(Command command) throws IOException {
        if (command.getOutFilePath().isEmpty()) {
            System.out.println(String.copyValueOf(this.outData));
        } else {
            File outFile = new File(command.getOutFilePath());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
                writer.write(outData);
            } catch (IOException e) {
                throw new IOException("Error: " + e);
            }
        }
    }

    public void exec(Command command) throws IOException {
        setDataIn(command);
        outData = new char[inData.length];
        if (command.getMode().equals("enc")) {
            encode();
        } else if (command.getMode().equals("dec")) {
            decode();
        }
        outData(command);
    }
}
