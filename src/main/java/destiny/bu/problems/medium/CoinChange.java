package destiny.bu.problems.medium;

import java.util.Arrays;

public class CoinChange {
    public int coinChangeApproachOne(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        for (int coin : coins) {
            minCoins[coin] = 1;
        }
        for (int i = 0; i < minCoins.length; i++) {
            if (minCoins[i] > 0) {
                for (int coin : coins) {
                    minCoins[i + coin] = Math.min(minCoins[i] + 1, minCoins[i + coin]);
                }
            }

        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];

        Arrays.fill(minCoins, Integer.MAX_VALUE);

        minCoins[0] = 0;

        for (int i = 0; i < minCoins.length; i++) {
            if (minCoins[i] != Integer.MAX_VALUE) {
                for (int coin : coins) {
                    int nextIndex = i + coin;
                    if (nextIndex < minCoins.length && nextIndex > 0) {
                        minCoins[nextIndex] = Math.min(minCoins[i] + 1, minCoins[nextIndex]);
                    }
                }
            }
        }
        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
    }

}
