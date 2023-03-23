h, w = map(int, input().split())
ls = []
count_ls = []
for _ in range(h):
    temp_ls = list(input())
    ls.append(temp_ls)


for k in range(h - 7):
    for p in range(w - 7):
        wcount = 0
        bcount = 0
        for i in range(8):
            for j in range(8):
                if (i+j) % 2 == 0:
                    if ls[i + k][j + p] != 'B':
                        bcount += 1
                    else:
                        wcount += 1
                elif (i+j) % 2 == 1:
                    if ls[i + k][j + p] != 'W':
                        bcount += 1
                    else:
                        wcount += 1
        count_ls.append(wcount)
        count_ls.append(bcount)
print(min(count_ls))