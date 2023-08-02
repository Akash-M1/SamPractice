import java.util.Scanner;

public class SpaceshipCoins {
    public static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            int arr[][] = new int[n][5];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<5;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            getMaxCoins(arr,0,false,arr.length-1,1,0);
            getMaxCoins(arr,0,false,arr.length-1,2,0);
            getMaxCoins(arr,0,false,arr.length-1,3,0);
            System.out.println("#"+test_case+" "+ans);
            ans = Integer.MIN_VALUE;
        }
        sc.close();
    }
    public static void getMaxCoins(int arr[][], int rowSafe, boolean bombUsed, int curr_row, int curr_col,int coins){
        if(curr_row<0 || curr_col<0 || curr_col>=5){
            ans = Math.max(ans, coins);
            return;
        }
        if(arr[curr_row][curr_col]==0 || arr[curr_row][curr_col]==1){
            if(arr[curr_row][curr_col]==1){
                coins += 1;
            }
            if(bombUsed){
                rowSafe -= 1;
            }
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col,coins);
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col+1,coins);
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col-1,coins);
        }
        else if(arr[curr_row][curr_col]==2){
            if(bombUsed && rowSafe<=0){
                ans = Math.max(ans, coins);
                return;
            }
            if(!bombUsed){
                rowSafe = 4;
                bombUsed = true;
            }
            else{
                rowSafe -= 1;
            }
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col,coins);
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col+1,coins);
            getMaxCoins(arr,rowSafe,bombUsed,curr_row-1,curr_col-1,coins);
        }
    }
}