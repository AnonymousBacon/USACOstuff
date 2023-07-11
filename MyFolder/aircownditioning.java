import java.io.*;
import java.util.*;

public class ac {
	static BufferedReader in;
	static int n, p[], t[];
	
	public static void main(String[]args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.valueOf(in.readLine());
		p = new int[n];
		t = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.valueOf(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			t[i] = Integer.valueOf(st.nextToken());
		}
		
		in.close();
	
		int ans = 0;
		int i = check(0);
		
		while (i != -1) {
			
			if (t[i] > p[i]) {
				int end = i;
				for (int a = i; a < n; a++) {
					if (t[a] > p[a]) {
						end = a;
					}
					else {
						break;
					}
				}
				
				for (int a = i; a <= end; a++) {
					t[a]--;
				}
				ans++;

			}
			
			if (t[i] < p[i]) {
				int end = i;
				for (int a = i; a < n; a++) {
					if (t[a] < p[a]) {
						end = a;
					}
					else {
						break;
					}
				}
				
				for (int a = i; a <= end; a++) {
					t[a]++;
				}
				ans++;
				
			}
			
			i = check(i);
		}
		
		System.out.println(ans);
	}
	
	static int check(int start) {
		for (int i = start; i < n; i++) {
			if (t[i] != p[i]) {
				return i;
			}
		}
		return -1;
	}
}
