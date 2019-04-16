import java.io.FileReader;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class main{
    public static int[][] matrixProduct(int[][] A, int[][] B){
        int m = B[0].length; //B col
        int n = A.length; //A row
        int k;
        int[][] C = new int[n][m];

        //check for matrix size k to be the same
        if(B.length == A[0].length){
            k = B.length;
        }else{
            throw new IllegalArgumentException("Error: matrix k values did not match");
        }
        
        //matrix multiplication
        for(int i = 0; i < n; i++){ //loop through A row
            for(int j = 0; j < m; j++){ //loop through B col
                for(int l = 1; l < k; l++){ //loop through A & B k value (col & row)
                    C[i][j] = A[i][l] * B[l][j];
                }
            }
        }

        return C;
    }

    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        //int[] list;
        BufferedReader textReader;
        int ax;
        int ay;
        int bx;
        int by;

        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter a matrix file name: ");

        //open file input
        String input = inputReader.nextLine();
        File file = new File(input);

        //loop through file collecting data into list
        try{
            textReader = new BufferedReader(new FileReader(file));
            String text;
            while((text = textReader.readLine()) != null){
                String[] items = text.split(" ");
                for (int i = 0; i < items.length; i++) {
                    list.add(Integer.parseInt(items[i]));
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //creation of matrices
        ax = list.get(0);
        ay = list.get(1);
        bx = list.get(2 + ax * ay);
        by = list.get(3 + ax * ay);

        int[][] A = new int[ax][ay];
        int[][] B = new int[bx][by];

        //fill A
        int count = 2;
        for(int i = 0; i < ax; i++){
            for(int j = 0; j < ay; j++){
                A[i][j] = list.get(count);
                count++;
            }
        }

        //fill B
        count = 4 + ax*ay;
        for(int i = 0; i < bx; i++){
            for(int j = 0; j < by; j++){
                B[i][j] = list.get(count);
                count++;
            }
        }

        //matrixProduct
        //TODO: Add handing for IllegalArgumentException
        int[][] C = matrixProduct(A, B);

        //printout
        System.out.println("Product matrix:");
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < C[0].length; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println("");
        }

        inputReader.close();
    }
}