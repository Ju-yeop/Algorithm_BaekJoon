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
    x, y = map(int, stdin.readline().split())
    flag = max(flag, y)
    ls.append([x, y])
    hq.append([-y, x])

heapq.heapify(hq)
heapq.heapify(ls)
cnt = 0
result = 0

while cnt <= flag:
    cnt += 1
    mx = 0
    while ls:
        popItem = heapq.heappop(ls)
        rItem = heapq.heappop(hq)
        if popItem[0] <= cnt:
            mx = max(mx, popItem[1])
        else:
            if len(hq) == 0:
                mx = -heapq.heappop(rItem)
                
            heapq.heappush(ls, popItem)
            heapq.heappush(hq, rItem)
            break
    result += mx

print(result)
