"""
4 4
0100
0111
1110
0010
"""
import copy
from sys import stdin
n, m = map(int, stdin.readline().split())
ls = []
for _ in range(n):
    temp = list(map(int, stdin.readline().strip()))
    ls.append(temp)
dp = copy.deepcopy(ls)

answer = 0
for i in range(1, n):
    for j in range(1, m):
        target = dp[i-1][j-1]
        if target != 0 and ls[i][j] == 1:
            check = 0
            for k in range(1, target+1):
                if ls[i][j-k] + ls[i-k][j] == 2:
                    dp[i][j] += 1
                else: break
for i in range(n):
    temp = max(dp[i])
    answer = max(answer, temp)
print(answer**2)