#텀 프로젝트
#원형큐?

import sys

def dfs(x):
    global cycle
    visited[x] = True
    temp_cycle.append(x)
    num = arr[x]

    if visited[num]:
        if num in temp_cycle:
            cycle += temp_cycle[temp_cycle.index(num):]
        return
    else:
        dfs(num)


T = int(input())
for _ in range(T):
    n = int(sys.stdin.readline())
    arr = [0] + list(map(int, sys.stdin.readline().split()))
    visited = [False] * (n + 1)
    cycle = []

    for i in range(1, n + 1):
        if not visited[i]:
            temp_cycle = []
            dfs(i)

    print(n - len(cycle))