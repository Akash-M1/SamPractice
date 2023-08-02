import java.util.*;
public class WormholeSpaceship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            List<wormhole> coords = new ArrayList<>();
            int graphIndex =1;
            int nwh = sc.nextInt();
            wormhole src = new wormhole(sc.nextInt(), sc.nextInt());
            coords.add(src);
            wormhole dest = new wormhole(sc.nextInt(), sc.nextInt());
            int graph[][] = new int[2*nwh+2][2*nwh+2];
            for(int i=0;i<graph.length;i++){
                for(int j=0;j<graph[0].length;j++){
                    graph[i][j] = -1;
                }
            }
            for(int i=0;i<nwh;i++){
                wormhole wsrc = new wormhole(sc.nextInt(), sc.nextInt());
                coords.add(wsrc);
                wormhole wdest = new wormhole(sc.nextInt(), sc.nextInt());
                coords.add(wdest);
                int dist = sc.nextInt();
                graph[graphIndex][graphIndex+1] = dist;
                graph[graphIndex+1][graphIndex] = dist;
                graphIndex+=2;
            }
            coords.add(dest);
            for(int i=0;i<graph.length;i++){
                graph[0][i] = distance(coords.get(0).x, coords.get(0).y, coords.get(i).x, coords.get(i).y);
                graph[graph.length-1][i] = distance(coords.get(graph.length-1).x, coords.get(graph.length-1).y, coords.get(i).x, coords.get(i).y);
            }

            for(int i=1;i<graph.length-1;i++){
                for(int j=0;j<graph[0].length;j++){
                    if(i==j){
                        graph[i][j] = 0;
                    }
                    else{
                        if(i%2==1){
                            graph[i][j] = graph[i][i+1] + distance(coords.get(i+1).x,coords.get(i+1).y,coords.get(j).x,coords.get(j).y);
                        }
                        else{
                            graph[i][j] = graph[i][i-1] + distance(coords.get(i-1).x,coords.get(i-1).y,coords.get(j).x,coords.get(j).y);
                        }
                    }
                }
            }
            graph[0][graph.length-1] = distance(coords.get(0).x, coords.get(0).x, coords.get(graph.length-1).x, coords.get(graph.length-1).y);
            graph[graph.length-1][0] = distance(coords.get(0).x, coords.get(0).x, coords.get(graph.length-1).x, coords.get(graph.length-1).y);
            boolean visited[] = new boolean[graph.length];
            getMinDistance(graph,0,(graph.length-1),visited,0);
            System.out.println(ans);
            ans=Integer.MAX_VALUE;
        }
        sc.close();
    }
    public static int ans = Integer.MAX_VALUE;
    private static void getMinDistance(int[][] graph, int src, int dest, boolean[] visited, int currDist) {
        if(src==dest){
            ans = Math.min(ans, currDist);
        }
        if(visited[src]){
            return;
        }
        visited[src] = true;
        for(int i=0;i<graph.length;i++){
            getMinDistance(graph, i, dest, visited, currDist+graph[src][i]);
        }
        visited[src] = false;
    }
    public static int distance(int x1,int y1,int x2,int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}

class wormhole{
    int x;
    int y;
    wormhole(int x,int y){
        this.x = x;
        this.y = y;
    }
}