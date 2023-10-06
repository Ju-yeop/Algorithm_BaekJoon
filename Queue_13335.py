"""
4 2 10
7 4 5 6
"""
from sys import stdin
from collections import deque

n, w, l = map(int, stdin.readline().split())
ls = list(map(int, stdin.readline().strip().split()))
ls.reverse()
dq = deque()
cnt = 0
while ls:
    cnt += 1
    for i in range(len(dq)):
        dq[i][1] -= 1
    if dq and dq[0][1] == 0: dq.popleft()
    t = 0
    for a, b in dq: t += a
    if t + ls[-1] <= l:
        dq.append([ls.pop(), w])

print(cnt + w)