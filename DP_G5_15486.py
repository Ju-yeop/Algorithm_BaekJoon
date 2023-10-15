"""
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
"""
from sys import stdin

n = int(stdin.readline())
ls = [list(map(int, stdin.readline().strip().split())) for _ in range(n)]
dp = [0 for _ in range(n+1)]
dp_mx = 0
for i in range(n):
    target = i + ls[i][0]
    dp_mx = max(dp_mx, dp[i])
    if n >= target:
        dp[target] = max(dp[target], dp_mx + ls[i][1])
print(max(dp))

