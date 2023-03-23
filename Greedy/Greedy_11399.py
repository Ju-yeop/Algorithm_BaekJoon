N = int(input())
ls = list(map(int, input().split()))
ls.sort()
sls = [ls[0]]
for i in range(1, N):
    sls.append(sls[i-1] + ls[i])
print(sum(sls))