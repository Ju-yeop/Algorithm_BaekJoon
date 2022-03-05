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
            if matrix[i][0] == target:
                check_ls.append([matrix[i][1], matrix[i][2]])
            elif matrix[i][1] == target:
                check_ls.append([matrix[i][0], matrix[i][2]])


