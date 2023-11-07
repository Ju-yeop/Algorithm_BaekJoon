"""
100 2 1 1 0
"""
from sys import stdin
from collections import deque

f, s, g, u, d = map(int, stdin.readline().strip().split())
move = [u, -d]
visited = [False for _ in range(f+1)]
visited[0] = True
visited[s] = True
dq = deque()
dq.append([s, 0])

while dq:
    now, cnt = dq.popleft()
    if now == g:
        print(cnt)
        exit(0)
    for i in range(2):
        m = now + move[i]
        if -1 < m < f+1 and visited[m] is False:
            dq.append([m, cnt + 1])
            visited[m] = True

if len(dq) == 0:
    print("use the stairs")