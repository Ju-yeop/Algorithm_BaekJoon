"""
10
1 2 3 4 5 6 7 8 9 10
"""

from sys import stdin

N = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
ls.sort()
answer = 0

for i in range(len(ls)):
    key = ls[i]
    start, end = 0, len(ls)-1
    while start < end:
        if start == i:
            start += 1
            continue
        elif end == i:
            end -= 1
            continue

        if ls[start] + ls[end] < key: start += 1
        elif ls[start] + ls[end] > key: end -= 1
        else:
            answer += 1
            break

print(answer)