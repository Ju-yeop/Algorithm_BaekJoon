#치킨거리

from pprint import pprint
from sys import stdin, maxsize
from itertools import combinations

N, M = map(int, stdin.readline().split())
city = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
house = []
chicken = []

for i in range(N):
    for j in range(N):
        if city[i][j] == 1:
            house.append([i, j])
        if city[i][j] == 2:
            chicken.append([i, j])

chicken_c = list(combinations(chicken, M))

city_dis = maxsize
for i in range(len(chicken_c)):
    chic_dis_sum = 0
    for v in range(len(house)):
        dis_min = N * 2
        for j in range(M):
            dis_min = min(dis_min, (abs(house[v][0] - chicken_c[i][j][0])) + (abs(house[v][1] - chicken_c[i][j][1])))
        chic_dis_sum += dis_min
    city_dis = min(city_dis, chic_dis_sum)

print(city_dis)