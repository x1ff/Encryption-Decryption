package encryptdecrypt;

public class Command {

    private String mode;
    private int key;
    private char[] data;
    private String inFilePath;
    private String outFilePath;
    private String inSource;
    private String alg;

    public Command(String[] args) {
        this.mode = initMode(args);
        this.key = Integer.parseInt(initKey(args));
        this.outFilePath = getParamValue(args, "-out");
        this.data = getParamValue(args, "-data").toCharArray();
        this.inFilePath = getParamValue(args, "-in");
        this.alg = getParamValue(args, "-alg");
        setInSource();
    }

    /**
     * Methods parses args to find param
     *
     * @param args  input String array of params and values
     * @param param - name of param: -mode, -key, -data
     * @return - value of param
     */
    public static String getParamValue(String[] args, String param) {
        for (int i = 1; i < args.length; i++) {
            if (param.equals(args[i - 1])) {
                if (
                        args[i].equals("-mode") || args[i].equals("-key") ||
                                args[i].equals("-data") || args[i].equals("-out") ||
                                args[i].equals("-in") || args.length % 2 == 1
                ) {
                    throw new IllegalArgumentException("Error wrong prams");
                }
                return args[i];
            }
        }
        return "";
    }

    private static String initMode(String[] args) {
        final String DEFAULT_MODE = "enc";
        String mode = getParamValue(args, "-mode");
        if ("".equals(mode)) {
            return DEFAULT_MODE;
        } else {
            return mode;
        }
    }

    private static String initKey(String[] args) {
        final String DEFAULT_KEY = "0";
        String key = getParamValue(args, "-key");
        if ("".equals(key)) {
            return DEFAULT_KEY;
        } else {
            return key;
        }
    }

    private void setInSource() {
        if ("".equals(this.inFilePath) && this.data.length > 0) {
            this.inSource = "console";
        } else if (this.data.length == 0 && !this.inFilePath.equals("")) {
            this.inSource = "file";
        } else if (this.data.length == 0 && this.inFilePath.equals("")) {
            this.inSource = "empty";
        } else {
            this.inFilePath = "";
        }
    }

    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public char[] getData() {
        return data;
    }


    public String getInFilePath() {
        return inFilePath;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public String getInSource() {
        return inSource;
    }

    public String getAlg() {
        return alg;
    }

    public void setInSource(String inSource) {
        this.inSource = inSource;
    }
}
