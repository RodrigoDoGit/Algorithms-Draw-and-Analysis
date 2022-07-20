import java.util.Scanner;

class Graph{
    String ordem;
    String palavras[];
    boolean adj[][];
    boolean visited[];

    Graph(String p[]){
	ordem = "";
	palavras = p;
	visited = new boolean[26];
	adj = new boolean[26][26];
    }

    public int charindex(Character ch){
	return ch-65;
    }

     public void dfs(int v){
	visited[v] = true;

	for(int i=0; i<26; i++)
	    if(adj[v][i] && !visited[i])
		dfs(i);

	char ch = (char)(65+v);

	ordem = ch + ordem;
    }

    public void ordenar(){
	int len = palavras.length;

	for(int i=0; i<len-1; i++){
	    int j=0;

	    while(palavras[i].length() > j+1 && palavras[i+1].length() > j+1 && palavras[i].charAt(j) == palavras[i+1].charAt(j))
		j++;

	    if(palavras[i].charAt(j) != palavras[i+1].charAt(j)){
		adj[charindex(palavras[i].charAt(j))][charindex(palavras[i+1].charAt(j))] = true;
	    }
	}

	for(int i=0; i<26; i++){
	    for(int j=0; j<26; j++)
		if(adj[i][j] && !visited[i])
		    dfs(i);
	}

	System.out.println(ordem);
    }
    
}

public class daa029{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	String ordem = "";
	String palavras[] = new String[N];
	
	for(int i=0; i<N; i++){
	    String P = in.next();

	    palavras[i] = P;
	}

	Graph grafo = new Graph(palavras);
	grafo.ordenar();
    }
}
