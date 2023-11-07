from sys import stdin, maxsize
from collections import deque

N, M = map(int, stdin.readline().split())
matrix = [[] for _ in range(M+1)]
for i in range(M):
    a, b, c = map(int, stdin.readline().split())
    matrix[a].append([b, c])
    matrix[b].append([a, c])
start, end = map(int, stdin.readline().split())

max_w = 0

def bfs(start, end, mid):
    route = deque()
    route.append(start)
    visited = [False] * (N+1)
    visited[start] = True
    while route:
        temp = route.popleft()
        if temp == end:
            return True
        for goal, weight in matrix[temp]:
            if not visited[goal] and weight >= mid:
                visited[goal] = True
                route.append(goal)
    return False


low, high = 1, 1000000000
while low <= high:
    mid = (low + high) // 2
    if bfs(start, end, mid):
        result = mid
        low = mid + 1
    else:
        high = mid - 1

print(result)



