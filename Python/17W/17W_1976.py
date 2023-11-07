from sys import stdin
from collections import deque

N = int(stdin.readline())
M = int(stdin.readline())
ls = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
destination = list(map(int, stdin.readline().strip().split()))
roads = []
judge = [False] * (N+1)
judge[0] = True
judge[destination[0]] = True
for i in range(N):
    for j in range(N):
        if ls[i][j] == 1:
            roads.append([i+1, j+1])

for v in range(0, len(destination)-1):
    dq = deque()
    visited = [False] * (N + 1)
    visited[destination[v]] = True
    dq.append(destination[v])
    while dq:
        loc = dq.popleft()
        for road in roads:
            if road[0] == loc and visited[road[1]] is False:
                dq.append(road[1])
                visited[road[1]] = True
                if road[1] == destination[v+1]:
                    judge[destination[v+1]] = True
                    break
    if judge[destination[v+1]] is False:
        print("NO")
        exit(0)

print("YES")




