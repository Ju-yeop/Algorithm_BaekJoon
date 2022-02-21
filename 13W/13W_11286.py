import heapq
from sys import stdin

N = int(stdin.readline().strip())
max_heap_m = []
min_heap_p = []

for _ in range(N):
    x = int(stdin.readline().strip())
    if x > 0:
        heapq.heappush(min_heap_p, x)
    elif x < 0:
        heapq.heappush(max_heap_m, -x)
    elif x == 0:
        if not max_heap_m and min_heap_p:
            print(heapq.heappop(min_heap_p))
            continue
        elif max_heap_m and not min_heap_p:
            print(-heapq.heappop(max_heap_m))
            continue
        elif not max_heap_m and not min_heap_p:
            print(0)
            continue

        minus_value = heapq.heappop(max_heap_m)
        plus_value = heapq.heappop(min_heap_p)
        if minus_value == plus_value:
            print(-minus_value)
            heapq.heappush(min_heap_p, plus_value)
        else:
            if min(minus_value, plus_value) == minus_value:
                print(-minus_value)
                heapq.heappush(min_heap_p, plus_value)
            else:
                print(plus_value)
                heapq.heappush(max_heap_m, minus_value)
