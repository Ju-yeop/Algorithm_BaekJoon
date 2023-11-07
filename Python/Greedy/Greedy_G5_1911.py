"""
3 3
1 6
13 17
8 12
"""
from sys import stdin
from collections import deque

n, l = map(int, stdin.readline().split())
ls = [list(map(int, stdin.readline().strip().split())) for _ in range(n)]
ls.sort(key=lambda x: x[0])
dq = deque(ls)
nul = -1
result = 0
while dq:
    start, end = dq.popleft()
    while nul < end:
        if start > nul:
            nul = start + l
            result += 1
        elif start <= nul:
            if end <= nul:
                continue
            elif end > nul:
                nul += l
                result += 1

print(result)

