from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
board = []
target_x, target_y = 0, 0
move = [[-1, 0], [0, 1], [1, 0], [0, -1]]

for i in range(n):
    temp = list(map(int, stdin.readline().strip().split()))
    if 2 in temp:
        target_x = i
        target_y = temp.index(2)
    board.append(temp)
board[target_x][target_y] = 0
visited = [[False for _ in range(m)] for _ in range(n)]

dq = deque()
dq.append([target_x, target_y])
while dq:
    x, y = dq.popleft()
    visited[x][y] = True
    for i in range(4):
        m_x = x + move[i][0]
        m_y = y + move[i][1]
        if -1 < m_x < n and -1 < m_y < m:
            if (board[m_x][m_y] > board[x][y] + 1 or board[m_x][m_y] == 1) and visited[m_x][m_y] is False:
                board[m_x][m_y] = board[x][y] + 1
                dq.append([m_x, m_y])

for i in range(n):
    for j in range(m):
        if visited[i][j] is False and board[i][j] != 0:
            print(-1, end=' ')
        else:
            print(board[i][j], end=' ')
    print()