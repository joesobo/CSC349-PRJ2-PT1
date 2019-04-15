import java.util.Arrays;

public class main{
    public static int[][] matrixProduct(int[][] A, int[][] B){
        int m = b[0].length; //col
        int n = a.length; //row
        int k;
        int[][] arr;

        if(b.length == a[0].length){
            k = b.length;
        }else{
            throw(IllegalArgumentException);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int l = 0; l < k; l++){
                    arr[i][j] = A[i][l] * B[l][j];
                }
            }
        }

        return arr;
    }

    public static void main(String args[]){

    }
}