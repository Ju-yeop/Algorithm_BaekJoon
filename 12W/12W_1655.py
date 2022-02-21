#가운데를 말해요

from sys import stdin
import heapq

N = int(stdin.readline().strip())
heap = []
sorted_heap = []
for _ in range(N):
    input = int(stdin.readline().strip())
    heapq.heappush(heap, input)
    sorted_heap = []
    ls = []
    while heap:
        temp = heapq.heappop(heap)
        sorted_heap.append(temp)
        ls.append(temp)
    for i in ls:
        heapq.heappush(heap, i)
    if len(sorted_heap) % 2 == 0:
        print(sorted_heap[len(sorted_heap)//2 - 1])
    else:
        print(sorted_heap[len(sorted_heap)//2])