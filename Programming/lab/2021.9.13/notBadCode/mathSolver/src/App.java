
public class App {
    public static void main(String[] args) {
        var chatter = new ResponsePack();

        if (args.length == 0) {
            chatter.documentatin();
            return;
        }
        if (args.length < 5) {
            chatter.notEnoughArgs();
            return;
        }

        int funcNum;

        try {
            funcNum = Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
            chatter.failedToParse();
            return;
        }

        if (funcNum == 1) {
            FirstFuncParam param;
            try {
                param = new FirstFuncParam(args);
            } catch (NumberFormatException e) {
                chatter.failedToParse();
                return;
            } catch (IllegalArgumentException e) {
                chatter.illegalArg();
                return;
            }
            var calc = new FirstFuncCalc();
            var result = calc.calculate(param);
            System.out.println(result);
            return;
        }

        if (funcNum == 2) {
            SecondFuncParam param;
            try {
                param = new SecondFuncParam(args);
            } catch (NumberFormatException e) {
                chatter.failedToParse();
                return;
            } catch (IllegalArgumentException e) {
                chatter.illegalArg();
                return;
            }
            var calc = new SecondFuncCalc();
            var result = calc.calculate(param);
            System.out.println(result);
            return;
        }

        if (funcNum == 3) {
            ThirdFuncParam param;
            try {
                param = new ThirdFuncParam(args);
            } catch (NumberFormatException e) {
                chatter.failedToParse();
                return;
            } catch (IllegalArgumentException e) {
                chatter.illegalArg();
                return;
            }
            var calc = new ThirdFuncCalc();
            var result = calc.calculate(param);
            System.out.println(result);
            return;
        }

    }
}