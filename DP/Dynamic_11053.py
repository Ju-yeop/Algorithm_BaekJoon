n = int(input())
ls = list(map(int, input().split()))

dp = [0] * n
for i in range(n):
    for j in range(i):
        if ls[j] < ls[i] and dp[j] >= dp[i]:
            dp[i] = dp[j]+1

print(max(dp)+1)