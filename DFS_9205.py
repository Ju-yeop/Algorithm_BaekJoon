"""
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000
"""
from sys import stdin

t = int(stdin.readline())


def dfs(x, status):
    if x == n + 1:
        return True
    for i in range(n + 2):
        distance = abs(ls[i][0] - ls[x][0]) + abs(ls[i][1] - ls[x][1])
        if visited[i] is False and distance <= 1000:
            visited[x] = True
            status = dfs(i, status)
    return status

for _ in range(t):
    ls = []
    n = int(stdin.readline())
    for _ in range(n+2): ls.append(list(map(int, stdin.readline().strip().split())))
    visited = [False for _ in range(n+2)]

    result = dfs(0, False)
    if result is True: print("happy")
    else: print("sad")
