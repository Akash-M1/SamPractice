import java.util.Arrays;
public class Solution 
{
	public static String reverseString(String str) 
	{
		int start=0;
		int end=0;
		String s = str.trim();
		String fs = "";
		while(end<s.length()){
			if(s.charAt(end)==' '){
				fs = fs +  s.substring(start,end)+" ";
				System.out.print(fs+" ");
				while(s.charAt(end)==' '){
					end++;
				}
				start=end;
				continue;
			}
			end++;
		}
		// String ans="";
		// String[] ss = fs.split(" ");
		// for(int i=ss.length-1; i>=0;i--){
		// 	ans += ss[i].trim()+" ";
		// }
		return fs;
	}
    public static void main(String[] args) {
        reverseString("Welcome   to Coding Ninjas");
    }
}
