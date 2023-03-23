n = int(input())
ls = []
for _ in range(n):
    temp = list(map(int, input().split()))
    ls.append(temp)

ls.sort()

"""내 줄이 몇개의 줄이랑 같이 살 수 있는지"""

dp = [1] * n
for i in range(n):
    for j in range(i):
        if ls[j][1] < ls[i][1] and dp[j] >= dp[i]:
            dp[i] = dp[j] + 1

print(n - max(dp))