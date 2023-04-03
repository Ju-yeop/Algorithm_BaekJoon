"""
5 17
ANSWER : 2
"""
# from sys import stdin
#
# n, k = map(int, stdin.readline().split())
# dp = [0 for _ in range(200001)]
#
# if n != 0:
#     for i in range(n, -1, -1): dp[i] = n - i
# for v in range(n , 200001): dp[v] = v - n
#
# for j in range(n+1, 200000):
#     if j % 2 == 0:
#         dp[j] = min(dp[j//2], dp[j-1] + 1, dp[j+1] + 1)
#     else:
#         dp[j] = min(dp[j+1] + 1, dp[j-1] + 1)
#     temp = j * 2
#     while temp < 200001:
#         dp[temp] = min(dp[j], dp[temp])
#         temp *= 2
#
# print(dp[k])

from sys import stdin
from collections import deque
import heapq

n, k = map(int, stdin.readline().split())

def bfs():
    dq = deque()
    dx = [2, -1, 1]
    visited = [False] * 100001
    dq.append([0, n])
    while dq:
        time, x = dq.popleft()
        if x == k:
            print(time)
            break
        for i in dx:
            if i == 2:
                m_x = x * i
                if 0 <= m_x < 100001 and visited[m_x] is False:
                    dq.append([time, m_x])
                    visited[m_x] = True
            else:
                m_x = x + i
                if 0 <= m_x < 100001 and visited[m_x] is False:
                    dq.append([time+1, m_x])
                    visited[m_x] = True

def dijkstra():
    INF = 21470000
    time = [INF] * 100001
    time[n] = 0
    hq = []
    heapq.heappush(hq, (0, n))
    while hq:
        t, x = heapq.heappop(hq)
        for item in [(t, x*2), (t+1, x+1), (t+1, x-1)]:
            if 0 <= item[1] < 100001 and time[item[1]] > item[0]:
                time[item[1]] = item[0]
                heapq.heappush(hq, (time[item[1]], item[1]))
    print(time[k])

dijkstra()

