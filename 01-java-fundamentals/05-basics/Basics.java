import java.util.ArrayList;
public class Basics {
    public static void main(String[] args){
        for (int i = 1; i < 256; i++){
            System.out.println(i);
        }
        for (int j = 1; j < 256; j=j+2){
            System.out.println(j);
        }

        int count = 0;
        for (int k=1; k<256; k++){
            count = count +k;
        }
            System.out.println(count);

        int X[] = {1,3,5,7,9,13};
        int i,x;
        for (i = 0; i < X.length; i++){
            x=X[i];
            System.out.println(x);
        }

        int X[] = {-3,-5,-7,-9};
        int i,x;
        for (i = 0; i < X.length; i++){
            x=X[0];
            if (x<X[i]){
                x=X[i];    
            }
            System.out.println(x);
        }

        int x;
        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        for (int j = 1; j < 256; j=j+2){
            oddArray.add(j);
        }
        System.out.println(oddArray);

}
}