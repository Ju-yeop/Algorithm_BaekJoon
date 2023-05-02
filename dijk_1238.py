"""
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
"""

import heapq
from sys import stdin
n, m, x = map(int, stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    start, end, time = map(int, stdin.readline().split())
    graph[start].append((end, time))

def dijkstra(start):
    result = [float('inf') for node in range(n+1)]
    result[start] = 0
    hq = []
    heapq.heappush(hq, (start, result[start]))
    while hq:
        crt_node, crt_dist = heapq.heappop(hq)
        if result[crt_node] < crt_dist: continue

        for new_node, new_dist in graph[crt_node]:
            temp_dist = new_dist + crt_dist
            if temp_dist < result[new_node]:
                result[new_node] = temp_dist
                heapq.heappush(hq, (new_node, result[new_node]))
    return result

answer = []
back = dijkstra(x)
for i in range(1, n+1):
    if i != x:
        answer.append(dijkstra(i)[x] + back[i])

print(max(answer))