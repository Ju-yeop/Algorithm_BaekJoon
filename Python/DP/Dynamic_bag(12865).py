N, K = map(int, input().split())
ls = [[0,0]]
for _ in range(N):
    temp = list(map(int, input().split()))
    ls.append(temp)

dp = [[0 for _ in range(K+1)]for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, K+1):
        if j >= ls[i][0]:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-ls[i][0]] + ls[i][1])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[-1][-1])