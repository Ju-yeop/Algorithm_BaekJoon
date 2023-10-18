"""
4 6
101111
101010
101011
111011
"""
from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
ls = []
for _ in range(n):
    temp = list(map(int, stdin.readline().strip()))
    ls.append(temp)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
dq = deque()
dq.append([0, 0, 0])
visited = [[False for _ in range(m)] for _ in range(n)]
visited[0][0] = True

while dq:
    x, y, cnt = dq.popleft()
    if x == n-1 and y == m-1:
        print(cnt+1)
        break
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if -1 < mx < n and -1 < my < m:
            if visited[mx][my] is False and ls[mx][my] == 1:
                dq.append([mx, my, cnt + 1])
                visited[mx][my] = True