"""
2
3 2 2
2 1 5
3 2 5
3 3 1
2 1 2
3 1 8
3 2 4
"""
from sys import stdin
import heapq

t = int(stdin.readline())
for _ in range(t):
    n, d, h = map(int, stdin.readline().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(d):
        start, end, time = map(int, stdin.readline().split())
        graph[end].append([start, time])

    result = [float('inf') for _ in range(n+1)]
    result[h] = 0
    hq = []
    heapq.heappush(hq, (result[h], h))
    while hq:
        crtTime, crtNode = heapq.heappop(hq)
        if result[crtNode] < crtTime: continue

        for nextNode, nextTime in graph[crtNode]:
            t = result[crtNode] + nextTime
            if t < result[nextNode]:
                result[nextNode] = t
                heapq.heappush(hq, (result[nextNode], nextNode))
    cnt = 0
    mx = 0
    for i in result:
        if i != float('inf'):
            cnt += 1
            mx = max(mx, i)
    print(cnt, mx)