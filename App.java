public class App {
    public static void main(String[] args) {
        double[] arr = new double[] {1, 2, 3, 4, 5, 1, 2, -5, 0, 1};
        System.out.println(getMax(arr));
    }
    public double getMax(double [] array){
        if(array.length < 2){
            throw new IllegalArgumentExeption();
        }
        double max = array[0];
        for(int i = 0; i< array.lengh;i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max - array[1];
    }
}