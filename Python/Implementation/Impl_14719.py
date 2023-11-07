"""
4 8
3 1 2 3 4 1 1 2
"""
from sys import stdin
h, w = map(int, stdin.readline().split())
ls = list(map(int, stdin.readline().strip().split()))
board = [[0 for _ in range(w)] for _ in range(h)]
result = 0
for idx, i in enumerate(ls):
    for j in range(i):
        board[j][idx] = 1

for i in range(h):
    flag = False
    cnt = 0
    x_idx = w - 1
    for j in range(w):
        if board[i][j] == 1:
            flag = True
            x_idx = j
        if flag is True and board[i][j] == 0:
            cnt += 1
        if j == w-1 and board[i][j] == 0:
            cnt -= (w-1 - x_idx)
    result += cnt
print(result)
