from sys import stdin
from collections import deque

N = int(stdin.readline())
M = int(stdin.readline())
matrix = [list(map(int, stdin.readline().strip().split())) for _ in range(M)]
visited = [0 for _ in range(N+1)]
dq = deque()

visited[1] = 1
dq.append(1)
while dq:
    x = dq.popleft()
    for j in range(M):
        if matrix[j][0] == x and visited[matrix[j][1]] == 0:
            visited[matrix[j][1]] = 1
            dq.append(matrix[j][1])

result = 0
for v in visited:
    if v == 1:
        result += 1

print(result-1)  # 1번 컴퓨터 제외


