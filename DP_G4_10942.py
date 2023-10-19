"""
팰린드롬
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7
"""
from sys import stdin
n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
m = int(stdin.readline())
par = [list(map(int, stdin.readline().strip().split())) for _ in range(m)]

dp = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n): dp[i][i] = 1

for i in range(n):
    for j in range(i):
        if i - j == 1:
            if ls[i] == ls[j]:
                dp[j][i] = 1
        elif dp[j+1][i-1] == 1 and ls[i] == ls[j]:
            dp[j][i] = 1

for x, y in par:
    print(dp[x-1][y-1])