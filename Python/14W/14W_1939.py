from sys import stdin, maxsize

N, M = map(int, stdin.readline().split())
matrix = [list(map(int, stdin.readline().strip().split())) for _ in range(M)]
result = list(map(int, stdin.readline().strip().split()))

def dfs():
    final = maxsize
    semi = maxsize
    ls = [i for i in range(1, N + 1)]
    check_ls = [[result[0], 0]]
    while check_ls:
        target, weight = check_ls.pop()
        if weight < semi:
            semi = weight
        for i in range(M):
            if matrix[i][0] == target:                         # 전에 나왔던 경로 & 첫 경로 제외하는 조건 추가해야돼
                check_ls.append([matrix[i][1], matrix[i][2]])  # -> visited 추가해주면 되긴한데 시간초과...
            elif matrix[i][1] == target:
                check_ls.append([matrix[i][0], matrix[i][2]])

# 이렇게 하면 다리가 두개일 경우가 처리가 안돼
# -> 다리가 두개일 경우에는 더 중량제한이 더 큰걸로 적용하는 if문 걸어주면 되긴해


