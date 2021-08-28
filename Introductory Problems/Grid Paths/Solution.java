import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
 
	public static long count = 0;
 
	public static void main(String args[]) throws IOException, InterruptedException { // BufferedReader
		// br = new BufferedReader(new FileReader("c://tmp//in.txt"));d
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = r_s(br);
		boolean v[][] = new boolean[7][7];
		v[0][0] = true;
		traverse(v, s, 0, 0, 0);
		pr_o_nl(count);
	}
 
	static boolean e(int i, int j, boolean v[][]) {
		return i >= 0 && j >= 0 && i < 7 && j < 7 && !v[i][j];
	}
 
	static void traverse(boolean v[][], String s, int mi, int r, int c) throws IOException, InterruptedException {
//		Thread.sleep(100);
//		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//		print(v, 7, 7);
		if (r == 6 && c == 0) {
			if (mi == s.length()) {
				count++;
			}
			return;
		}
 
		v[r][c] = true;
		// left
		if (c - 1 >= 0 && !v[r][c - 1] && (s.charAt(mi) == 'L' || s.charAt(mi) == '?')) {
			if (!(!e(r, c - 2, v) && e(r + 1, c - 1, v) && e(r - 1, c - 1, v))) {
				traverse(v, s, mi + 1, r, c - 1);
			}
		}
		// right
		if (c + 1 < 7 && !v[r][c + 1] && (s.charAt(mi) == 'R' || s.charAt(mi) == '?')) {
			if (!(!e(r, c + 2, v) && e(r + 1, c + 1, v) && e(r - 1, c + 1, v))) {
				traverse(v, s, mi + 1, r, c + 1);
			}
		}
 
		// up
		if (r - 1 >= 0 && !v[r - 1][c] && (s.charAt(mi) == 'U' || s.charAt(mi) == '?')) {
			if (!(!e(r - 2, c, v) && e(r - 1, c + 1, v) && e(r - 1, c - 1, v))) {
				traverse(v, s, mi + 1, r - 1, c);
			}
		}
 
		// down
		if (r + 1 < 7 && !v[r + 1][c] && (s.charAt(mi) == 'D' || s.charAt(mi) == '?')) {
			if (!(!e(r + 2, c, v) && e(r + 1, c + 1, v) && e(r + 1, c - 1, v))) {
				traverse(v, s, mi + 1, r + 1, c);
			}
		}
		v[r][c] = false;
	}
 
	public static void print(boolean board[][], int rows, int cols) {
		pr_o_nl("+-----+-----+-----+----+----+");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pr_o("|");
				pr_o(" " + (board[i][j] ? "X " : "  "));
			}
			pr_o_nl("|");
			pr_o_nl("+-----+-----+-----+----+----+");
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