from sys import stdin

N, M = map(int, stdin.readline().split())
r, c, d = map(int, stdin.readline().split())
matrix = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
move = [[-1, 0], [0, 1], [1, 0], [0, -1]]
visited[r][c] = 1
cnt = 1

while True:
    judge = 0
    for _ in range(4):
        d = (d + 3) % 4  # 왼쪽으로 회전
        m_x = r + move[d][0]
        m_y = c + move[d][1]
        if -1 < m_x < N and -1 < m_y < M and matrix[m_x][m_y] == 0:
            if visited[m_x][m_y] == 0:
                visited[m_x][m_y] = 1
                r, c = m_x, m_y
                cnt += 1
                judge = 1
                break
    if judge == 0:
        if matrix[r-move[d][0]][c-move[d][1]] == 1:
            print(cnt)
            exit(0)
        else:
            r, c = r - move[d][0], c-move[d][1]

