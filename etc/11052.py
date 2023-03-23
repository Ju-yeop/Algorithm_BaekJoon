N = int(input())
temp = list(map(int, input().split()))
ls = [0] + temp
dp = [0] * (N+1)
dp[1] = ls[1]

for i in range(2, N+1):
    for j in range(i):
        if dp[i] < dp[j] + ls[i-j]:
            dp[i] = dp[j] + ls[i-j]

print(dp[-1])