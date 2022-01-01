class NumberOfIslands {
    public int numIslands(char[][] grid) {
      
        // if the grid is null or has zero elements, end the algorithm and return 0;
        if(grid.length == 0 || grid == null) {
            return 0;
        }
      
        int count = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                // Recursively call a helper function that searchs using depth first search
                count += dfs(grid, i, j);
            }
        }
        return count;
    }
    
    private int dfs(char grid[][], int i, int j) {
        // if the grid position is out of bounds or already a '0', as in not an island, return 0 so the count isn't incremented.
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        // else the '1' gets changed to a '0' to keep account of it being visited.
        grid[i][j] = '0';
      
        // Check the values in four directions
        dfs(grid, i - 1, j); // left
        dfs(grid, i + 1, j); // right
        dfs(grid, i, j + 1); // up
        dfs(grid, i, j - 1); // down
        
        // An island has been found, therefore increase the count
        return 1;
    }
}
