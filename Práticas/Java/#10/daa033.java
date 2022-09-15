// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)
// (codigo adaptado do codigo em C++ feito na teorica)

import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    double weight; // Peso da aresta
    
    Edge(int t, double w) {
	to = t;
	weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public double distance;         // Distancia ao no origem da pesquisa
    
    Node() {
	adj = new LinkedList<>();
    } 
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public double cost;
    public int node;

    NodeQ(double c, int n) {
	cost = c;
	node = n;
    }

    @Override
    public int compareTo(NodeQ nq) { 
        if (cost < nq.cost) return -1; 
        if (cost > nq.cost) return +1;
	if (node < nq.node) return -1; 
	if (node > nq.node) return +1;
        return 0; 
    } 
}

// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos
    
    Graph(int n) {
	this.n = n;
	nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
	for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
    }
    
    void addLink(int a, int b, double c) {
	nodes[a].adj.add(new Edge(b, c));
    }

    // Algoritmo de Dijkstra
    void dijkstra(int s) {
	
	//Inicializar nos como nao visitados e com distancia infinita
	for (int i=1; i<=n; i++) {
	    nodes[i].distance = Integer.MAX_VALUE;
	    nodes[i].visited  = false;
	}
	
	// Inicializar "fila" com no origem
	nodes[s].distance = 0;
	TreeSet<NodeQ> q = new TreeSet<>();
	q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

	// Ciclo principal do Dijkstra
	while (!q.isEmpty()) {
      
	    // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
	    NodeQ nq = q.pollFirst();
	    int  u = nq.node;
	    nodes[u].visited = true;
	    //System.out.println(u + " [dist=" + nodes[u].distance + "]");
	    
	    // Relaxar arestas do no retirado
	    for (Edge e : nodes[u].adj) {
		int v = e.to;
		double cost = e.weight;
		if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
		    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
		    nodes[v].distance = nodes[u].distance + cost;
		    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
		}
	    }
	}
    }
};


public class dijkstra {      
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in).useLocale(Locale.US);
	int n = in.nextInt();
	Graph g = new Graph(n);
	int e = in.nextInt();
	int ind = 1;
	String origem = in.next();
	String destino = in.next();
	TreeMap<String, Integer> locais = new TreeMap<>();
	locais.put(origem, ind++);
	locais.put(destino, ind++);
	
	for (int i=0; i<e; i++){
	    String ponto1 = in.next();
	    String ponto2 = in.next();
	    double distancia = in.nextDouble();
	    //System.out.println(ponto1 + " " + ponto2 + " " + distancia);

	    if(!locais.containsKey(ponto1))
		locais.put(ponto1, ind++);

	    if(!locais.containsKey(ponto2))
		locais.put(ponto2, ind++);
	    
	    g.addLink(locais.get(ponto1), locais.get(ponto2), distancia);
	    g.addLink(locais.get(ponto2), locais.get(ponto1), distancia);
	}
	    
	// Execucao exemplo a partir do no 1
	g.dijkstra(1);
	double dist = g.nodes[2].distance;
	System.out.printf("%.1f\n", dist);
    }
}
