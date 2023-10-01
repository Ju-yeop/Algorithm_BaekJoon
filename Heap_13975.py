"""
2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32
"""
from sys import stdin
import heapq

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    ls = list(map(int, stdin.readline().strip().split()))
    heapq.heapify(ls)
    result = 0
    while len(ls) > 1:
        x = heapq.heappop(ls)
        y = heapq.heappop(ls)
        temp = x + y
        heapq.heappush(ls, temp)
        result += temp
    print(result)
