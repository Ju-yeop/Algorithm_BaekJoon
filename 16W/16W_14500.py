from sys import stdin

N, M = map(int, stdin.readline().strip().split())
board = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
T = [[[0, 1], [0, 2], [0, 3]], [[1, 0], [2, 0], [3, 0]], [[0, 1], [1, 0], [1, 1]],
     [[1, 0], [2, 0], [2, 1]], [[1, 0], [2, 0], [2, -1]], [[0, 1], [0, 2], [1, 0]],
     [[0, 1], [0, 2], [1, 2]], [[0, 1], [1, 1], [2, 1]], [[0, 1], [1, 0], [2, 0]],
     [[0, 1], [0, 2], [-1, 2]], [[1, 0], [1, 1], [1, 2]], [[1, 0], [1, 1], [2, 1]],
     [[1, 0], [1, -1], [2, -1]], [[0, 1], [-1, 1], [-1, 2]], [[0, 1], [1, 1], [1, 2]],
     [[0, 1], [0, 2], [1, 1]], [[1, 0], [1, 1], [2, 0]], [[1, 0], [1, -1], [2, 0]],
     [[0, 1], [0, 2], [-1, 1]]]
result = 0

for i in range(N):
    for j in range(M):
        for v in T:
            judge = True
            for w in range(3):
                if not (-1 < i + v[w][0] < N and -1 < j + v[w][1] < M):
                        judge = False
            if judge is True:
                temp = board[i][j] + board[i + v[0][0]][j + v[0][1]] + board[i + v[1][0]][j + v[1][1]] + board[i + v[2][0]][j + v[2][1]]
            result = max(result, temp)

print(result)