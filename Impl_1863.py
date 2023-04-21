"""
10
1 1
2 2
5 1
6 3
8 1
11 0
15 2
17 3
20 2
22 1

4
1 4
2 3
3 5
4 4

6
1 1
2 2
5 3
6 1
7 3
8 2
"""
from sys import stdin
from collections import deque

n = int(stdin.readline())
ls = []
mx = 0
set_height = set([])
for _ in range(n):
    temp = list(map(int, stdin.readline().strip().split()))
    mx = max(mx, temp[1])
    set_height.add(temp[1])
    ls.append(temp)
ls.sort()

ls.append([ls[-1][0], 0])
flag = False
cnt = 0
for i in set_height:
    for j in range(len(ls)):
        if ls[j][1] == i:
            flag = True
        elif flag is True and ls[j][1] < i:
            cnt += 1
            flag = False
print(cnt)

def impl():
    global ls
    ls = deque(ls)
    width = ls[-1][0] + 1
    height = mx + 1
    building = [[0 for _ in range(width)] for _ in range(height)]
    current = 0
    x, y = 0, 0
    while current != width:
        if current == ls[0][0]:
            x, y = ls.popleft()
        for i in range(y):
            building[i][current] = 1
        current += 1
    cnt = 0
    for i in range(height - 1, -1, -1):
        flag = 0
        for j in range(width):
            if building[i][j] == 1:
                if flag == 0 and building[i][j] != 2:
                    cnt += 1
                for v in range(i + 1):
                    building[v][j] = 2
                flag = 1
            elif building[i][j] == 0:
                flag = 0
    print(cnt)