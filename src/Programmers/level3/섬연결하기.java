package Programmers.level3;// Kruskal Algorithm

import java.util.Arrays;

class 섬연결하기 {
    static int N;
    static int[] parent;

    static final int V1 = 0;
    static final int V2 = 1;
    static final int COST = 2;

    public int solution(int n, int[][] costs) {
        N = n;
        parent = new int[N];
        initParent();
        Arrays.sort(costs, (edge1, edge2) -> edge1[COST] - edge2[COST]);
        int numOfBridgeBuilt = 0;
        int minCost = 0;

        int NUM_OF_EDGES = costs.length;
        for (int i=0;i<NUM_OF_EDGES;i++) {
            // System.out.printf("edge1: %d, edge2: %d, cost: %d\n",costs[i][V1], costs[i][V2], costs[i][COST]);

            if (numOfBridgeBuilt >= N-1) break;
            if (union(costs[i][V1], costs[i][V2])) {
                numOfBridgeBuilt++;
                minCost += costs[i][COST];
                // System.out.println("Bridge Added!");
                // printParent();
            }
        }

        return minCost;
    }

    public static void initParent() {
        for (int i=0;i<N;i++) parent[i] = i;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if ( a == b ) return false;
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    public static void printParent() {
        System.out.printf("----- < Parent > -----\n");
        for (int i=0;i<N;i++) {
            System.out.printf("%d ", parent[i]);
        }
        System.out.println();
    }
}