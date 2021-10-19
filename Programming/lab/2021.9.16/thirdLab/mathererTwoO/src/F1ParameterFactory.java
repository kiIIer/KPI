public class F1ParameterFactory implements IParameterFactory {
    public IParameter Create(String[] args){
        if (args.length != 2){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        var k = Double.parseDouble(args[0]);
        var m = Double.parseDouble(args[1]);
        return new F1Parameter(k, m);
    }
}
