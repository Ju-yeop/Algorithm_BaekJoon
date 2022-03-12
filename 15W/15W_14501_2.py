from sys import stdin

N = int(stdin.readline())
ls = [[0, 0]] + [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
dp = [0 for _ in range(N+1)]

if ls[N][0] == 1:
    dp[N] = ls[N][1]

for i in range(N-1, 0, -1):
    if i + ls[i][0] - 1 < N:
        dp[i] = max(max(dp[i+ls[i][0]:]) + ls[i][1], dp[i+1])
    elif i + ls[i][0] -1 == N:
        dp[i] = max(ls[i][1], dp[i+1])

print(max(dp))