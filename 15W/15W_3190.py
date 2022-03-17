from sys import stdin
from collections import deque

N = int(stdin.readline())
board = [[0 for _ in range(N)] for _ in range(N)]
K = int(stdin.readline())
for _ in range(K):
    a, b = map(int, stdin.readline().strip().split())
    board[a - 1][b - 1] = 1
L = int(stdin.readline())
turn_ls = [list(stdin.readline().strip().split()) for _ in range(L)]
snake = deque([[0, 0]])
time = 0
move = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # 오, 밑, 왼, 위
turn_num = 0
move_order = 0

while True:
    time += 1
    x = snake[-1][0] + move[move_order % 4][0]
    y = snake[-1][1] + move[move_order % 4][1]
    if [x, y] in snake or x < 0 or x >= N or y < 0 or y >= N:
        print(time)
        exit(0)
    else:
        snake.append([x, y])
        if board[x][y] == 0:
            snake.popleft()
        elif board[x][y] == 1:
            board[x][y] = 0

    if turn_num < L:
        if time == int(turn_ls[turn_num][0]):
            if turn_ls[turn_num][1] == 'L':
                move_order -= 1
            elif turn_ls[turn_num][1] == 'D':
                move_order += 1
            turn_num += 1
