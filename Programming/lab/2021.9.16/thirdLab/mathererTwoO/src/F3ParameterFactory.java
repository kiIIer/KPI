public class F3ParameterFactory implements IParameterFactory {
    public IParameter Create(String[] args){
        if (args.length != 1){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        var e = Double.parseDouble(args[0]);
        return new F3Parameter(e);
    }
}
