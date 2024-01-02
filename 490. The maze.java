import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == destination[0] && cur[1] ==destination[1]){
                return true;
            }
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while ( x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}