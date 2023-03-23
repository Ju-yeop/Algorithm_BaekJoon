N = int(input())
ls = list(map(int, input().split()))
dp = [0] * N

dp[0] = ls[0]
for i in range(1, N):
    if dp[i-1] + ls[i] > ls[i]:
        dp[i] = dp[i-1] + ls[i]
    else:
        dp[i] = ls[i]

print(max(dp))