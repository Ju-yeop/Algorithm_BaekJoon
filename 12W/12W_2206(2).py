import copy
from collections import deque
from sys import stdin

N, M = map(int, stdin.readline().split())
road = [list(map(int, stdin.readline().strip())) for _ in range(N)]
temp = copy.copy(road)
move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
temp[0][0] = 1
result = []

def bfs(temp):
    dq = deque()
    dq.append([0, 0])
    while dq:
        x, y = dq.popleft()
        for i in range(len(move)):
            move_x = x + move[i][0]
            move_y = y + move[i][1]
            if -1 < move_x < N and -1 < move_y < M:
                if temp[move_x][move_y] == 0 or temp[move_x][move_y] > temp[x][y] + 1:  #다음 노드의 값이 0이거나
                    temp[move_x][move_y] = temp[x][y] + 1        #이전 노드의 값 +1한 값보다 다음노드의 값이 더 클경우
                    dq.append([move_x, move_y])
    return temp[N-1][M-1]


for i in range(N):
    for j in range(M):
        if i == 0 and j ==0:
            continue
        if road[i][j] == 1:
            temp = copy.copy(road)
            road[i][j] = 0
            value = bfs(temp)
            if temp[N-1][M-1] != 0:
                result.append(value)
            road[i][j] = 1

f = bfs(road)
if f != 0:
    result.append(f)
if len(result) == 0:
    print(-1)
else:
    print(min(result))

# 토마토 알고리즘에서 조건만 조금 바꿨고 벽은 하나씩 부숴가면서 거리 전부 체크 -> 21% 틀렸습니다