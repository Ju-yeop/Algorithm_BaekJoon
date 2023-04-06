"""
5
12 7 9 15 5
13 8 11 19 6
21 10 26 31 16
48 14 28 35 25
52 20 32 41 49
"""
from sys import stdin
n = int(stdin.readline())
ls = []
for _ in range(n):
    ls.extend(list(map(int, stdin.readline().strip().split())))
    ls.sort(reverse=True)
    while len(ls) > n:
        ls.pop()
print(ls[n-1])

