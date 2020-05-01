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
        int t = ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    static long mod = (long) 1e9 + 7;

    static long pro(long a, long b) {
        return (a % mod * b % mod) % mod;
    }

    static void solve() {
        char c[] = sn().toCharArray();
        int n = c.length;
        long ans = 1;
        if (c[0] == '?' || c[n - 1] == '?') {
            if (c[0] != '?' || c[1] != '?') {
                c[n - 1] = '#';
            } else {
                c[n - 1] = '#';
                if (c[1] == '?')
                    ans = 26;
                else
                    ans = 25;
            }
        } else if (c[0] != c[n - 1]) {
            out.println(0);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (c[i] == '?') {
                if (c[i + 1] != '?')
                    ans = pro(ans, 24);
                else
                    ans = pro(ans, 25);
            } else if (c[i + 1] != '?' && c[i] == c[i + 1]) {
                ans = 0;
                break;
            }
        }
        out.println(ans);
    }
}
