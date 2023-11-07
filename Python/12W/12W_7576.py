#토마토
#그림 그리면서 박스 채워 나가다가 그림 그리는 과정을 그대로 알고리즘으로 적용

from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
tomato = [list(map(int, stdin.readline().strip().split())) for _ in range(M)]
move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
tmt_loc = deque()
for i in range(M):
    for j in range(N):
        if tomato[i][j] == 1:
            tmt_loc.append([i, j])    #익은 토마토 큐에 저장


def bfs(tmt_loc):
    while tmt_loc:
        x, y = tmt_loc.popleft()
        for i in range(len(move)):
            move_x = x + move[i][0]
            move_y = y + move[i][1]
            if -1 < move_x < M and -1 < move_y < N:
                if tomato[move_x][move_y] == 0:
                    tomato[move_x][move_y] = tomato[x][y] + 1    #이웃한 노드로 이동할때마다 이전의 값+1
                    tmt_loc.append([move_x, move_y])


bfs(tmt_loc)
result = -1
for i in range(M):
    for j in range(N):
        if tomato[i][j] == 0:
            print(-1)
            exit(0)          #break -> 틀렸습니다     exit(1) -> 런타임에러(NZEC)
        else:                #<sys.exit() -> 프로그램 종료,  exit() -> 쉘에서 사용>
            result = max(tomato[i][j], result)

print(result-1)  #첫 시작을 1로 설정했기 때문에 -1

"""
result = max(max(tomato)) - 1  ㅡ> 틀렸습니다? 11.11 반례    ->     result = max(map(max, tomato))
print(max(tomato))
print(tomato)
"""


