from sys import stdin
import heapq

N = int(stdin.readline().strip())
heap = []
for _ in range(N):
    heapq.heappush(heap, int(stdin.readline().strip()))

result = 0
while len(heap) > 1:
    first = heapq.heappop(heap)
    second = heapq.heappop(heap)
    temp = first + second
    result += temp
    heapq.heappush(heap, temp)

print(result)