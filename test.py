def solution(n, m, puddles):
    road = [[0 for _ in range(m)] for _ in range(n)]
    for r, c in puddles: road[r-1][c-1] = -1
    road[0][0] = 1

    for i in range(n):
        for j in range(m):
            if (i == 0 and j == 0) or road[i][j] == -1: continue
            if i-1 < 0 or road[i-1][j] == -1: up = 0
            else: up = road[i-1][j]
            if j-1 < 0 or road[i][j-1] == -1: left = 0
            else: left = road[i][j-1]
            road[i][j] = up + left

    return road[n-1][m-1] % 1000000007

print(solution(3, 5, [[2,2],[1,2],[2,4], [3, 4]]))