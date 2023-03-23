"""
import sys
import time

start = time.time()

N, S = map(int, sys.stdin.readline().strip().split())
ls = list(map(int, sys.stdin.readline().strip().split()))

dq = []
minimum = N

if sum(ls) < S:
    minimum = 0
else:
    for i in ls:
        dq.append(i)
        while sum(dq) >= S:
            if sum(dq[1:]) >= S:
                dq.pop(0)
            else:
                if minimum > len(dq):
                    minimum = len(dq)
                break

print(minimum)
print("time :", time.time() - start)
"""

"""
import sys

N, S = map(int, sys.stdin.readline().strip().split())
ls = list(map(int, sys.stdin.readline().strip().split()))

start = 0
end = 1
minimum = N

if sum(ls) < S:
    minimum = 0
else:
    while end <= N:
        if sum(ls[start:end]) >= S:
            if sum(ls[start+1:end]) >= S:
                start += 1
            else:
                if minimum > end-start:
                    minimum = end-start
                end += 1
        else:
            end += 1

print(minimum)
"""

import sys

N, S = map(int, sys.stdin.readline().strip().split())
ls = list(map(int, sys.stdin.readline().strip().split()))

start = 0
end = 0
minimum = N
sum_result = 0

if sum(ls) < S:
    minimum = 0
else:
    while True:
        if sum_result >= S:
            if minimum > end - start:
                minimum = end - start
            sum_result -= ls[start]
            start += 1
        elif end == N:
            break
        else:
            sum_result += ls[end]
            end += 1

print(minimum)

"""
dq 접근 -> pop(0) 시간
start, end 포인트 -> 슬라이싱 시간복잡도 O(b-a)? 이거때문인지 정확히 모르겠어

"""