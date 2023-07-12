"""
12 10 4 7
2 4
7 3
3 1
5 6
4 7
12 10
8 6
"""

# from sys import stdin
#
# N, M, L, K = map(int, stdin.readline().split())
# star = []
# x_m, y_m = 0, 0
# for _ in range(K):
#     x, y = map(int, stdin.readline().split())
#     x_m = max(x, x_m)
#     y_m = max(y, y_m)
#     star.append([x, y])
#
# Earth = [[0 for _ in range(x_m+1)] for _ in range(y_m+1)]
# for a, b in star: Earth[b][a] = 1
#
# for i in range(1, M+1):
#     for j in range(1, N+1):
#         Earth[i][j] += Earth[i][j-1]
#
# for i in range(1, N+1):
#     for j in range(1, M+1):
#         Earth[j][i] += Earth[j-1][i]
#
# answer = 0
# for i in range(L, M+1):
#     for j in range(L, N+1):
#         answer = max(answer, Earth[i][j] - Earth[i-L][j] - Earth[i][j-L] + Earth[i-L][j-L])
#
# print(K-answer)

import sys

input = sys.stdin.readline

N, M, L, K = map(int, input().split())
res = 0
star = []

for i in range(K):
    x, y = map(int, input().split())
    star.append([x, y])

for i in range(K):
    for j in range(K):
        cnt = 0
        for k in range(K):
            if star[i][0] <= star[k][0] <= star[i][0] + L and star[j][1] <= star[k][1] <= star[j][1] + L:
                cnt += 1
        res = max(res, cnt)
ans = K - res
print(ans)
