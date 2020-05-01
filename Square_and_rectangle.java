import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
    static PrintWriter out = new PrintWriter(System.out);
    static StringTokenizer t;

    static String sn() {
        while (t == null || !t.hasMoreTokens()) {
            try {
                t = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return t.nextToken();
    }

    static int ni() {
        return Integer.parseInt(sn());
    }

    static long nlo() {
        return Long.parseLong(sn());
    }

    public static void main(String args[]) {
        int t = 1;//ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    static void solve() {
        int n = ni();
        int a[] = new int[n];
        int f[] = new int[n];
        int min = Integer.MAX_VALUE;
        int total = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = ni();
            f[i] = ni();
            int d = f[i] / 2;
            total += d;
            ans += d * 2 * a[i];
            if (f[i] >= 2 && a[i] < min) {
                min = a[i];
            }
        }
        if (total % 2 == 0)
            out.println(ans);
        else {
            ans -= 2 * min;
            out.println(ans);
        }
    }
}
