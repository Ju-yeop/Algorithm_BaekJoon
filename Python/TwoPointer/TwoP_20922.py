from sys import stdin
from collections import defaultdict

n, k = map(int, stdin.readline().split())
ls = list(map(int, stdin.readline().strip().split()))

dic = defaultdict(int)
start, end = 0, 0
answer = 0

while end < n:
    if dic[ls[end]] < k:
        dic[ls[end]] += 1
        end += 1
    else:
        dic[ls[start]] -= 1
        start += 1
    answer = max(answer, end - start)

print(answer)