n = int(input())
arr = []
dp = [[0]*3 for j in range(n)]

for _ in range(n):
    ls = list(map(int, input().split()))
    arr.append(ls)

for k in range(3):
    dp[0][k] = arr[0][k]
for i in range(n):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]

print(min(dp[n-1]))

'''어렵다...뭔가 점화식을 구해야될거같은데 감이 안잡혀..
    존나 복합한 백트래킹 DFS 했다가 실패함ㅡ.ㅡ
    동적계획법이면 분명히 DP Table 이용해서 쉽게 풀릴텐데...'''



