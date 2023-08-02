import java.util.Scanner;

public class MrLee {
    public static int ans=Integer.MAX_VALUE; 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            int graph[][]=new int[n][n];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    graph[i][j]=sc.nextInt();
                }
            }
            boolean visited[] =new boolean[n];
            dfs(graph, 0, 0, visited, 0);
            System.out.println("#"+test_case+" "+ans);
            ans=Integer.MIN_VALUE;
        }
        sc.close();
    }
    public static void dfs(int graph[][], int count,int src, boolean[] visited, int currDist){
        if(count==graph.length-1){
            //Base Case Handle
            if(graph[src][0]!=0){
                ans=Math.min(currDist+graph[src][0], ans);
            }
            return;
        }
        

        visited[src]=true;
        for(int i=0;i<graph.length;i++){
            if(!visited[i] && graph[src][i]!=0){
                dfs(graph,count+1,i,visited,currDist+graph[src][i]);
            }
        }
        visited[src]=false;
    }
}