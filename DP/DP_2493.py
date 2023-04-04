"""
DP 사용해서 각 위치까지 가장 높은 송전탑 위치 저장
5
6 9 5 7 4
"""

from sys import stdin
n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
dp = [-1 for _ in range(n)]
for i in range(1, n):
    if dp[i-1] == -1 and ls[i-1] < ls[i]:
        continue
    if ls[i] <= ls[i-1]:
        dp[i] = i-1
    else:
        if ls[dp[i-1]] < ls[i]:
            for j in range(dp[i-1], -1, -1):
                if ls[dp[j]] >= ls[i]:
                    dp[i] = dp[j]
                    break
        else:
            dp[i] = dp[i-1]

for i in dp:
    print(i+1, end=" ")