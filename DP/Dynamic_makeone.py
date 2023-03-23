n = int(input())
dp = [0]* (n+2)

dp[1] = 0
dp[2] = 1
temp = []

for i in range(3, n+1):
    temp.clear()
    if i % 2 == 0:
        temp.append(dp[i//2] + 1)
    if i % 3 == 0:
        temp.append(dp[i//3] + 1)
    temp.append(dp[i-1] + 1)
    dp[i] = min(temp)

print(dp[n])