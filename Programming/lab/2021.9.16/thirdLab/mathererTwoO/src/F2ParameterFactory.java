public class F2ParameterFactory implements IParameterFactory {
    public IParameter Create(String[] args){
        if (args.length != 2){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        var i = Double.parseDouble(args[0]);
        var t = Double.parseDouble(args[1]);
        return new F2Parameter(i, t);
    }
}
