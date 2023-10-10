"""
8
1 6 2 5 7 3 5 6
"""
from sys import stdin
n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
dp = [1 for _ in range(len(ls))]
for i in range(1, len(ls)):
    for j in range(i):
        if ls[j] < ls[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))