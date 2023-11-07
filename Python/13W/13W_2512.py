from sys import stdin
from collections import deque

N = int(stdin.readline().strip())
temp = list(map(int, stdin.readline().strip().split()))
M = int(stdin.readline().strip())
temp.sort(reverse=True)
ls = deque(temp)
if sum(ls) <= M:
    print(max(ls))
else:
    for i in range(len(ls)):
        ls.popleft()
        benchmark = (M - sum(ls)) / (i+1)
        if False not in list(map(lambda x: x<=benchmark, ls)):
            print(int(benchmark))
            exit(0)
    print(M//N)

