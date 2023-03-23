N = int(input())
ls = [1] * 100
for i in range(5):
    ls[i] = i+1

for j in range(5, N):
    ls[j] = max(ls[j-3] * 2, ls[j-4] * 3, ls[j-5] * 4)

print(ls[N-1])

#직접써서 풀음. 비교적 직관적으로 쉽게 푼 듯 DP Table
