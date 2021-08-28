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
		int t = r_i(br);
		while (t > 0) {
			long n = r_l(br);
			if (n <= 9) {
				pr_o_nl(n);
			} else {
				int f = 1;
				long prev = 10;
				long cur = 0;
				while (true) {
					cur = (long) ((Math.pow(10, f) + (Math.pow(10, f) * f)) * 9) + (prev - 1);
					// pr_o_nl("Range Index : " + prev + " - " + cur);
					if (n >= prev && n <= cur) {
						break;
					}
					prev = cur + 1;
					f++;
				}
				long l = (long) Math.pow(10, f);
				long r = (long) Math.pow(10, f + 1) - 1;
				// pr_o_nl("Range Number : " + l + " - " + r);
 
				long n1 = n - (prev - 1);
				long n3 = n1 / (f + 1);
				long n2 = n3 * (f + 1);
				if (n1 % (f + 1) == 0) {
					String n2s = "" + ((l - 1) + n3);
					pr_o_nl(n2s.charAt(n2s.length() - 1));
				} else {
					long rem = n1 % (f + 1);
					String n2s = "" + (((l - 1) + n3) + 1);
					pr_o_nl(n2s.charAt((int) rem - 1));
				}
 
				// pr_o_nl(binarySearch(n, l, l, r, f));
 
			}
			t--;
		}
 
	}
 
	public static char binarySearch(long index, long rs, long l, long r, int f) {
//		pr_o("n : " + index + " ");
//		pr_o("rs : " + rs + " ");
//		pr_o("l : " + l + " ");
//		pr_o("r: " + r + " ");
//		pr_o("f : " + f + " ");
		while (l <= r) {
			long mid = l + ((r - l) / 2);
			long is = (mid - rs) * (f + 1) + rs;
			long ie = is + (f + 1) - 1;
 
//			pr_o_nl("mid : " + mid + " ");
//			pr_o_nl("Index Start : " + is + " " + " Index End : " + ie);
			if (is <= index && index <= ie) {
				int cn = (int) (index - is);
				return String.valueOf(mid).charAt(cn);
			} else if (index < is) {
				return binarySearch(index, rs, l, mid - 1, f);
			} else if (index > ie) {
				return binarySearch(index, rs, mid + 1, r, f);
			}
		}
		return '-';
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