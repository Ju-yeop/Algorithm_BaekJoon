from sys import stdin
import heapq

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
    temp = []
    for j in range(len(jewerly)):
        if bag[i] >= jewerly[j][0]:
            heapq.heappush(temp, jewerly[j][1])  #힙을 새로 만들어서 가방에 넣을 수 있는 것들을 전부 해당 리스트에 추가한 다음 가장 큰 값을 result에 더한다.
                                                        # 다음 for 문을 돌때 이미 result에 더한 보석은 제외하고 돌려야되는데
                                                        # 제외하려면 또 pop해야 하니까 전에 생각한것과 똑같은 문제
print(result)