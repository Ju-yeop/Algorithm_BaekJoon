"""
회전 고려
방법 1. 리스트 앞에 sequence - 1 만큼의 리스트 끝 부분 추가
방법 2. while 문으로 바꾼 후 len(sushi)가 되면 다시 0으로 보낸후 sequence - 1 인덱스에 도착하면 while 종료

큐가 아닌 투 포인터 풀이 가능
"""

from sys import stdin
from collections import deque

dish, diversity, sequence, coupon = map(int, stdin.readline().split())
sushi = [int(stdin.readline()) for _ in range(dish)]
sushi = sushi[-sequence+1:] + sushi
dq = deque()
result = 0

for i in range(len(sushi)):
    if len(dq) >= sequence:
        dq.popleft()
    dq.append(sushi[i])

    if len(dq) >= sequence:
        dq_set = set(dq)
        t_result = len(dq_set)
        if coupon not in dq_set:
            t_result += 1
        result = max(result, t_result)
        if result == sequence + 1: break

print(result)