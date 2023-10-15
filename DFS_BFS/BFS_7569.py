"""
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
"""
from sys import stdin
from collections import deque

m, n, h = map(int, stdin.readline().split())
ls = [[[] for _ in range(n)] for _ in range(h)]
que = deque()
dz = [0, 0, 0, 0, 1, -1]
dy = [1, -1, 0, 0, 0, 0]
dx = [0, 0, 1, -1, 0, 0]
result = 0

for i in range(h):
    for j in range(n):
        temp = list(map(int, stdin.readline().strip().split()))
        for k in range(len(temp)):
            if temp[k] == 1:
                que.append([i, j, k, 0])
        ls[i][j].extend(temp)

while que:
    z, y, x, day = que.popleft()
    result = day
    for i in range(6):
        m_z = z + dz[i]
        m_y = y + dy[i]
        m_x = x + dx[i]
        if -1 < m_z < h and -1 < m_y < n and -1 < m_x < m:
            if ls[m_z][m_y][m_x] == 0:
                ls[m_z][m_y][m_x] = 1
                que.append([m_z, m_y, m_x, day+1])

for i in range(h):
    for j in range(n):
        for k in range(m):
            if ls[i][j][k] == 0:
                print(-1)
                exit(0)

print(result)

