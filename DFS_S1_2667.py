"""
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
"""
from sys import stdin
n = int(stdin.readline())
ls = [list(map(int, stdin.readline().strip())) for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
result = []
global cnt

def dfs(x, y):
    global cnt
    if visited[x][y] is True: return
    visited[x][y] = True
    for k in range(4):
        mx = x + dx[k]
        my = y + dy[k]
        if -1 < mx < n and -1 < my < n:
            if visited[mx][my] is False and ls[mx][my] == 1:
                cnt += 1
                dfs(mx, my)

for i in range(n):
    for j in range(n):
        if ls[i][j] == 1 and visited[i][j] is False:
            cnt = 1
            dfs(i, j)
            result.append(cnt)

result.sort()
print(len(result))
for i in result:
    print(i)
