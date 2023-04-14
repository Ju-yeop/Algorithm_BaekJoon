"""
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
"""
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(i, j, graph, costs):
    queue = deque()
    queue.append((i, j))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if costs[nx][ny] > costs[x][y] + graph[nx][ny]:
                    costs[nx][ny] = costs[x][y] + graph[nx][ny]
                    queue.append((nx, ny))


count = 1
while True:
    n = int(input())
    if n == 0:
        break
    graph = []
    costs = [[int(1e9)] * n for _ in range(n)]
    for _ in range(n):
        graph.append(list(map(int, input().split())))

    costs[0][0] = graph[0][0]
    bfs(0, 0, graph, costs)
    print(f'Problem {count}: {costs[n - 1][n - 1]}')
    count += 1