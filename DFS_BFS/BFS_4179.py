"""
4 4
####
#JF#
#..#
#..#

4 6
######
......
#.J###
#F####

3 3
###
#J.
#.F

4 6
######
......
#.J###
#F####

5 4
####
#...
#.##
#.J#
####

7 7
#######
#J#####
#.....#
#.#.#.#
#.#.#.#
F.#.#.#
##F.#.#

7 7
#######
#J###F#
#.....#
#.#.#.#
#.#.#.#
F.#.#.#
##F.#.#
"""
from sys import stdin
from collections import deque
r, c = map(int, stdin.readline().split())
board = [list(stdin.readline().strip()) for _ in range(r)]
visited = [[False for _ in range(c)] for _ in range(r)]
dq = deque()
fire = []
fire_next = []
move = [[0, 1], [1, 0], [0, -1], [-1, 0]]
flag = -1
for i in range(r):
    for j in range(c):
        if board[i][j] == "J":
            dq.append([i, j, 0])
            visited[i][j] = True
        if board[i][j] == "F":
            fire.append([i, j])

while dq:
    x, y, t = dq.popleft()
    if flag != t:
        for a, b in fire:
            for v in range(4):
                m_a = a + move[v][0]
                m_b = b + move[v][1]
                if -1 < m_a < r and -1 < m_b < c:
                    if board[m_a][m_b] == '.' or board[m_a][m_b] == 'J':
                        board[m_a][m_b] = 'F'
                        fire_next.append([m_a, m_b])
        fire = fire_next
        fire_next = []

    for i in range(4):
        m_x = x + move[i][0]
        m_y = y + move[i][1]
        if (m_x < 0 or m_x >= r) or (m_y < 0 or m_y >= c):
            print(t+1, end='')
            exit()
        if board[m_x][m_y] == "." and visited[m_x][m_y] is False:
            dq.append([m_x, m_y, t+1])
            visited[m_x][m_y] = True
    flag = t

print("IMPOSSIBLE", end='')
