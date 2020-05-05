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

    static long mod = 998244353;

    static long pro(long a, long b) {
        return (a % mod * b % mod) % mod;
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static int maxn = 200005;

    static long func(long b, long n) {
        if (b > n)
            return n;
        return (n % b + func(b, n / b));
    }

    static void solve() {
        int n = ni();
        int a = ni();
        int x[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            x[i] = ni();
            sum += x[i];
        }
        long dp[][][] = new long[52][52][2502];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= sum; k++) {
                    if (j - 1 >= 0 && x[i - 1] <= k)
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k - x[i - 1]];
                    else
                        dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dp[n][i][a * i];
        }
        out.println(ans);
    }
}
