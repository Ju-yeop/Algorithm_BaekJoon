N = int(input())
ls = [1, 2, 4]
for _ in range(N):
    value = int(input())
    for i in range(len(ls), value):
        ls.append((ls[i-1] + ls[i-2] + ls[i-3]) % 1000000009)
    print(ls[value-1])