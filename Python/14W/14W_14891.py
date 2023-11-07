from sys import stdin
from collections import deque

wheels = deque(deque(map(int, stdin.readline().strip())) for _ in range(4))
K = int(stdin.readline())
result = 0

def spin(num, direction):
    wheels[num-1].rotate(direction)

def r_check(num, direction):
    if num+1 < 5: #다음 톱니가 있으면
        if wheels[num-1][2] != wheels[num][6]:
            r_check(num+1, -direction)
            spin(num+1, direction)
        else:
            return
    else:
        return

def l_check(num, direction):
    if num-1 > 0: #전 톱니가 있으면
        if wheels[num-1][6] != wheels[num-2][2]:
            l_check(num-1, -direction)
            spin(num-1, direction)
        else:
            return
    else:
        return


for _ in range(K):
    N, D = map(int, stdin.readline().split())
    r_check(N, -D)
    l_check(N, -D)
    spin(N, D)

for i in range(4):
    if wheels[i][0] == 1:
        result += pow(2, i)

print(result)