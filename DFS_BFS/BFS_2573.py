"""
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
"""
from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
graph = []
for _ in range(n): graph.append(list(map(int, stdin.readline().strip().split())))
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
result = 0
num = 1

def bfs(a, b):
    island = deque()
    island.append([a, b])
    visited[a][b] = True
    while island:
        x, y = island.popleft()
        cnt = 0
        for i in range(4):
            m_x = x + dx[i]
            m_y = y + dy[i]
            if -1 < m_x < n and -1 < m_y < m:
                if visited[m_x][m_y] is False:
                    if graph[m_x][m_y] == 0:
                        cnt += 1
                    else:
                        visited[m_x][m_y] = True
                        island.append([m_x, m_y])
        if graph[x][y] - cnt <= 0:
            graph[x][y] = 0
        else:
            graph[x][y] -= cnt

while num < 2 and num != 0:
    num = 0
    visited = [[False for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if graph[i][j] != 0 and visited[i][j] is False:
                num += 1
                bfs(i, j)
    result += 1

if num == 0:
    print(0)
else:
    print(result-1)
