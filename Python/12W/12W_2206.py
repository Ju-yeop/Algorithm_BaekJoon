from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
road = [list(map(int, stdin.readline().strip())) for _ in range(N)]
move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
visited = [[False for _ in range(M)] for _ in range(N)]

def dfs(x, y):
    distance = 0
    bifurcation_distance = 0   #분기점까지의 거리
    dq = deque()
    visited[x][y] = True
    dq.append([x, y])
    while True:
        if len(dq) == 0:
            break
        p_x, p_y = dq.popleft()
        if p_x == N-1 and p_y == M-1:
            distance = bifurcation_distance
        distance += 1  # POP 할 때 마다 거리 +1
        plus_cnt = 0              #분기점 판단을 위한 변수 (몇 개가 추가됐는지)
        for i in range(len(move)):
            move_x = p_x + move[i][0]
            move_y = p_y + move[i][1]
            if -1 < move_x < N and -1 < move_y < M:
                if visited[move_x][move_y] is False and road[move_x][move_y] == 0:
                    dq.append([move_x][move_y])              #최단 거리를 구할때 끝점까지 갔다가 분기점으로 다시 돌아오는 경우를 생각
                    visited[move_x][move_y] = True
                    plus_cnt += 1
        if plus_cnt >= 2:                #한 분기점에서 두개 이상의 요소가 추가될경우 그 분기점까지의 거리를 변수에 저장
            bifurcation_distance = distance

"""
<벽은 생각하지않은 최단거리 알고리즘>
분기점마다의 거리를 저장해두고 끝점에 도착할때마다 거리를 비교해서 최소값을 구한다.
-> 방문 확인하는 리스트를 계속 초기화해야되서 무조건 시간초과
-> 분기점 이후에 방문했던 좌표만 기억해놨다가 그것만 초기화 -> 이것도 시간초과
"""