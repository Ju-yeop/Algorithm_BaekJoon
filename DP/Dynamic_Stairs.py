N = int(input())
ls = []
for _ in range(N):
    score = int(input())
    ls.append(score)

dp = [0 for _ in range(N)]
dp[0] = ls[0]
if N>=2:
    dp[1] = ls[0] + ls[1]
if N>=3:
    dp[2] = max(ls[0] + ls[2], ls[1] + ls[2])

for i in range(3, N):
    dp[i] = max(ls[i] + dp[i-2], ls[i] + ls[i-1] + dp[i-3])

print(dp[N-1])