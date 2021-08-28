import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
 
public class Solution {
 
	public static void main(String args[]) throws IOException, InterruptedException { // BufferedReader
		// BufferedReader br = new BufferedReader(new FileReader("c://tmp//in.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Reader r = new Reader();
		int n = r.nextInt();
		int x = r.nextInt();
		int a[] = r_i_a(r);
		int m[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			m[a[i]] = i;
		}
 
		int ans = 1;
		for (int i = 2; i <= n; i++) {
			ans += m[i - 1] < m[i] ? 0 : 1;
		}
 
		Pair[] qe = new Pair[x];
		int i = 0;
		while (x > 0) {
			int le = r.nextInt() - 1;
			int ri = r.nextInt() - 1;
			qe[i++] = new Pair(le, ri);
			x--;
		}
 
		StringBuffer sb = new StringBuffer();
		for (i = 0; i < qe.length; i++) {
			int le = qe[i].le;
			int ri = qe[i].ri;
			Map<Integer, Integer> map = new HashMap<>();
 
			if (a[le] + 1 <= n) {
				map.put(a[le], a[le] + 1);
			}
			if (a[le] - 1 >= 0) {
				map.put(a[le] - 1, a[le]);
			}
 
			if (a[ri] + 1 <= n) {
				map.put(a[ri], a[ri] + 1);
			}
			if (a[ri] - 1 >= 0) {
				map.put(a[ri] - 1, a[ri]);
			}
 
			for (Integer key : map.keySet()) {
				ans -= (m[key] > m[map.get(key)]) ? 1 : 0;
			}
			swap(a, le, ri);
			m[a[le]] = le;
			m[a[ri]] = ri;
			for (Integer key : map.keySet()) {
				ans += (m[key] > m[map.get(key)]) ? 1 : 0;
			}
			sb.append(ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
 
	}
 
	static void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
 
	static void shuffle(int a[]) {
		for (int i = 0; i < a.length; i++) {
 
			// getting the random index
			int t = (int) Math.random() * a.length;
 
			// and swapping values a random index
			// with the current index
			int x = a[t];
			a[t] = a[i];
			a[i] = x;
		}
	}
 
	static class Pair {
		int le;
		int ri;
 
		public Pair(int le, int ri) {
			super();
			this.le = le;
			this.ri = ri;
		}
 
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
 
	public static int r_i(Reader r) throws IOException {
		return prs_s_i(r.readLine().replace("\r", ""));
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
 
	public static String[] r_s_a(Reader r) throws IOException {
		return r.readLine().split(" ");
	}
 
	public static String[] r_s_a(BufferedReader br, String s) throws IOException {
		return br.readLine().split(s);
	}
 
	public static int[] r_i_a(BufferedReader br) throws IOException {
		String s[] = r_s_a(br);
		int a[] = new int[s.length];
 
		for (int i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		return a;
	}
 
	public static int[] r_i_a(Reader r) throws IOException {
		String s[] = r_s_a(r);
		int a[] = new int[s.length];
 
		for (int i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i].replace("\r", ""));
		}
		return a;
	}
 
	public static Integer[] r_I_a(BufferedReader br) throws IOException {
		String s[] = r_s_a(br);
		Integer a[] = new Integer[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i]);
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
 
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException {
			byte[] buf = new byte[10000000]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
 
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
 
}