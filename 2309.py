ls = []
for _ in range(9):
    ls.append(int(input()))

copy_ls = ls.copy()
total = sum(ls)
first = True
for i in range(9):
    for j in range(i+1, 9):
        if ls[i] + ls[j] == total-100 and first:
            del copy_ls[i], copy_ls[j-1]
            first = False

copy_ls.sort()
for k in range(7):
    print(copy_ls[k])