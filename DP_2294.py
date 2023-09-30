"""
3 15
1
5
12
"""

from sys import stdin

ls = []
n, k = map(int, stdin.readline().split())
for _ in range(n): ls.append(int(stdin.readline()))
dp = [10001 for _ in range(k+1)]
dp[0] = 0
for i in ls:
    for j in range(i, k+1):
        dp[j] = min(dp[j], dp[j-i]+1)
if dp[k] == 10001:
    print(-1)
else: print(dp[k])