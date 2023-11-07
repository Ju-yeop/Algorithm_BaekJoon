from itertools import combinations
from sys import stdin, maxsize

N = int(stdin.readline())
score = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
item = [i for i in range(N)]
result = maxsize
team = list(combinations(item, N//2))

for team1 in team[:len(team)//2]:
    team2 = [x for x in item if x not in team1]
    total1, total2 = 0, 0
    for p, q in combinations(team1, 2):
        total1 += (score[p][q] + score[q][p])
    for p, q in combinations(team2, 2):
        total2 += (score[p][q] + score[q][p])
    diff = abs(total1 - total2)
    if diff < result:
        result = diff

print(result)
