import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KToggel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int arr[][] = new int[n][m];
            int k=sc.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            HashMap<String,Integer> rowFreq = new HashMap<>();
            for(int i=0;i<n;i++){
                String curr_row = "";
                for(int j=0;j<m;j++){
                    curr_row += arr[i][j];
                }
                if(!rowFreq.containsKey(curr_row)){
                    rowFreq.put(curr_row, 1);
                }
                else{
                    rowFreq.put(curr_row, rowFreq.get(curr_row)+1);
                }
            }
            int ans = Integer.MIN_VALUE;
            for(Map.Entry<String,Integer> entry:rowFreq.entrySet()){
                String row = entry.getKey();
                int freq = entry.getValue();
                int numZeros = 0;
                for(int i=0;i<row.length();i++){
                    if(row.charAt(i)=='0'){
                        numZeros++;
                    }
                }
                if(numZeros<=k && (k-numZeros)%2==0){
                    ans = Math.max(freq, ans);
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
