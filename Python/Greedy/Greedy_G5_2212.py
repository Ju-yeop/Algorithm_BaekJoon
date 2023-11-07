"""
10
5
20 3 14 6 7 8 18 10 12 15
"""
from sys import stdin
n = int(stdin.readline())
k = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
ls.sort()
if n <= k:
    print(0)
else:
    dist = []
    for i in range(n-1): dist.append(ls[i+1] - ls[i])
    dist.sort()
    for i in range(k-1):
        dist.pop()
    print(sum(dist))