n = int(input())
ls = [1, 3, 5]
for i in range(3, n+1):
    ls.append(2*ls[i-2] + ls[i-1])
print(ls[n-1] % 10007)