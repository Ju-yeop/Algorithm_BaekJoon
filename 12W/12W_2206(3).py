from collections import deque
from sys import stdin

N, M = map(int, stdin.readline().split())
road = [list(map(int, stdin.readline().strip())) for _ in range(N)]
move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
visited[0][0][1] = 1

def bfs():
    dq = deque()
    dq.append([0, 0, 1])
    while dq:
        x, y, z = dq.popleft()
        if x == N-1 and y == M-1:
            return visited[x][y][z]
        for i in range(len(move)):
            move_x = x + move[i][0]
            move_y = y + move[i][1]
            if -1 < move_x < N and -1 < move_y < M:
                if road[move_x][move_y] == 0 and visited[move_x][move_y][z] == 0: #길(벽이 아님)이고 방문한적 없을 경우
                    visited[move_x][move_y][z] = visited[x][y][z] + 1
                    dq.append([move_x, move_y, z])
                elif road[move_x][move_y] == 1 and z == 1: #벽이고 벽을 부술 수 있는 경우
                    visited[move_x][move_y][0] = visited[x][y][1] + 1
                    dq.append([move_x, move_y, 0])
    return -1


print(bfs())