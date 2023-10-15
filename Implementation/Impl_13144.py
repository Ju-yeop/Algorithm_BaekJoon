"""
5
1 2 3 1 2
"""
# 투 포인터로 구현 가능

from sys import stdin
from collections import defaultdict

N = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
dic = defaultdict(int)

answer = 0
mx = 0
for i in range(N):
    key = ls[i]
    mx = max(dic[key], mx)
    answer += (i - mx + 1)
    dic[key] = i+1
print(answer)