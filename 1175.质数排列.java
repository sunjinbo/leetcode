/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    final static long N = 1000000007L;

    public int numPrimeArrangements(int n) {
        int cnt = 0;
        long ret = 1;

        if (n==1) return 1;

        for(int i = 1;i <= n;i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }

        ret = mod(cnt) * mod(n - cnt) % N;

        return (int)ret;
    }

    long mod(int num) {
        if (num == 1) return 1;
        else return num * mod(num - 1) % N;
    }

    boolean isPrime(int num) {
        int base = 2;
        if (num == 1) return false;
        else if (num == 2 || num == 3) return true;
        else {
            while (base < num) {
                if (num % base == 0) {
                    return false;
                }
                base++;
            }
        }
        return true;
    }
}
// @lc code=end

