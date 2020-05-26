import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Graph  {
  private int N; // number of vertex
  private ArrayList<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();  // adjacency list

  Graph() { }

  Graph(int n) {
    this.initGraph(n);
  }

  /* This function initialize the adjacency list */
  private void initGraph(int n) {
    this.N = n;
    for (int i = 0; i < n; ++i) {
      this.adjList.add(new LinkedList<Integer>());
    }
  }

  // function to add an edge between two nodes
  public void addEdge(int v1,int v2)  {
    this.adjList.get(v1).add(v2);
    this.adjList.get(v2).add(v1);
  }

  public void printGraph() {
    for (int i = 0; i < this.adjList.size(); i++) {
      Iterator<Integer> j = this.adjList.get(i).listIterator();
      while (j.hasNext()) {
        int n = j.next();
        System.out.println(i + ", " + n);
      }
    }

    System.out.println("N: " + this.N);
  }

  public void getDegreeDistribution() {
    int maxDegree = 0;
    float[] graphDegrees = new float[this.adjList.size()];

    for (int i = 0; i < this.adjList.size(); i++) {
      graphDegrees[i] = (float)this.adjList.get(i).size();

      if (maxDegree < graphDegrees[i]) {
        maxDegree = (int)graphDegrees[i];
      }
    }

    for (int i = 0; i < graphDegrees.length; i++) {
      graphDegrees[i] = graphDegrees[i] / (float)maxDegree;
      System.out.println(graphDegrees[i]);
    }

    // System.out.println("######");
    // System.out.println(maxDegree);
  }

  /* 
   * BFS
   */
  public void BFS() {
    boolean visited[] = new boolean[this.N];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    int connectedComponents = 0;
    

    for (int i = 0; i < this.adjList.size(); i++) {

      if (!visited[i]) {
        int sizeComponent = 0;

        visited[i] = true;
        queue.add(i);

        while (queue.size() != 0) {
          int tmp = queue.pop();
          Iterator<Integer> idx = this.adjList.get(tmp).listIterator();

          while (idx.hasNext()) {
            int n = idx.next();

            if (!visited[n] || visited[n] == false) {
              visited[n] = true;
              queue.add(n);

              sizeComponent++;
            }
          }
        }

        System.out.println(sizeComponent);
        connectedComponents++;
      }
    }

    System.out.println("#################");
    System.out.println(connectedComponents);
  }

  /* 
   * DFS
   */
  void DFS()  {
    boolean[] visited = new boolean[this.N];
    LinkedList<Integer> stack = new LinkedList<Integer>();

    int connectedComponents = 0;

    for (int i = 0; i < this.adjList.size(); i++) {

      if (!visited[i]) {
        int sizeComponent = 0;

        int s = i;
        stack.push(s);

        while (stack.size() != 0) {
          s = stack.peek();
          stack.pop();
            
          if (!visited[s]) {
            visited[s] = true;
          }

          Iterator<Integer> itr = this.adjList.get(s).iterator();
            
          /* LOOP here? */
          while (itr.hasNext()) {
            int v = itr.next();
            if (!visited[v] && !stack.contains(v)) {
              sizeComponent++;
              stack.push(v);
              visited[v] = true;
            }
          }
        }

        // System.out.println(sizeComponent);
        connectedComponents++;
      }
    }

    System.out.println();
    System.out.println("#################");
    System.out.println(connectedComponents);
  } 


  public static void main(String[] args) {
    Graph g = GraphIO.read(args[0]);

    // g.printGraph();
    // g.getDegreeDistribution();
    // g.BFS();
    // g.DFS();

    System.out.println("# Starting algorithm");

    long startTime = System.currentTimeMillis();

    g.DFS();

    long endTime = System.currentTimeMillis();
    System.out.println("Algorithm time: " + (endTime - startTime) + " milliseconds");
    System.out.print("Memory: ");
    System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
  }

}

class GraphIO {
  static Graph read(String filename) {
    ArrayList<Integer> edges = new ArrayList<Integer>();
    Set<Integer> vertex = new HashSet<Integer>();


    // read the file and save the vertex into "edges"
    try {

      // read the file
      File file = new File(filename);
      Scanner reader = new Scanner(file);

      while (reader.hasNextLine()) {
        String data = reader.nextLine();

        // read each line and split it asing on the following structure "v1,v2"
        // where v1 -> v2 is the edge
        String[] edge = data.replaceAll("\\s+","").split(",");

        int e1 = Integer.parseInt(edge[0]);
        int e2 = Integer.parseInt(edge[1]);
        vertex.add(e1);
        vertex.add(e2);
        edges.add(e1);
        edges.add(e2);
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");

      e.printStackTrace();
      return null;
    }

    // generate the graph using the "edges" array
    Graph g = new Graph(vertex.size());
    for (int i = 0; i < edges.size(); i += 2) {
      g.addEdge(edges.get(i), edges.get(i + 1));
    }

    return g;
  }
}
