from collections import deque
from sys import stdin

N, M = map(int, stdin.readline().strip().split())
mrx = [list(map(int, stdin.readline().strip())) for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
result = [[0 for _ in range(M)] for _ in range(N)]
move = [[0, 1], [0, -1], [-1, 0], [1, 0]]

def bfs(x, y):
    ls = deque()
    ls.append([x, y])
    count = 1
    while True:
        if len(ls) == 0:
            break
        new_x, new_y = ls.popleft()
        for i in range(4):
            move_x = new_x + move[i][0]
            move_y = new_y + move[i][1]
            if (-1 < move_x < N) and (-1 < move_y < M):
                if visited[move_x][move_y] is False and mrx[move_x][move_y] == 0:
                    visited[move_x][move_y] = True
                    ls.append([move_x, move_y])
                    count += 1

    for v in range(N):
        for w in range(M):
            visited[v][w] = False

    return count % 10


for p in range(N):
    for q in range(M):
        if mrx[p][q] == 0:
            pass
        else:
            result[p][q] = bfs(p, q)
        print(result[p][q], end='')
    print()

"""
for p in range(N):
    for q in range(M):
        if mrx[p][q] == 0:
            result[p][q] = bfs(p, q)
        print(result[p][q], end='')
    print()
    
    이거 왜이래 씨이이이이이이이이발!!!!!!!!!!!!!!!!!!!!!!!!!!
"""


"""
중복되는 부분이 뭘까...
탐색했던 인덱스를 재탐색? x
두 벽이 0으로 이어져 있으면 굳이 또 카운트할 필요가 없네 Count 수가 같을거니까 -> 아니네...
각 영역마다 0의 개수를 카운트하고 1인 곳에서 상하좌우에 카운트 수를 더해줘야되나? 이게 더 빠를거 같긴한데.. 그럼 이걸 다 갈아엎어?ㅋ
영역마다 이름을 지정해서 같은 영역에 있는 0들 중 하나만 돌리는거지
"""
