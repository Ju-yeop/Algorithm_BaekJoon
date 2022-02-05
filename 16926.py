import sys

N, M, R = map(int, sys.stdin.readline().strip().split())
mrx = []
for _ in range(N):
    mrx.append(list(map(int, sys.stdin.readline().strip().split())))

for _ in range(R):
    for i in range(min(N, M) // 2):
        front, back = i, i
        temp = mrx[front][back]
        for j in range(i + 1, N - i):
            front = j
            previous = mrx[front][back]
            mrx[front][back] = temp
            temp = previous
        for j in range(i + 1, M - i):
            back = j
            previous = mrx[front][back]
            mrx[front][back] = temp
            temp = previous
        for j in range(i + 1, N - i):
            front = N - j - 1
            previous = mrx[front][back]
            mrx[front][back] = temp
            temp = previous
        for j in range(i + 1, M - i):
            back = M - j -1
            previous = mrx[front][back]
            mrx[front][back] = temp
            temp = previous

for i in range(N):
    for j in range(M):
        print(mrx[i][j], end=' ')
    print()


# 겉부분?만 돌리는거를 어떻게 구현해야할까 고민하다가
# 제한에 min(n,m) mod 2 보고 힌트얻음
