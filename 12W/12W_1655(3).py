from sys import stdin
import heapq

N = int(stdin.readline().strip())
max_heap = []
min_heap = []
for i in range(N):
    num = int(stdin.readline().strip())
    if len(max_heap) == len(min_heap):
        heapq.heappush(max_heap, -num)
    else:
        heapq.heappush(min_heap, num)
    if max_heap and min_heap and max_heap[0] * -1 > min_heap[0]:
        left = heapq.heappop(max_heap) * -1
        right = heapq.heappop(min_heap)
        heapq.heappush(max_heap, right * -1)
        heapq.heappush(min_heap, left)
    print(max_heap[0] * -1)