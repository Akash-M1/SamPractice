import java.util.Scanner;

public class Bipartite {
    public static boolean isBipartite = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int graph[][] = new int[n][n];
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u][v] = 1;
                graph[v][u] = 1;
            }
            int color[] = new int[n];
            for (int i = 0; i < color.length; i++) {
                color[i] = -1;
            }
            checkBipartite(graph, 0,0,color );
            System.out.println("#"+test_case+" "+isBipartite);
        }
    }
    private static void checkBipartite(int[][] graph, int src, int cc, int[] color) {
        if(color[src]!=-1){
            if(color[src]!=cc){
                isBipartite = false;
            }
            return;
        }

        color[src] = cc;
        for(int i=0;i<graph.length;i++){
            if(graph[src][i]==1){
                checkBipartite(graph, i, Math.abs(1-cc), color);
            }
        }
    }
}