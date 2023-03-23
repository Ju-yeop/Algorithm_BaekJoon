N = int(input())
tri_arr = []

for _ in range(N):
    li = list(map(int, input().split()))
    tri_arr.append(li)

dp = [[0 for j in range(i+1)] for i in range(N)]
dp[0][0] = tri_arr[0][0]
for i in range(1, N):
    for j in range(i+1):
        if j == 0:
            dp[i][j] = tri_arr[i][j] + dp[i-1][j]
        elif j == i:
            dp[i][j] = tri_arr[i][j] + dp[i-1][j-1]
        else:
            dp[i][j] = tri_arr[i][j] + max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[N-1]))