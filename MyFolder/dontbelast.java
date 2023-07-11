import java.io.*;
import java.util.*;
public class dontbelast {
	
	static String[] cows;
	static int[] amount;
	static int n;
	static BufferedReader in; static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("notlast.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		
		cows = new String[]{
				"Bessie",
				"Elsie",
				"Daisy",
				"Gertie",
				"Annabelle",
				"Maggie",
				"Henrietta"};
		

		amount = new int[cows.length];
		n = Integer.parseInt(in.readLine());
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			int milk = Integer.parseInt(st.nextToken());
			
			amount[findCowIndex(name)] += milk;
		}
	}
	
	static void solve() {
		int minimumAmount = 1000000;
		for(int i = 0; i < amount.length; i++) {
			if(amount[i] < minimumAmount) {
				minimumAmount = amount[i];
			}
		}
		
		int secondsmallest = 1000000;
		for(int i = 0; i < amount.length; i++) {
			if(amount[i] > minimumAmount && amount[i] < secondsmallest) {
				secondsmallest = amount[i];
			}
		}
		
		final int notfound = -1;
		final int MORE_THAN_ONE = -2;
		int isecondsmallest = notfound;
		for(int i = 0; i < amount.length; i++) {
			if(amount[i] == secondsmallest) {
				if(isecondsmallest == notfound) {
					isecondsmallest = i;
				}
				else {
					isecondsmallest = MORE_THAN_ONE;
				}
			}
		}
		if(isecondsmallest >= 0) {
			out.println(cows[isecondsmallest]);
		}
		else {
			out.println("Tie");
		}
		
		out.close();
	}
	
	public static int findCowIndex(String s) {
		for(int i = 0; i < cows.length; i++) {
			if(cows[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
}
