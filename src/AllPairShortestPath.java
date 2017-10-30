/**
 * 全源最短路径Floyd算法，像DijstrIla这类的是单点最短路径算法，全源最短路径算法是单点的一个扩展，时间复杂
 * 度是O（n^3). 方法就是 找到两个点之间的中间点，借助中间点缩短两点之间的距离。
 * graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
 * Created by shuoshuo on 2017/10/30.
 */
public class AllPairShortestPath {
    final static int INF = 99999, V = 4;

    private void floydWarshall(int[][] graph) {
        int m = graph.length, n = graph[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        AllPairShortestPath a = new AllPairShortestPath();

        // Print the solution
        a.floydWarshall(graph);
    }
}
