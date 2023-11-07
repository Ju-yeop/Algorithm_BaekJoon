"""
4 11
802
743
457
539
"""

from sys import stdin

k, n = map(int, stdin.readline().split())
ls = []
for _ in range(k):
    ls.append(int(stdin.readline()))
s, e = 0, (2**32) - 1
mid, cnt = 0, 0

while s <= e:
    cnt = 0
    mid = (s + e) // 2
    for i in ls: cnt += (i // mid)
    if cnt < n: e = mid - 1
    elif cnt >= n: s = mid + 1
print(e)