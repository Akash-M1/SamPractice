import java.util.Scanner;

public class BaseStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int graph[][] = new int[2*n][m];
            boolean visited[][] = new boolean[2*n][m];
            for(int i=0;i<2*n;i+=2){
                for(int j=0;j<m;j++){
                    if(j%2==0){
                        graph[i][j]=sc.nextInt();
                    }
                    else{
                        graph[i+1][j]=sc.nextInt();
                    }
                }
            }
            int ans = -1;
            for(int i=0;i<n*2;i++){
                for(int j=0;j<m;j++){
                    if(graph[i][j]!=0){
                        int temp = dfs(graph, i, j, visited, 4);
                        int temp1 = upRightCheck(graph, i, j);
                        int temp2 = downLeftCheck(graph, i, j);
                        ans = Math.max(ans, Math.max(temp, Math.max(temp1, temp2)));
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }
    public static int dfs(int graph[][], int r,int c,boolean visited[][], int power){
        if(power==0){
            return 0;
        }
        int dx[] = new int[] {-2,-1,1,2,1,-1};
        int dy[] = new int[] {0,1,1,0,-1,-1};

        visited[r][c] = true;
        int ans = 0;

        for(int k=0;k<6;k++){
            int dr = r+dx[k];
            int dc = c+dy[k];

            if(isValid(graph, dr, dc) && !visited[dr][dc]){
                int temp = dfs(graph, dr,dc,visited,power-1);
                ans = Math.max(temp,ans);
            }
        }

        visited[r][c] = false;
        ans += graph[r][c];

        return ans;
    }

    public static boolean isValid(int[][] graph ,int r, int c){
        return (r>=0 && r<graph.length && c>=0 && c<graph[0].length);
    }

    public static int upRightCheck(int graph[][], int r, int c){
        if(isValid(graph, r+2, c) && isValid(graph, r-1, c+1) && isValid(graph, r-1, c-1)){
            return graph[r][c] + graph[r+2][c] + graph[r-1][c+1] + graph[r-1][c-1];
        }
        else return -1;
    }

    public static int downLeftCheck(int graph[][], int r, int c){
        if(isValid(graph, r-2, c) && isValid(graph, r+1, c+1) && isValid(graph, r+1, c-1)){
            return graph[r][c] + graph[r-2][c] + graph[r+1][c+1] + graph[r+1][c-1];
        }
        else return -1;
    }

}