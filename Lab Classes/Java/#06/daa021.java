import java.util.TreeMap;
import java.util.Map;

public class daa021{
    public static void main(String[] args){
	FastScanner in = new FastScanner(System.in);
	int A = in.nextInt();
	int R = in.nextInt();
	TreeMap<Integer, Integer> m = new TreeMap<>();
	
	for(int i=0; i<(A+R); i++){
	    String str = in.nextLine();
	    
	    if(str.equals("MAX")){
		Map.Entry<Integer, Integer> highest = m.lastEntry();

		System.out.println(highest.getKey());

		if(highest.getValue() == 1)
		    m.remove(highest.getKey());

		else
		    m.put(highest.getKey(), highest.getValue() - 1);
	    }

	    else if(str.equals("MIN")){
		Map.Entry<Integer, Integer> lowest = m.firstEntry();

		System.out.println(lowest.getKey());

		if(lowest.getValue() == 1)
		    m.remove(lowest.getKey());

		else
		    m.put(lowest.getKey(), lowest.getValue() - 1);
	    }

	    else{
		String[] bak = str.split(" ");
		int energy = Integer.parseInt(bak[1]);

		if(m.containsKey(energy))
		    m.put(energy, m.get(energy) + 1);

		else
		    m.put(energy, 1);
	    }
	}
    }
}


