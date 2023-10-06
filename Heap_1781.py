"""
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1
"""
from sys import stdin
import heapq

n = int(stdin.readline())
ls = []
hq = []
flag = 0
for _ in range(n):
    dead, cup = map(int, stdin.readline().split())
    flag = max(flag, dead)
    heapq.heappush(ls, [-dead, cup])

result = 0

while flag > 0:

    while ls:
        item = heapq.heappop(ls)
        if -item[0] >= flag:
            heapq.heappush(hq, -item[1])
        else:
            heapq.heappush(ls, item)
            break
    if hq:
        result += (-heapq.heappop(hq))
    flag -= 1

print(result)