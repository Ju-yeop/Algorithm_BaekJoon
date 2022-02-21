from sys import stdin
import heapq

N = int(stdin.readline().strip())
heap = []
for i in range(N):
    input = int(stdin.readline().strip())
    heapq.heappush(heap, input)
    mid = ((len(heap) + 1) // 2) #중간
    temp_heap = heap.copy()
    for _ in range(mid-1): #중간값 전까지 전부 pop
        heapq.heappop(temp_heap)
    print(heapq.heappop(temp_heap))