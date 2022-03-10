from sys import stdin

N, M = map(int, stdin.readline().split())
ls = [int(stdin.readline()) for _ in range(N)]
start, end = 0, max(ls) * M
result = 0

while start <= end:
    mid = (start + end) // 2
    compare = 0  # 특정시간(mid)동안 검사할 수 있는 사람 수
    for temp in ls:
        compare += mid//temp
    if compare >= M:
        end = mid - 1
    else:
        start = mid + 1
        result = start

print(result)