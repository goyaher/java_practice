package com.hgoyal.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal {

    /**
    The first line contains an integer, q , the number of queries.

        Each of the following  sets of lines is as follows:

        The first line contains two space-separated integers, x and y , the number of nodes and the    number of edges.
        Each of the next  lines contains two space-separated integers, p and q, describing an edge connecting node p to node q.
        The last line contains a single integer, s , the index of the starting node.
*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfQueries = s.nextInt();
        
        for (int i=1; i<=noOfQueries; i++)
        {
            int noOfNodes = s.nextInt();
            int noOfEdges = s.nextInt();
            Graph g = new Graph(noOfNodes);
            for (int j=1; j<=noOfEdges; j++)
            {
                int start = s.nextInt(); int end = s.nextInt();
                g.adjM[start][end] = 1;
                g.adjM[end][start] = 1;
            }
            int startNode = s.nextInt();
            
            //at this point graph g is formed and adj matrix populated.
            int[] distance = g.findDistance(startNode);
            
            for (i=1; i<=noOfNodes; i++)
            {
                if (i!=startNode)
                {
                    System.out.print(distance[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        s.close();
    }
}
class Graph
{
    int[][] adjM;
    int v;
    Graph(int v1)
    {
        adjM = new int[v1+1][v1+1];
        this.v = v1;
    }
    
    int[] findDistance(int start)
    {
        int [] visited = new int[v+1];
        int [] distance = new int[v+1]; //distance of node start to all nodes.
        
        for (int i=1; i<=v; i++)
        {
            distance[i] = -1;
        }
        distance[start] = -1;
        visited[start] = 1;
        
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start);
        
        int iteration=1;
        do
        {
            Queue<Integer> currentLevelNodes = new LinkedList<>();
            while (!nodes.isEmpty())
            {
                int current = nodes.remove();
                for (int i=1; i<=v; i++)
                {
                    if (visited[i] != 1)
                    {
                        if (adjM[current][i] == 1)
                        {
                            distance[i] = 6*iteration;
                            visited[i] = 1;
                            currentLevelNodes.add(i);
                        }
                    }
                }
            }
            nodes.addAll(currentLevelNodes);
            currentLevelNodes.clear();
            iteration++;
        }
        while(!nodes.isEmpty());
        
        return distance;
    }
}