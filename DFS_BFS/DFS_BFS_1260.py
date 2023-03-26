"""
4 5 1
1 2
1 3
1 4
2 4
3 4
"""
from sys import stdin
from collections import deque

n, m, v = map(int, stdin.readline().split())
ls = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, stdin.readline().split())
    ls[x].append(y)
    ls[y].append(x)
for i in range(n+1):
    ls[i].sort()

def dfs(s):
    visited[s] = True
    print(s, end=" ")
    for i in ls[s]:
        if visited[i] is False:
            dfs(i)

def bfs(s):
    q = deque()
    q.append(s)
    visited[s] = True
    while q:
        a = q.popleft()
        print(a, end=" ")
        for i in ls[a]:
            if visited[i] is False:
                q.append(i)
                visited[i] = True

dfs(v)
print()
visited = [False for _ in range(n+1)]
bfs(v)
