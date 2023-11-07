from sys import stdin
n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
result = [n]
for i in range(n-1, 0, -1):
    cnt = 0
    for j in result:
        if ls[i-1] == 0:
            result.insert(0, i)
            break
        if j > i:
            cnt += 1
        if ls[i-1] == cnt:
            result.insert(cnt, i)
            break
for i in result:
    print(i, end=" ")
