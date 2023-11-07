from sys import stdin

N, M = map(int, stdin.readline().split())
board = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
result = 0

def five(x, y, result):
    for i in range(N):
        if -1 < i + x < N:
            if board[i+x][y] == 0:
                board[i+x][y] = -1
                result += 1
        if -1 < x - i < N:
            if board[x-i][y] == 0:
                board[x-i][y] = -1
                result += 1
    for j in range(M):
        if -1 < j + y < M:
            if board[x][y+j] == 0:
                board[x][y+j] = -1
                result += 1
        if -1 < y - j < N:
            if board[x][y-j] == 0:
                board[x][y-j] = -1
                result += 1
    return result

def four(x, y, result):
    for j in range(M):
        if -1 < j + y < M:
            if board[x][y+j] == 0:
                board[x][y+j] = -1
                result += 1
        if -1 < y - j < N:
            if board[x][y-j] == 0:
                board[x][y-j] = -1
                result += 1


for i in range(N):
    for j in range(M):
        if board[i][j] == 5:
            result = five(i, j, result)

print(result)
