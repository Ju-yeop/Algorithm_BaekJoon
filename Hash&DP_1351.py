"""
A0 = 1
Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
7 2 3
"""
from sys import stdin
from collections import defaultdict

n, p, q = map(int, stdin.readline().split())
dp = defaultdict(int)
dp[0] = 1

def recur(x):
    if x == 0:
        return 1
    elif dp[x] != 0:
        return dp[x]
    else:
        dp[x] = recur(x//p) + recur(x//q)
        return dp[x]

print(recur(n))
