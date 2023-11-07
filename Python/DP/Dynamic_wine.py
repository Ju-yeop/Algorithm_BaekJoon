n = int(input())
ls = []
dp = [0] * (n+2)

for _ in range(n):
    amount = int(input())
    ls.append(amount)

dp[0] = ls[0]
if n>1:
    dp[1] = ls[0] + ls[1]
if n>2:
    dp[2] = max(dp[1], ls[1] + ls[2], ls[0] + ls[2])

for i in range(3, n):
    dp[i] = max(ls[i] + ls[i-1] + dp[i-3], ls[i] + dp[i-2], dp[i-1])

print(max(dp))