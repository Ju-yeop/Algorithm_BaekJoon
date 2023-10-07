"""
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
"""
from sys import stdin

t = int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    ls = []
    for _ in range(2):
        ls.append(list(map(int, stdin.readline().strip().split())))
    if n > 1:
        ls[1][1] += ls[0][0]
        ls[0][1] += ls[1][0]
    for i in range(2, n):
        ls[0][i] += max(ls[1][i-1], ls[1][i-2])
        ls[1][i] += max(ls[0][i-1], ls[0][i-2])

    print(max(ls[0][n-1], ls[1][n-1]))
