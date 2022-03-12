from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
chz_ls = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
sector_ls = [[0 for _ in range(M)] for _ in range(N)]
move = [[1, 0], [-1, 0], [0, 1], [0, -1]]
sector_num = 1

# 구역리스트에서 가장자리 -1로 초기화

for i in [0, N-1]:
    for j in range(M):
        sector_ls[i][j] = -1
for i in [0, M-1]:
    for j in range(N):
        sector_ls[j][i] = -1


def judge(a, b): #벽과 접해있는지 확인
    for i in range(4):
        t = a + move[i]
        p = b + move[i]
        if sector_ls[t][p] == -1:
            return True
    return False


def sector_bfs(x, y):
    dq = deque()
    dq.append([x, y])
    while dq:
        p_x, p_y = dq.popleft()
        for i in range(4):
            m_x = p_x + move[i]
            m_y = p_y + move[i]
            if -1 < m_x < N and -1 < m_y < M:
                if sector_ls[m_x][m_y] == 0:
                    sector_ls[m_x][m_y] = sector_num
                    dq.append([m_x, m_y])

#공기와 접해있는 영역 bfs로 탐색 -> 이 영역과 접해 있는 1인 영역 탐색(가장자리) -> 가장자리 0으로 초기화