# 가방을 채울 때 보석의 무게가 가방의 무게보다 작은 보석중에 가치가 높은것
#   -> 가치가 높은 것을 정렬로 미리 세팅해놓는다

from sys import stdin

N, K = map(int, stdin.readline().split())
result = 0
jewerly = []
bag = []
for _ in range(N):
    jewerly.append(list(map(int, stdin.readline().strip().split())))
for _ in range(K):
    bag.append(int(stdin.readline()))

bag.sort()
jewerly.sort(key=lambda x: (x[1], x[0]), reverse=True)

for i in range(K):
    for j in range(len(jewerly)):
        if bag[i] >= jewerly[j][0]:
            result += jewerly[j][1]
            jewerly.pop(j)             #무조건 여기서 시간초과 -> 디큐나 힙 사용
            break

print(result)