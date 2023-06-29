"""
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
"""

from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    s, e, d = map(int, stdin.readline().strip().split())
    graph[s].append([e, d])
    graph[e].append([s, d])
v1, v2 = map(int, stdin.readline().split())

def dijkstra(start):
    mini = [float('inf') for _ in range(n+1)]
    mini[start] = 0
    hq = [(start, mini[start])]
    heapq.heapify(hq)
    while hq:
        node, prev_m = heapq.heappop(hq)
        for item in graph[node]:
            if mini[item[0]] > item[1] + prev_m:
                mini[item[0]] = item[1] + prev_m
                heapq.heappush(hq, (item[0], mini[item[0]]))
    return mini

original_distance = dijkstra(1)
v1_distance = dijkstra(v1)
v2_distance = dijkstra(v2)

v1_path = original_distance[v1] + v1_distance[v2] + v2_distance[n]
v2_path = original_distance[v2] + v2_distance[v1] + v1_distance[n]

result = min(v1_path, v2_path)
print(result if result < float('inf') else -1)



