public class gridMultipier {
    public static void main(String[] args) {
        int [][] arr1 = {{1,1},{2,2},{3,3}};
        int [][] arr2 = {{4,5,6},{4,5,6}};

        int n = arr1[0].length;
        int m = arr2.length;
        int a = arr1.length;
        int [][] arr3 = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                for(int k = 0 ; k < a ; k++) {
                    arr3[i][j] += arr1[k][i] * arr2[j][k];
                } 
            }
        }
        
        for(int [] array: arr3) {
            for(int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
