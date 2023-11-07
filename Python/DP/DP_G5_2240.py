"""
7 2
2
1
1
2
2
1
1
"""
from sys import stdin

n, w = map(int, stdin.readline().split())
ls = [int(stdin.readline()) for _ in range(n)]
dp = [[0 for _ in range(w+1)] for _ in range(n)]
for i in range(w+1):
    if (i % 2 == 0 and ls[0] == 1) or (i % 2 == 1 and ls[0] == 2):
        dp[0][i] = 1

for j in range(1, n):
    if ls[j] == 1:
        dp[j][0] = dp[j-1][0] + 1
    else:
        dp[j][0] = dp[j-1][0]


for i in range(1, n):
    for j in range(1, w+1):
        if (j % 2 == 0 and ls[i] == 1) or (j % 2 == 1 and ls[i] == 2):
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + 1
        else:
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j])

print(max(dp[n-1]))