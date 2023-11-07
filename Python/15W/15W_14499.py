from sys import stdin

N, M, x, y, K = map(int, stdin.readline().split())
matrix = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
commands = list(map(int, stdin.readline().strip().split()))
move = [[0, 1], [0, -1], [-1, 0], [1, 0]]
dice = [0 for _ in range(6)]

for i in range(K):
    command = commands[i]
    m_x = x + move[command-1][0]
    m_y = y + move[command-1][1]
    if m_x < 0 or m_x >= N or m_y < 0 or m_y >= M:
        continue

    if command == 1:
        dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
    elif command == 2:
        dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
    elif command == 3:
        dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
    elif command == 4:
        dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

    if matrix[m_x][m_y] == 0:
        matrix[m_x][m_y] = dice[5]
    else:
        dice[5] = matrix[m_x][m_y]
        matrix[m_x][m_y] = 0

    x, y = m_x, m_y

    print(dice[0])