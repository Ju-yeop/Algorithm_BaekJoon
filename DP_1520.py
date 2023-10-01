"""
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
"""

from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
ls = []
for _ in range(n):
    ls.append(list(map(int, stdin.readline().strip().split())))
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
dp = [[-1 for _ in range(m)] for _ in range(n)]

def dfs(x, y):
    if x == n - 1 and y == m - 1:
        return 1
    if dp[x][y] == -1:
        dp[x][y] = 0
        for i in range(4):
            m_x = x + dx[i]
            m_y = y + dy[i]
            if -1 < m_x < n and -1 < m_y < m:
                if ls[m_x][m_y] < ls[x][y]:
                    dp[x][y] += dfs(m_x, m_y)
    return dp[x][y]

print(dfs(0, 0))