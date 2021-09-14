public class App {
    public static void main(String[] args) {
        

        var param = new FirstFuncParam(args);
        var calc = new FirstFuncCalc();
        var result = calc.calculate(param);

        System.out.println(result);
    }
}