import java.util.Scanner;

public class BurstBallons {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n+2]; 
        for(int i=1;i<=n;i++){
            nums[i]=sc.nextInt();
        }
        nums[0]=1;
        nums[nums.length-1]=1;
        int dp[][]=new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j]=-1;
            }
        }
        int ans=maxCoins(nums,dp,1,nums.length-2);
    }

    private static int maxCoins(int[] nums, int[][] dp,int l,int r) {
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        dp[l][r]=0;
        for (int i = l; i <= r; i++) {
            int coins=nums[l-1]*nums[i]* nums[r+1];
            coins+=maxCoins(nums,dp,l,i-1) * maxCoins(nums,dp,i+1,r);
            dp[l][r]=Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
