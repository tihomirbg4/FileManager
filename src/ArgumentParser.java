public class ArgumentParser {
    private String[] args;

    public ArgumentParser(String[] args) {
        this.args = args;
    }

    public String getFilePath() throws TooManyArgumentsException, TooFewArgumentsException {
        if(args.length > 1)
        {
            throw new TooManyArgumentsException("Too many arguments, only 1 is required");
        }
        else if(args.length == 0)
        {
            throw new TooFewArgumentsException("Too few arguments, only 1 is required");
        }

        return args[0];
    }
}
