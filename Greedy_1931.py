n = int(input())
ls = []

for i in range(n):
    temp = list(map(int, input().split()))
    ls.append(temp)

ls.sort(key=lambda x: x[0])
ls.sort(key=lambda x: x[1])

cnt = 1
last = ls[0][1]
for i in range(1, n):
    if ls[i][0] >= last:
        cnt += 1
        last = ls[i][1]
print(cnt)