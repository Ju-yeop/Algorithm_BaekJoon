h, w = map(int, input().split())
ls = []
count_ls = []
for _ in range(h):
    temp_ls = list(input())
    ls.append(temp_ls)

for k in range(h - 7):
    for p in range(w - 7):
        count = 0
        for i in range(8):
            for j in range(8):
                if ls[k+i][p] == 'B':
                    if j % 2 == 0:
                        if ls[i + k][j + p] != 'B':
                            count += 1
                    elif j % 2 == 1:
                        if ls[i + k][j + p] != 'W':
                            count += 1
                elif ls[k+i][p] == 'W':
                    if j % 2 == 0:
                        if ls[i + k][j + p] != 'W':
                            count += 1
                    elif j % 2 == 1:
                        if ls[i + k][j + p] != 'B':
                            count += 1
        count_ls.append(count)
print(count_ls)