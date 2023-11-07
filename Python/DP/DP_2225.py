"""
20 2
"""
from sys import stdin
n, k = map(int, stdin.readline().strip().split())
dp = [[1 for _ in range(n)] for _ in range(k)]
for i in range(k): dp[i][0] = i+1
for i in range(1, k):
    for j in range(1, n):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]

print(dp[-1][-1] % 1000000000)