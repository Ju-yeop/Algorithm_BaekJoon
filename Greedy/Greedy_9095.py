A = int(input())
ls = [1, 2, 4]
for k in range(A):
    N = int(input())
    for i in range(len(ls), N):
        ls.append(ls[i-1] + ls[i-2] + ls[i-3])
    print(ls[N-1])