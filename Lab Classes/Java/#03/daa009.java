import java.util.*;

class Letter implements Comparable<Letter>{
    public int freq;
    public int first;
    public char letter;

    Letter(int f, int fs, char l){
	freq = f;
	first = fs;
	letter = l;
    }

    @Override
    public int compareTo(Letter t){
	if(freq < t.freq)
	    return +1;

	if(freq > t.freq)
	    return -1;

        else{
	    if(freq == t.freq && first < t.first)
		return -1;

	    return +1;
	}
    }
}

public class daa009{  
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);

	String T = in.next();
	Letter v[] = new Letter[26];

	int i=0;

	for(char c='A'; c<='Z'; c++){
	    v[i] = new Letter(0, 0, c);
	    i++;  
	}
	
	for(int j=0; j<T.length(); j++){
	    char c = T.charAt(j);
	    
	    int pos = c - 'A';

	    v[pos].letter = c;
	    v[pos].freq++;
	    
	    if(v[pos].first == 0){
		v[pos].first = j;

		if(v[pos].letter == T.charAt(0))
		    v[pos].first = 0;
	    }
	}
	
	Arrays.sort(v);

	for(int j=0; j<26; j++){
	    if(v[j].freq != 0)
		System.out.println(v[j].letter + " " + v[j].freq);
	}
		
    }
}
