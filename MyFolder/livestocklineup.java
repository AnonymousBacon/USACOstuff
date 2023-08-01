import java.io.*;
import java.util.*;

public class lineup {
	static Scanner in;
//	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static ArrayList<String> p, a, names;
	
	public static void main(String[]args) throws IOException {
		in = new Scanner(new File("lineup.in"));
//		in = new BufferedReader(new FileReader(".in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		names = new ArrayList<String>();
		names.add("");
		names.add("Beatrice");
		names.add("Belinda");
		names.add("Bella");
		names.add("Bessie");
		names.add("Betsy");
		names.add("Blue");
		names.add("Buttercup");
		names.add("Sue");
		
		p = new ArrayList<String>();
		a = new ArrayList<String>();
		
		n = Integer.valueOf(in.nextLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			String add1 = names.indexOf(st.nextToken())+"";
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			String add2 = names.indexOf(st.nextToken())+"";;
			
			a.add(add1+add2);
			a.add(add2+add1);
		}
		
		System.out.println(a.toString());
	}
	
	static void solve() {
		permute("");
		String ans = "test";
		boolean breaker = false;
		
		for (int i = 0; i < p.size(); i++) {
			if (breaker) {
				break;
			}
			for (int b = 0; b < a.size(); b+=2) {
				if (!(p.get(i).contains(a.get(b)) || p.get(i).contains(a.get(b+1)))) {
					break;
				}
				if (b == a.size()-2) {
					ans = p.get(i);
					breaker = true;
					break;
				}
			}
		}
		
		for (int i = 0; i < ans.length(); i++) {
			out.println(names.get(ans.charAt(i)-'0'));
		}
	}
	
	static void permute(String s) {
		
		if (s.length() == 8) {
			p.add(s);
			return;
		}
		
		for (int i = 1; i <= 8; i++) {
			if (!s.contains(i+"")) {
				permute(s+i+"");
			}
		}
		
	}
}
