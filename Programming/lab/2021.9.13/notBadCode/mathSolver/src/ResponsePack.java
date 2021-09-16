public class ResponsePack {
    public void documentatin(){
        System.out.println("This is how you should use this app. Enter 4 arguments, separating them with 'space', which will be used in formula. Use 5th argument to select formula");
    }
    public void notEnoughArgs(){
        System.out.println("Bro, plz gimme all arguments.");
    }
    public void failedToParse(){
        System.out.println("Dude. I know this may surprise you. But... ENTER. NUMBERS. NORMAL.");
    }
    public void illegalArg(){
        System.out.println("Mr. Math. Don't you know that you can't devide my zero, take log from less th... whatever. One of your arguments is making no sence in math. Either learn math or learn math. Gl");
    }
}
