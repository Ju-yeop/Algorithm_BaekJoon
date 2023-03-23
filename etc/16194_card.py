N = int(input())
ls = list(map(int, input().split()))
dp = [0 for _ in range(N)]
dp[0] = ls[0]

for i in range(N):
    mini = ls[i]
    for j in range(i):
        if ls[j] + dp[i-j-1] < mini:
            mini = ls[j] + dp[i-j-1]
    dp[i] = mini

print(dp[-1])
