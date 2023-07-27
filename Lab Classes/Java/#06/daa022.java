// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node{
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v){
	isNull  = (v==0);
	isBlack = (v>=0);
	value   = Math.abs(v);
    }
}

public class daa022{
    // Ler input em preorder
    static Node readPreOrder(Scanner in){
	int v = in.nextInt();
	Node aux = new Node(v);

	if(v!=0){
	    aux.left  = readPreOrder(in);
	    aux.right = readPreOrder(in);
	}
	
	return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t){
	if(t.isNull)
	    return Integer.MAX_VALUE;

	int minLeft  = minimum(t.left);
	int minRight = minimum(t.right);

	return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t){
	if(t.isNull)
	    return Integer.MIN_VALUE;

	int minLeft  = maximum(t.left);
	int minRight = maximum(t.right);

	return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t){
	if(t.isNull)
	    return 0;

	return 1 + size(t.left) + size(t.right);
    }

    // Verifica se é Árvore Binária de Pesquisa
    static boolean isBSTree(Node t, int min, int max){
	if(t.isNull)
	    return true;

	if(t.value < min || t.value > max)
	    return false;

	return isBSTree(t.left, min, t.value-1) && isBSTree(t.right, t.value+1, max);
    }
    
    // Verifica se a árvore obedece à Root Property
    static boolean rootProperty(Node t){
	if(t.isBlack)
	    return true;

	return false;
    }

    // Verifica se a árvore obedece à Red Property
    static boolean redProperty(Node t){
	if(t == null)
	    return true;

	if((!t.isBlack && !t.left.isNull && !t.left.isBlack) || (!t.isBlack && !t.right.isNull && !t.right.isBlack))
	    return false;
	
	return redProperty(t.left) && redProperty(t.right);
    }

    // Devolve a altura dos nós pretos
    static int height(Node t){
	int count = 0;

	while(!t.isNull){
	    t = t.left;

	    if(t.isBlack)
		count++;
	}

	return count;
    }
    
    // Verifica se a árvore obedece à Black Property
    static boolean blackProperty(Node t, int height, int count){
	if(t.isNull)
	    return count == height;

	if(t.isBlack)
	    count++;

	return blackProperty(t.left, height, count) && blackProperty(t.right, height, count);
    }

    // ---------------------------------------------------
    
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int n =  in.nextInt();

	for (int i=0; i<n; i++) {
	    Node root = readPreOrder(in);
	    int bheight = height(root);
	    //System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root), minimum(root), maximum(root));

	    if(isBSTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && rootProperty(root) && redProperty(root) && blackProperty(root, bheight, 0))
		System.out.println("SIM");

	    else
	    System.out.println("NAO"); 
	}	
    }
}
