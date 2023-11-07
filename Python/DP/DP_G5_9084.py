"""
3
2
1 2
1000
3
1 5 10
100
2
5 7
22
"""
from sys import stdin

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    ls = list(map(int, stdin.readline().strip().split()))
    m = int(stdin.readline())
    dp = [[0 for _ in range(m+1)] for _ in range(n)]

    for i in range(n): dp[i][0] = 1
    for i in range(1, m+1):
        if i % ls[0] == 0:
            dp[0][i] = 1

    for i in range(1, n):
        for j in range(1, m+1):
            if j - ls[i] >= 0:
                dp[i][j] = dp[i-1][j] + dp[i][j-ls[i]]
            else:
                dp[i][j] = dp[i-1][j]

    print(dp[-1][-1])

