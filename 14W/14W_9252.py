from sys import stdin

A = list(map(str, stdin.readline().strip()))
B = list(map(str, stdin.readline().strip()))
dp = [[0 for _ in range(len(A)+1)] for _ in range(len(B)+1)]
benchmark = 0
result = []

for i in range(1, len(B)+1):
    for j in range(1, len(A)+1):
        if A[i-1] == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
            if dp[i][j] > benchmark:
                benchmark = dp[i][j]
                result.append(A[i-1])
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[-1][-1])
if result:
    print(''.join(result))

# 행과 열을 바꾸면 다른 결과가 나옴
