import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
 
	public static void main(String args[]) throws IOException { // BufferedReader
		// br = new BufferedReader(new FileReader("c://tmp//in.txt"));d
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = r_i(br);
		long sum = ((long) n * ((long) n + 1)) / 2;
		boolean b[] = new boolean[10000000];
		if (sum % 2 == 0) {
			long wsum = sum / 2;
			int j = wsum % n == 0 ? n : n - 1;
			int i = wsum % n == 0 ? 1 : 2;
			boolean f = true;
			int count1 = 0;
			StringBuilder sb1 = new StringBuilder();
			while (wsum > 0) {
				if (f) {
					wsum -= j;
					sb1.append(j + " ");
					b[j--] = true;
					count1++;
				} else {
					wsum -= i;
					sb1.append(i + " ");
					b[i++] = true;
					count1++;
				}
				f = !f;
 
			}
			StringBuilder sb2 = new StringBuilder();
			for (i = 1; i <= n; i++) {
				if (!b[i]) {
					sb2.append(i + " ");
 
				}
			}
 
			pr_o_nl("YES");
			pr_o_nl(count1);
			bw.write(sb1.toString());
			// pr_o_nl(sb1.toString());
			bw.flush();
			pr_nl();
			pr_o_nl(n - count1);
			// pr_o(sb2.toString());
			bw.write(sb2.toString());
			bw.flush();
		} else
 
		{
			pr_o_nl("NO");
		}
 
	}
 
	public static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				pr_o(m[i][j] + " ");
			}
			pr_nl();
		}
		pr_nl();
	}
 
	public static void print(boolean[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				pr_o(m[i][j] + " ");
			}
			pr_nl();
		}
		pr_nl();
	}
 
	public static void pr_o(Object s) {
		System.out.print(s);
	}
 
	public static void pr_o_nl(Object s) {
		System.out.print(s);
		pr_nl();
	}
 
	public static void pr_nl() {
		System.out.println();
	}
 
	public static int prs_s_i(String s) {
		return Integer.parseInt(s);
	}
 
	public static Long prs_s_l(String s) {
		return Long.parseLong(s);
	}
 
	public static int r_i(BufferedReader br) throws IOException {
		return prs_s_i(br.readLine());
	}
 
	public static long r_l(BufferedReader br) throws IOException {
		return prs_s_l(br.readLine());
	}
 
	public static String r_s(BufferedReader br) throws IOException {
		return br.readLine();
	}
 
	public static String[] r_s_a(BufferedReader br) throws IOException {
		return br.readLine().split(" ");
	}
 
	public static String[] r_s_a(BufferedReader br, String s) throws IOException {
		return br.readLine().split(s);
	}
 
	public static int[] r_i_a(BufferedReader br) throws IOException {
		String s[] = r_s_a(br);
		int a[] = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = prs_s_i(s[i]);
		}
		return a;
	}
 
	public static long[] r_l_a(BufferedReader br) throws IOException {
		String s[] = r_s_a(br);
		long a[] = new long[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = prs_s_l(s[i]);
		}
		return a;
	}
 
	public static int[] r_i_a(BufferedReader br, String split) throws IOException {
		String s[] = r_s_a(br, split);
		int a[] = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = prs_s_i(s[i]);
		}
		return a;
	}
 
	public static int[][] r_s_a_i(BufferedReader br, int a[][], int i) throws IOException {
		String s1[] = r_s_a(br);
		for (int j = 0; j < s1.length; j++) {
			a[i][j] = prs_s_i(s1[j]);
		}
		return a;
	}
 
	public static int[][] r_s_a_r_w_o_s(BufferedReader br, int a[][], int r) throws IOException {
		for (int i = 0; i < r; i++) {
			String s = r_s(br);
			for (int j = 0; j < r; j++) {
				if (s.charAt(j) == '.') {
					a[i][j] = 0;
				} else {
					a[i][j] = Integer.parseInt("" + s.charAt(j));
				}
			}
		}
		return a;
	}
 
	public static int[][] r_s_a_r(BufferedReader br, int a[][], int r) throws IOException {
		for (int i = 0; i < r; i++) {
			a = r_s_a_i(br, a, i);
		}
		return a;
	}
 
	public static Integer maxx(Integer... x) {
		int max = 0;
		for (Integer a : x) {
			max = Math.max(a, max);
		}
		return max;
	}
 
	public static Integer minn(Integer... x) {
		int min = Integer.MAX_VALUE;
		for (Integer a : x) {
			min = Math.min(a, min);
		}
		return min;
	}
 
	public static Long maxx(Long... x) {
		long max = 0;
		for (Long a : x) {
			max = Math.max(a, max);
		}
		return max;
	}
 
}