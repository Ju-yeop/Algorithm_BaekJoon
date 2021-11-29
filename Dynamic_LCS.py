A = list(map(int, input().split()))
B = list(map(int, input().split()))
length = len(A)
dp = [1] * length

for i in range(length):
    for j in range(i):
        if A[i] in B.index(A[j])