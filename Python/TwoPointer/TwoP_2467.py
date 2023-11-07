"""
5
-99 -2 -1 4 98
"""
from sys import stdin
n = int(stdin.readline())
ls = list(map(int, stdin.readline().split()))
ls.sort()
start, end = 0, n-1
answer = [ls[start], ls[end]]
while start < end:
    if abs(ls[start] + ls[end]) < abs(answer[0] + answer[1]):
        answer = [ls[start], ls[end]]

    if ls[start] + ls[end] > 0:
        end -= 1
    elif ls[start] + ls[end] <= 0:
        start += 1
print(answer[0], answer[1])