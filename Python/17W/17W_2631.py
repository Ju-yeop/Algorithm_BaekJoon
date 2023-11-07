from sys import stdin

N = int(stdin.readline())
ls = []
dp = [1] * N
result = 0

for _ in range(N):
    temp = int(stdin.readline())
    ls.append(temp)

for i in range(1, N):
    for j in range(i):
        if ls[j] < ls[i] and dp[j] >= result and dp[j] >= dp[i]:
            dp[i] = dp[j] + 1

print(N - max(dp))