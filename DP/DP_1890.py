"""
4
2 3 3 1
1 2 1 3
1 2 3 1
3 1 1 0
"""

from sys import stdin

n = int(stdin.readline())
ls = []
for _ in range(n): ls.append(list(map(int, stdin.readline().strip().split())))
dx = [0, 1]
dy = [1, 0]
dp = [[-1 for _ in range(n)] for _ in range(n)]

def dfs(x, y):
    if x == n-1 and y == n-1:
        return 1
    value = ls[x][y]
    if value == 0:
        return 0
    if dp[x][y] == -1:
        dp[x][y] = 0
        for i in range(2):
            m_x = x + dx[i] * value
            m_y = y + dy[i] * value
            if -1 < m_x < n and -1 < m_y < n:
                dp[x][y] += dfs(m_x, m_y)
    return dp[x][y]

print(dfs(0, 0))