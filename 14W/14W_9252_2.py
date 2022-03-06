from sys import stdin

A = list(map(str, stdin.readline().strip()))
B = list(map(str, stdin.readline().strip()))
dp = [[0 for _ in range(len(B)+1)] for _ in range(len(A)+1)]
result = []

for i in range(1, len(A)+1):
    for j in range(1, len(B)+1):
        if A[i-1] == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])


X, Y = len(A), len(B)

while X>0 and Y>0:
    if dp[X][Y-1] == dp[X][Y]:
        Y -= 1
    elif dp[X-1][Y] == dp[X][Y]:
        X -= 1
    else:
        result.append(A[X-1])
        X -= 1
        Y -= 1

result.reverse()
print(dp[-1][-1])
if result:
    print(''.join(result))
