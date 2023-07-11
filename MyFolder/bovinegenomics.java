import java.io.*;
import java.util.*;

public class bovinegenomics {
//	static Scanner in;
	static BufferedReader in;
	static PrintWriter out;
	static int n, m;
	static String s, p, spots[], plains[];
	
	public static void main(String[]args) throws IOException {
//		in = new Scanner(System.in);
		in = new BufferedReader(new FileReader("cownomics.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		spots = new String[n];
		plains = new String[n];
		
		for (int i = 0; i < n; i++) {
			spots[i] = in.readLine();
		}
		
		for (int i = 0; i < n; i++) {
			plains[i] = in.readLine();
		}
		
	}
	
	static void solve() {
		
		//iterate through every letter
		int count = 0;
		for (int a = 0; a < m; a++) {
			
			HashSet<Character> spotty = new HashSet<>();
			HashSet<Character> plain = new HashSet<>();
			boolean add = true;
			
			//iterate through spotty cows
			for (int b = 0; b < n; b++) {
				spotty.add(spots[b].charAt(a));
			}
			
			//iterate through plain cows
			for (int b = 0; b < n; b++) {
				plain.add(plains[b].charAt(a));
			}
			
			//check for dupes
			for (Character sp : spotty) {
				for (Character pl : plain) {
					if (sp == pl) {
						add = false;
						break;
					}
				}
			}
			
			if (add) {
				count++;
			}
		}
		out.println(count);
	}
}
