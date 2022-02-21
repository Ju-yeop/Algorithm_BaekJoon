from sys import stdin
from collections import deque

N = int(stdin.readline().strip())
temp = list(map(int, stdin.readline().strip().split()))
M = int(stdin.readline().strip())
temp.sort(reverse=True)
ls = deque(temp)
if sum(ls) <= M:
    print(max(ls))
else:
    for i in range(len(ls)):
        ls.popleft()
        benchmark = (M - sum(ls)) / (i+1)
        if False not in list(map(lambda x: x<=benchmark, ls)):
            print(int(benchmark))
            exit(0)
    print(M//N)

"""
요소를 큰 것부터 하나씩 pop시키면서
큐에 남은 요소중 <(총예산 - pop시키고 남은 요소들의 합) / 지금까지 pop시킨 요소 개수> -> Test해보는 상한액
보다 큰게 없으면 그게 정답
끝까지 pop를 했는데 위와 같은 경우가 안나온다 
       -> 총 예산이 모든 지방의 예산보다 작거나 같다는 것이므로 총예산/지방의 수
"""