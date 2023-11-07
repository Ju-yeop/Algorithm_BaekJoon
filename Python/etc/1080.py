N, M = map(int, input().split())
in_ls = []
out_ls = []
count = 0
for _ in range(N):
    in_ls.append(list(map(int, input())))
for _ in range(N):
    out_ls.append(list(map(int, input())))

def change_3(ls, a, b):
    for p in range(3):
        for q in range(3):
            if ls[a+p][b+q] == 0:
                ls[a + p][b + q] = 1
            else:
                ls[a + p][b + q] = 0
    return ls


for i in range(N-2):
    for j in range(M-2):
        if in_ls[i][j] != out_ls[i][j]:
            in_ls = change_3(in_ls, i, j)
            count += 1

if in_ls != out_ls:
    print(-1)
else:
    print(count)