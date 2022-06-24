package encryptdecrypt;

public class AlgorithmSimpleFactory {
    private Command command;

    public AlgorithmSimpleFactory(Command command) {
        this.command = command;
    }

    public CryptoAlgorithm getAlgorithmClass() {
        CryptoAlgorithm algorithm = null;
        switch (command.getAlg()) {
            case "unicode":
                algorithm = new Unicode(command.getKey());
                break;
            case "shift":
                algorithm = new Shift(command.getKey());
                break;
            default:
                break;
        }
        return algorithm;
    }
}
