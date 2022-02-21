import heapq
from sys import stdin

N = int(stdin.readline().strip())
heap = []
for _ in range(N):
    x = int(stdin.readline().strip())
    if x == 0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap))
    elif x > 0:
        heapq.heappush(heap, x)