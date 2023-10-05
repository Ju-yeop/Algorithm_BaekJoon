"""
8
222 117
176 92
287 6
284 81
221 96
263 96
188 40
225 1
"""
from sys import stdin
n = int(stdin.readline())
ls = []
for _ in range(n):
    ls.append(list(map(int, stdin.readline().strip().split())))
result = 0

def dfs(x):
    global result
    if x == n:
        cnt = 0
        for i in ls:
            if i[0] <= 0: cnt += 1
        result = max(result, cnt)
        return

    if ls[x][0] <= 0:
        dfs(x+1)
        return

    check = True
    for i in range(n):
        if i == x:
            continue
        if ls[i][0] > 0:
            check = False
            break

    if check:
        result = max(result, n - 1)
        return

    for i in range(n):
        if x == i or ls[i][0] <= 0:
            continue
        ls[i][0] -= ls[x][1]
        ls[x][0] -= ls[i][1]
        dfs(x+1)
        ls[i][0] += ls[x][1]
        ls[x][0] += ls[i][1]

dfs(0)
print(result)
