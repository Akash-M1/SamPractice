public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    ++count;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        int nbRows[] = new int[] {-1,-1,-1,0,0,1,1,1};
        int nbCols[] = new int[] {-1,0,1,-1,1,-1,0,1};
        visited[i][j]=true;
        for(int k=0; k<8;k++){
            if(isSafe((i+nbRows[k]),(j+nbCols[k]),grid,visited)){
                dfs((i+nbRows[k]),(j+nbCols[k]),grid,visited);
            }
        }
    }
    public boolean isSafe(int i, int j, char[][] grid, boolean[][] visited){
        return (i>=0) && (i<grid.length) && (j>=0) && (j<grid[0].length) && (grid[i][j]=='1' && !visited[i][j]);
    }
}