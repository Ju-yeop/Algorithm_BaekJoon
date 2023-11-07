"""
3 6
HFDFFB
AJHGDH
DGAGEH
"""

from sys import stdin
from collections import defaultdict
# r, c = map(int, stdin.readline().split())
# board = [list(map(int, stdin.readline().strip().split())) for _ in range(r)]
# move = [[0, 1], [1, 0], [0, -1], [-1, 0]]   # 동쪽부터 시계방향
# visited = [[False for _ in range(c)] for _ in range(r)]
#
# dq = deque()
# dq.append([0, 0])
# while dq:
#     x, y = dq.popleft()
#     visited[x][y] = True
#     for i in range(4):
#         m_x = x + move[i][0]
#         m_y = y + move[i][1]
#         if -1 < m_x < r and -1 < m_y < c:
#             if visited[m_x][m_y] is False and b


"""
list에 기록이 아닌 dictionary
방문했는지는 체크하지 않아도 된다. 알파벳 여부에 종속
"""
r, c = map(int, stdin.readline().split())
board = [list(stdin.readline()) for _ in range(r)]
move = [[0, 1], [1, 0], [0, -1], [-1, 0]]   # 동쪽부터 시계방향
result = 1
dic = defaultdict(int)
dic[board[0][0]] = 1

def dfs(x, y, depth):
    global result
    result = max(result, depth)
    for i in range(4):
        m_x = x + move[i][0]
        m_y = y + move[i][1]
        if -1 < m_x < r and -1 < m_y < c:
            if dic[board[m_x][m_y]] == 0:
                dic[board[m_x][m_y]] += 1
                dfs(m_x, m_y, depth+1)
                dic[board[m_x][m_y]] -= 1
    return result

"""
DFS 시간초과
BFS 큐 안에 리스트를 가지고 있는 구조
리스트가 스트링이라면 앞에 새로운 요소를 추가하고 POP하면 Deque popleft를 쓰는 것과 똑같이 작동한다.
"""

def bfs():
    global result
    queue = {(0, 0, board[0][0])}
    while queue:
        x, y, z = queue.pop()
        result = max(result, len(z))
        for i in range(4):
            m_x = x + move[i][0]
            m_y = y + move[i][1]
            if -1 < m_x < r and -1 < m_y < c and board[m_x][m_y] not in z:
                queue.add((m_x, m_y, board[m_x][m_y] + z))

print(dfs(0, 0, 1))