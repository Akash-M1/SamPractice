import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycle {
    public static int numCycles=0;
    public static ArrayList<ArrayList<Integer>> cycles;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n=sc.nextInt();
            
        }
    }
    public static boolean detectCycle(int graph[][],int src, boolean visited[],int prev[], int parent){
        visited[src]=true;

        for(int i=0;i<graph.length;i++){
            if(graph[src][i]==1 && !visited[src]){
                if(detectCycle(graph, src, visited, prev,src)){
                    if(prev[0]==src){
                        System.out.print(src+" ");
                        prev[0]=-1;
                    }
                    else if(prev[0]!=-1){
                        System.out.print(src+" ");
                    }
                    return true;
                }
            }
            else if(graph[src][i]==1 && visited[src] &&  parent!=i){
                System.out.println(src);
                prev[0]=i;
                return true;
            }
        }
        return false;
    }


    public static boolean detectDirCycle(int graph[][],boolean[] visited,int src, int prev[],boolean inloop[]){
        visited[src]=true;
        inloop[src]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[src][i]==1 && !visited[src]){
                if(detectDirCycle(graph, visited, i, prev, inloop)){
                    if(i==prev[0]){
                        System.out.print(i+" ");
                        prev[0]=-1;
                    }
                    else if(prev[0]!=-1){
                        System.out.print(i+" ");
                    }
                    return true;
                }
            }
            else if(inloop[i]){
                prev[0]=i;
                return true;
            }
        }
        inloop[src]=false;
        return false;
    }

    public static void detectCycleAll(int graph[][],int color[],int parent[],int src,int p){
        if(color[src]==2){
            return;
        }

        if(color[src]==1){
            ArrayList<Integer> arr=new ArrayList<>();
            int curr=p;
            arr.add(curr);
            while(curr!=src){
                curr=parent[curr];
                arr.add(curr);
            }
            cycles.add(numCycles, arr);
            numCycles++;
        }

        color[src]=1;
        parent[src]=p;
        for (int i = 0; i < graph.length; i++) {
            if(i==parent[src]){
                continue;
            }
            detectCycleAll(graph, color, parent, i, src);
        }
        color[src]=2;
    }
}
