import heapq
import sys

N, K = map(int, sys.stdin.readline().split())

jewelry = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
bag = [int(sys.stdin.readline()) for _ in range(K)]
jewelry.sort()
bag.sort()

result = 0
temp = []

for bagWeight in bag:
    while jewelry and bagWeight >= jewelry[0][0]:
        heapq.heappush(temp, -jewelry[0][1])
        heapq.heappop(jewelry)

    if temp:
        result -= heapq.heappop(temp)

print(result)