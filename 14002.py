N = int(input())
ls = list(map(int, input().split()))

dp = [1 for _ in range(N)]

for i in range(1, N):
    for j in range(i):
        if ls[i] > ls[j] and dp[i] <= dp[j]:
            dp[i] = dp[j] + 1

result_ls = []
result = max(dp)
result_index = dp.index(result)
ls = ls[0:result_index+1]
for k in range(result_index, -1, -1):
    if result == dp[k]:
        result_ls.append(ls[k])
        result -= 1
result_ls.reverse()

print(max(dp))
for q in range(len(result_ls)):
    print(result_ls[q], end=" ")