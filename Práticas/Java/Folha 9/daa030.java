// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
    public int distance;            // Distancia ao no origem da pesquisa

    Node() {
	adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos
    int dist[][];    // Matriz de distâncias

    Graph(int n) {
	this.n = n;
	nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0
	dist = new int[n][n];
	for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
    }

    public void addLink(int a, int b) {
	nodes[a].adj.add(b);
	nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public void bfs(int v, Graph graph) {
	LinkedList<Integer> q = new LinkedList<Integer>();

	for (int i=1; i<=n; i++)
	    nodes[i].visited = false;

	q.add(v);
	nodes[v].visited = true;
	nodes[v].distance = 0;

	while (q.size() > 0) {
	    int u = q.removeFirst();
	    //System.out.println(u + " [dist=" + nodes[u].distance + "]");
	    graph.dist[v-1][u-1] = nodes[u].distance;
	    for (int w : nodes[u].adj)
		if (!nodes[w].visited) {
		    q.add(w);
		    nodes[w].visited  = true;
		    nodes[w].distance = nodes[u].distance + 1; 
		}	    
	}
    }
}

public class BFS {
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt(); 
	Graph grafo = new Graph(N);
	int E = in.nextInt();
	
	for (int i=0; i<E; i++){
	    int A = in.nextInt();
	    int B = in.nextInt();
	    grafo.addLink(A, B);
	}
	
	for(int i=1; i<=N; i++){
	    grafo.bfs(i, grafo);
	}

	/*
	for(int i=0; i<N; i++){
	    for(int j=0; j<N; j++){
		System.out.print(grafo.dist[i][j] + " ");
	    }

	    System.out.println();
	    }*/

	int excen[] = new int[N];

	for(int i=0; i<N; i++){
	    int maxmindist = 0;
	    
	    for(int j=0; j<N; j++){
		if(grafo.dist[i][j] > maxmindist){
		    maxmindist = grafo.dist[i][j];
		}
	    }

	    excen[i] = maxmindist;
	}

	/*
	for(int i=0; i<N; i++){
	    int j = i+1;
	    System.out.println("Excentricidade do nó " + j + ": " + excen[i]);
	    }*/

	int diametro = excen[0];

	for(int i=1; i<N; i++)
	    if(excen[i] > diametro)
		diametro = excen[i];

	System.out.println(diametro);

	int raio = excen[0];

	for(int i=1; i<N; i++)
	    if(excen[i] < raio)
		raio = excen[i];

	System.out.println(raio);

	int count = 0;
	int centrais[] = new int[N];
	
	for(int i=0; i<N; i++){
	    if(excen[i] == raio){
		count++;
		centrais[i] = i+1;
		//System.out.print((i+1) + " ");
	    }
	}

	int lastc = centrais[0];
	    
	//System.out.println();

	/*System.out.println();
	  System.out.println(count);*/

	if(count == 1){
	    int index = 0;

	    for(int i=0; i<N; i++)
		if(centrais[i] != 0)
		    index = i;
		
	    System.out.println(centrais[index]);
	}
	    
	else if(count > 1){
	    /*for(int i=0; i<N-1; i++)
		if(centrais[i] != 0)
		    System.out.print(centrais[i] + "-");
	    
	    if(centrais[N-1] != 0)
		System.out.println(centrais[N-1]);
	    
	    else
	    System.out.println();*/

	    int j=0;

	    for(int i=0; i<N; i++)
		if(centrais[i] != 0)
		    lastc = centrais[i];
	    
	    while(centrais[j] < lastc){
		if(centrais[j] != 0)
		    System.out.print(centrais[j] + " ");
		
		j++;
	    }

	    System.out.println(lastc);

	}
	
	int perifericos[] = new int[N];

	for(int i=0; i<N; i++){
	    if(excen[i] >= diametro)
		perifericos[i] = i+1;
	}

	int last = perifericos[0];
	
	for(int i=0; i<N; i++){
	    if(perifericos[i] != 0)
		last = perifericos[i];
	}

	int i=0;
	
	while(perifericos[i] < last){
	    if(perifericos[i] != 0)
		System.out.print(perifericos[i] + " ");

	    i++;
	}

	System.out.println(last);

	/*
	if(perifericos[N-1] != 0)
	    System.out.println(perifericos[N-1]);

	else
	System.out.println(); */ 
	
	//System.out.println();
    }
}
