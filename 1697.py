#숨바꼭질

import sys
from collections import deque

MAX = 100000
n,k = map(int, sys.stdin.readline().split())
ls = [0] * (MAX+1)

def bfs():
    q = deque()
    q.append(n)
    while q:
        x = q.popleft()
        if x == k:
            print(ls[x])
            break
        for j in (x-1,x+1,x*2):
            if 0<= j <= MAX and not ls[j]:
                ls[j] = ls[x] +1
                q.append(j)

bfs()






