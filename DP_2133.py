from sys import stdin

n = int(stdin.readline())
dp = [0 for _ in range(31)]
dp[2], dp[4] = 3, 11
for i in range(6, n+1):
    if i % 2 == 1:
        dp[i] = 0
    else:
        dp[i] = (2 * sum(dp[2:i-3])) + (3 * dp[i-2]) + 2

print(dp[n])