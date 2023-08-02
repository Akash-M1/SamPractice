import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int testcase=1;testcase<=T;testcase++){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int l=sc.nextInt();
            int region[][]=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    region[i][j]=sc.nextInt();
                }
            }
            if(region[x][y]>0){
                int ans = bfs(region,x,y,l);
                System.out.println(ans);
            }
            else{
                System.out.println(0);
            }
        }
        sc.close();
    }

    public static int bfs(int[][] region,int r,int c,int length){
        int ans=0;
        Queue<Coords> que=new LinkedList<>();
        boolean visited[][]=new boolean[region.length][region[0].length];
        que.add(new Coords(r,c,length));
        visited[r][c]=true;
        while(!que.isEmpty()){
            Coords top=que.remove();
            int x=top.x;
            int y=top.y;
            int l=top.l;
            if(l==0){
                continue;
            }
            ans++;

            if(isLeft(x,y,region) && isValid(x,y-1,region) && isRight(x,y-1,region) && !visited[x][y-1]){
                que.add(new Coords(x,y-1,l-1));
                visited[x][y-1]=true;
            }
            if(isRight(x,y,region) && isValid(x,y+1,region) && isLeft(x,y+1,region) && !visited[x][y+1]){
                que.add(new Coords(x,y+1,l-1));
                visited[x][y+1]=true;
            }
            if(isUp(x,y,region) && isValid(x-1,y,region) && isDown(x-1,y,region) && !visited[x-1][y]){
                que.add(new Coords(x-1,y,l-1));
                visited[x-1][y]=true;
            }
            if(isDown(x,y,region) && isValid(x+1,y,region) && isUp(x+1,y,region) && !visited[x+1][y]){
                que.add(new Coords(x+1,y,l-1));
                visited[x+1][y]=true;
            }
        }
        return ans;
    }

    public static boolean isLeft(int r,int c, int[][] region){
        return (region[r][c]==1 || region[r][c]==3 || region[r][c]==6 || region[r][c]==7);
    }

    public static boolean isRight(int r,int c, int[][] region){
        return (region[r][c]==1 || region[r][c]==3 || region[r][c]==4 || region[r][c]==5);
    }

    public static boolean isUp(int r,int c, int[][] region){
        return (region[r][c]==1 || region[r][c]==2 || region[r][c]==4 || region[r][c]==7);
    }

    public static boolean isDown(int r,int c, int[][] region){
        return (region[r][c]==1 || region[r][c]==2 || region[r][c]==5 || region[r][c]==6);
    }

    public static boolean isValid(int r,int c,int[][]region){
        return r<region.length && r>=0 && c<region[0].length && c>=0;
    }
}

class Coords{
    int x;
    int y;
    int l;
    Coords(int x,int y,int l){
        this.x=x;
        this.y=y;
        this.l=l;
    }
}
