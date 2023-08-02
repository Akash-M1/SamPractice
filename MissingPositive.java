import java.util.Scanner;

public class MissingPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n=sc.nextInt();
            boolean allNeg = true;
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
                if(arr[i]>0){
                    allNeg = false;
                }
            }
            if(allNeg){
                System.out.println("#"+test_case+" "+1);
                return;
            }
            int ans = getMissingPositive(arr);
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }

    private static int getMissingPositive(int[] arr) {
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]<0){
                i++;
            }
            else if(arr[j]>0){
                j--;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int i1=0;
        for(int k=0;k<arr.length;k++){
            if(arr[k]>=0){
                i1=k;
                break;
            }
        }
        int maxPos = arr.length-i1;

        for(int k=i1;k<arr.length;k++){
            if(Math.abs(arr[k]) >maxPos){
                continue;
            }
            arr[i1+Math.abs(arr[k])-1] = -1 *  Math.abs(arr[i1+Math.abs(arr[k])-1]);
            if(arr[i1+Math.abs(arr[k])-1]==0){
                arr[i1+Math.abs(arr[k])-1] = -100000001;
            }
        }

        boolean ansFound = false;
        int k;
        for(k=i1;k<arr.length;k++){
            if(arr[k]>=0){
                ansFound = true;
                break;
            }
        }
        if(ansFound){
            return (k-i1+1);
        }
        else{
            return maxPos+1;
        }
    }
}
