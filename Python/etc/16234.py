from sys import stdin
from collections import deque

N, L, R = map(int, stdin.readline().split())
country = [list(map(int, stdin.readline().split())) for _ in range(N)]
move = [[0, 1], [0, -1], [-1, 0], [1, 0]]

# dq[x좌표, y좌표, 값]으로 이중 리스트 저장
def bfs(x, y):
    open_list = []
    dq = deque()
    dq.append([x, y, country[x][y]])
    visited[x][y] = True
    while True:
        if len(dq) == 0:
            break
        open_country = dq.popleft()
        m_x, m_y = open_country[0], open_country[1]
        open_list.append(open_country)
        for i in range(4):
            n_x = m_x + move[i][0]
            n_y = m_y + move[i][1]
            if -1<n_x<N and -1<n_y<N:
                if visited[n_x][n_y] is False and L <= abs(country[n_x][n_y] - country[m_x][m_y]) <= R:
                    dq.append([n_x, n_y, country[n_x][n_y]])
                    visited[n_x][n_y] = True
    return open_list


judge = True
count = 0
while judge:
    visited = [[False for _ in range(N)] for _ in range(N)]
    judge = False
    for i in range(N):
        for j in range(N):
            if visited[i][j] is False:
                open_list = bfs(i, j)
                if len(open_list) > 1:
                    judge = True
                    smr = 0
                    for p in range(len(open_list)):
                        smr += open_list[p][2]
                    country_avg = int(smr/len(open_list))
                    for q in range(len(open_list)):
                            country[open_list[q][0]][open_list[q][1]] = country_avg
    if judge:
        count += 1

print(count)



