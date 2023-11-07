"""
6 8
4 5 3
2 4 0
4 1 4
2 1 1
5 6 1
3 6 2
3 2 6
3 4 4
"""

from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    start, end, val = map(int, stdin.readline().split())
    graph[start].append([end, val])
    graph[end].append([start, val])

def dijkstra(node):
    result = [float('inf') for _ in range(n+1)]
    result[node] = 0
    hq = [(node, 0)]
    heapq.heapify(hq)
    while hq:
        prev_node, prev_value = heapq.heappop(hq)

        for next_node, dist in graph[prev_node]:
            if result[next_node] > prev_value + dist:
                result[next_node] = prev_value + dist
                heapq.heappush(hq, (next_node, result[next_node]))
    return result

print(dijkstra(1)[n])