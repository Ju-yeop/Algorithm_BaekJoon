"""
13
0
1
2
0
0
3
2
1
0
0
0
0
0
"""
import heapq
from sys import stdin

ls = []
heapq.heapify(ls)
n = int(stdin.readline())
for _ in range(n):
    t = int(stdin.readline())
    if t == 0:
        if len(ls) == 0:
            print(0)
        else: print(-heapq.heappop(ls))
    else: heapq.heappush(ls, -t)