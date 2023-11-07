from sys import stdin
from collections import deque

M, N, K = map(int, stdin.readline().split())
rec_position = [list(map(int, stdin.readline().strip().split())) for _ in range(K)]
paper = [[0 for _ in range(N)] for _ in range(M)]
visited = [[False for _ in range(N)] for _ in range(M)]  #직사각형 범위를 1로 표시할 때 쓰이는 방문체크리스트
bfs_visited = [[False for _ in range(N)] for _ in range(M)]  #bfs할 때 쓰이는 방문체크리스트
move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
result = []

for temp in rec_position:
    for i in range(temp[1], temp[3]):          #앞 좌표는 그대로 뒤 좌표는 x,y에 각각 -1
        for j in range(temp[0], temp[2]):      #x,y 좌표 치환하면 리스트와 동일해짐
            if not visited[i][j]:
                visited[i][j] = True
                paper[i][j] = 1           #직사각형이 그려진 범위는 1로 표시

def bfs(x, y):
    cnt = 1
    dq = deque()
    dq.append([x, y])
    bfs_visited[x][y] = True
    while dq:
        n_x, n_y = dq.popleft()
        for v in range(4):
            m_x = n_x + move[v][0]
            m_y = n_y + move[v][1]
            if -1 < m_x < M and -1 < m_y < N:
                if paper[m_x][m_y] == 0 and bfs_visited[m_x][m_y] is False:
                    dq.append([m_x, m_y])
                    bfs_visited[m_x][m_y] = True
                    cnt += 1
    return cnt


for i in range(M):
    for j in range(N):
        if paper[i][j] == 0 and bfs_visited[i][j] is False:
            result.append(bfs(i, j))


print(len(result))
for r in sorted(result):
    print(r, end=' ')