"""
3 2
1 2 1 2 1 2
"""
"""
벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
"""

from sys import stdin
from collections import deque

n, k = map(int, stdin.readline().split())
ls = list(map(int, stdin.readline().strip().split()))
robot = deque([0 for _ in range(n)])
belt = deque(ls)
dur_cnt = 0
answer = 0

while belt.count(0) < k:
    answer += 1
    robot.rotate(1)
    belt.rotate(1)
    robot[-1] = 0
    if sum(robot) != 0:
        for i in range(n - 2, -1, -1):
            if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] >= 1:
                belt[i+1] -= 1
                robot[i+1] = 1
                robot[i] = 0
        robot[-1] = 0
    if belt[0] != 0 and robot[0] == 0:
        belt[0] -= 1
        robot[0] = 1
print(answer)







