"""
9
noon
is
lunch
for
most
noone
waits
until
two
"""

from sys import stdin
from collections import defaultdict

n = int(stdin.readline())
ls = []
for _ in range(n):
    temp = str(stdin.readline().strip())
    ls.append(temp)

sls = sorted(enumerate(ls), key=lambda x: x[1])
result = 0
length = [0] * (n+1)
for i in range(n-1):
    first = sls[i][1]
    second = sls[i+1][1]
    if first == second: continue
    cnt = 0
    for j in range(min(len(first), len(second))):
        if first[j] == second[j]: cnt += 1
        else: break
        result = max(result, cnt)

        length[sls[i][0]] = max(length[sls[i][0]], cnt)
        length[sls[i + 1][0]] = max(length[sls[i + 1][0]], cnt)

first = 0
for i in range(n):
    if first == 0:
        if length[i] == max(length):
            first = ls[i]
            print(first)
            pre = ls[i][:result]
    else:
        if length[i] == max(length) and ls[i][:result] == pre:
            print(ls[i])
            break

