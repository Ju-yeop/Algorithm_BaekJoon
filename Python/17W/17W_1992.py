from sys import stdin

N = int(stdin.readline())
board = [list(map(int, stdin.readline().strip())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            judge = True

