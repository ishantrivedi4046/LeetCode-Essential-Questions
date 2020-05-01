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
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = ni();
            int w = ni();
            int c = ni();
            map.putIfAbsent(t, new ArrayList<>());
            map.get(t).add(new int[]{w, c});
        }
        int k = ni();
        int dp[][] = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (map.containsKey(j)) {
                    for (int[] h : map.get(j)) {
                        int w = h[0], c = h[1];
                        if (w <= i)
                            dp[i][j] = Math.max(dp[i][j],Math.max(dp[i][j - 1], dp[i - w][j - 1] + c));
                        else
                            dp[i][j] = Math.max(dp[i][j],dp[i][j - 1]);
                    }
                } else
                    dp[i][j] = dp[i][j - 1];
            }
        }
//        for(int i=1;i<=k;i++)
//        out.println(Arrays.toString(dp[i]));
        out.println(dp[k][n]);
    }
}
