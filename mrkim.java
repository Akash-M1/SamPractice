import java.util.*;

public class MrKim {
    public static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            List<List<Integer>> coords = new ArrayList<>();
            List<Integer> src = new ArrayList<>();
            src.add(sc.nextInt());
            src.add(sc.nextInt());
            coords.add(src);
            List<Integer> dest = new ArrayList<>();
            dest.add(sc.nextInt());
            dest.add(sc.nextInt());
            for(int i =0;i<n;i++){
                List<Integer> office = new ArrayList<>();
                office.add(sc.nextInt());
                office.add(sc.nextInt());
                coords.add(office);
            }
            coords.add(dest);
            int graph[][] = new int[n+2][n+2];
            for(int i =0;i<graph.length;i++){
                for(int j=0;j<graph[0].length;j++){
                    if(i==j || j==0 || i==graph.length-1 || (i==0 && j==graph.length-1)){
                        graph[i][j]=0;
                        continue;
                    }
                    graph[i][j]=distance(coords.get(i), coords.get(j));
                }
            }
            boolean visited[] = new boolean[n+2];
            getMinDistance(graph, visited, 0, 0,0,n);
            System.out.println("#"+test_case+" "+ans);
            ans=Integer.MIN_VALUE;
        }
        sc.close();
    }


    public static int distance(List<Integer> ord1, List<Integer> ord2){
        int distance = 0;
        distance = Math.abs(ord1.get(0)-ord2.get(0))+Math.abs(ord1.get(1)-ord2.get(1));
        return distance;
    }

    public static void getMinDistance(int graph[][],boolean visited[],int src, int currDist,int nodes,int n){
        if(nodes==n){
            ans = Math.min(ans,currDist+graph[src][n+1]);
        }
        if(visited[src]){
            return;
        }
        visited[src]=true;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                getMinDistance(graph, visited, i, currDist+graph[src][i],nodes+1,n);
            }
        }
        visited[src]=false;
    }
}