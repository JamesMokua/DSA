package arrays;

import java.util.Arrays;

public class rotatematrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static boolean rotate(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length){
            return false;
        }
        int n = matrix.length;
        for(int layer = 0; layer< n/2;layer++){//loop through the layers(number of rows)
            int first = layer;
            int last = n-1-layer;//variables to help us loop through cells
            for(int i = first; i <last; i++){//loop through the cells
                int offset = i - first;//find location of the cells
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];//offset here is 0
                matrix[last-offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }

            
        }
        return true;
    }
}
