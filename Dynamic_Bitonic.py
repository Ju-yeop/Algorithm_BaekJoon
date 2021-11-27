n = int(input())
ls = list(map(int, input().split()))

dp1 = [0] * n
dp2 = [0] * n
for i in range(n):
    for j in range(i):
        if ls[j] < ls[i] and dp1[j] >= dp1[i]:
            dp1[i] = dp1[j]+1

for p in range(n-1, -1, -1):
    for q in range(n-1, p, -1):
        if ls[q] < ls[p] and dp2c[q] >= dp2[p]:
            dp2[p] = dp2[q] + 1

total_ls = [dp1[v] + dp2[v] for v in range(len(dp1))]
print(max(total_ls) + 1)