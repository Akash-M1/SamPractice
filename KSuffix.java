import java.util.Scanner;
public class KSuffix
{
    public static String kthSuffix(String str, int k){
        String arr[] = new String[str.length()];
        String temp = str;
        for(int i=0;i<arr.length;i++){
            arr[i] = temp;
            temp = temp.substring(1);
        }
        for(int i=1;i<arr.length;i++){
            String nE = arr[i];
            int j;
            for(j=i; j>0;j--){
                if(arr[j-1].charAt(0) > nE.charAt(0)){
                    arr[j] = arr[j-1];
                }
                else if(arr[j-1].charAt(0) == nE.charAt(0)){
                    boolean flag = true;
                    for(int temp1 = 0; temp1<arr.length && temp1<arr[j-1].length() && temp1<nE.length(); temp1++){
                        if(arr[j-1].charAt(temp1) < nE.charAt(temp1)){
                            flag = false;
                            break;
                        }
                        if(arr[j-1].charAt(temp1) > nE.charAt(temp1)){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        arr[j] = arr[j-1];
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
            arr[j] = nE;
        }
        return arr[k-1];
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //int T = sc.nextInt();
        String ver = sc.next();
        System.out.println(ver);
        // for(int test_case = 1; test_case <=T; test_case++)
        // {
        //     int k=sc.nextInt();
        //     String str = sc.next();
        //     String ans = kthSuffix(str,k);
        //     System.out.println("#"+test_case+" "+ans);
        // }
    }
}