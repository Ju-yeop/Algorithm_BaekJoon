"""
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
"""
from sys import stdin
from collections import deque

n = int(stdin.readline())
ls = []
mx = 0
for _ in range(n):
    temp = list(map(int, stdin.readline().strip().split()))
    t = max(temp)
    mx = max(mx, t)
    ls.append(temp)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
result = 0

for i in range(mx):
    cnt = 0
    visited = [[False for _ in range(n)] for _ in range(n)]
    for a in range(n):
        for b in range(n):
            if visited[a][b] is False and ls[a][b] > i:
                cnt += 1
                dq = deque()
                dq.append([a, b])
                visited[a][b] = True
                while dq:
                    x, y = dq.popleft()
                    for j in range(4):
                        m_x = x + dx[j]
                        m_y = y + dy[j]
                        if -1 < m_x < n and -1 < m_y < n:
                            if visited[m_x][m_y] is False and ls[m_x][m_y] > i:
                                dq.append([m_x, m_y])
                                visited[m_x][m_y] = True
    result = max(result, cnt)

print(result)