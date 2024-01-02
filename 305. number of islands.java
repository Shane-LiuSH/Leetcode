
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        DSU dsu = new DSU(row * column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j]) {
                    int pos1 = i * column + j;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= row || y < 0 || y >= column || !grid[x][y]) {
                            continue;
                        }
                        int pos2 = x * column + y;
                        dsu.union(pos1, pos2);
                    }
                }
            }
        }

        Set<Integer> uniqueIslands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j]) {
                    uniqueIslands.add(dsu.find(i * column + j));
                }
            }
        }
        return uniqueIslands.size();
    }
}
class DSU{
    int[] parent;
    public DSU(int num){
        parent = new int[num];
        for(int i = 0; i < num; i++){
            parent[i] = i;
        }
    }
    public int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }
    public void union(int x, int y){
        parent[find(x)] = find(y);
    }
}