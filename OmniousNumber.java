import java.util.Scanner;

public class OmniousNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int testcase=1;testcase<=T;testcase++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int k=sc.nextInt();
            int n=sc.nextInt();

            int delNos[]=new int[n];
            for(int i=0;i<n;i++){
                delNos[i]=sc.nextInt();
            }
            int ans = omniousNumber(delNos, a, b, k);
            System.out.println("#"+testcase+" "+ans);
        }
    }
    public static int omniousNumber(int delNos[],int a,int b,int k){
        int count=0;
        for(int i=a;i<=b;i++){
            int temp=i;
            int digitArr[]=new int[10];
            while(temp>0){
                digitArr[temp%10]++;
                temp/=10;
            }
            int rk=0;
            for (int j = 0; j < delNos.length; j++) {
                rk+=digitArr[delNos[i]];
            }
            if(rk<k){
                count++;
            }
        }
        return count;
    }
}