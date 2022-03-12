from sys import stdin

N = int(stdin.readline())
ls = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
result = 0

for i in range(N):
    day = i + 1
    money = 0
    while day + (ls[day-1][0] - 1) < N+1:
        money += ls[day - 1][1]
        if ls[day-1][0] == 1:
            day += (ls[day - 1][0])
        else:
            day += (ls[day-1][0] - 1)
    result = max(result, money)

print(result)