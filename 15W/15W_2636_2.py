from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
chz_ls = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
move = [[1, 0], [-1, 0], [0, 1], [0, -1]]
time = 0
result = 0

for i in range(N):
    for j in range(M):
        if chz_ls[i][j] == 1:
            result += 1

def bfs(x):
    dq = deque()
    visited = [[0 for _ in range(M)] for _ in range(N)]
    dq.append([0, 0])
    visited[0][0] = 1
    while dq:
        p_x, p_y = dq.popleft()
        for i in range(4):
            m_x = p_x + move[i][0]
            m_y = p_y + move[i][1]
            if -1 < m_x < N and -1 < m_y < M and visited[m_x][m_y] == 0:
                visited[m_x][m_y] = 1
                if chz_ls[m_x][m_y] == 1:
                    x -= 1
                    chz_ls[m_x][m_y] = -1
                elif chz_ls[m_x][m_y] == 0:
                    dq.append([m_x, m_y])

    for i in range(N):
        for j in range(M):
            if chz_ls[i][j] == -1:
                chz_ls[i][j] = 0

    return x


final = result
while result != 0:
    result = bfs(result)
    time += 1
    if result > 0:
        final = result

print(time)
print(final)