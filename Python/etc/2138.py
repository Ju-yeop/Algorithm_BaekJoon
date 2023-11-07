N = int(input())
in_ls = list(input())
out_ls = list(input())
temp_ls = in_ls[::]
c1_count = 1
c2_count = 0

def change(ls, a):
    if a == 0:
        for p in range(2):
            if ls[p] == '0':
                ls[p] = '1'
            else:
                ls[p] = '0'
    elif a == N-1:
        for q in range(2):
            if ls[a-q] == '0':
                ls[a-q] = '1'
            else:
                ls[a-q] = '0'
    else:
        for v in range(-1, 2):
            if ls[a+v] == '0':
                ls[a+v] = '1'
            else:
                ls[a+v] = '0'
    return ls


#case1
change(temp_ls, 0)
for i in range(1, N):
    if temp_ls[i-1] != out_ls[i-1]:
        temp_ls = change(temp_ls, i)
        c1_count += 1
#case2
for j in range(1, N):
    if in_ls[j-1] != out_ls[j-1]:
        in_ls = change(in_ls, j)
        c2_count += 1

if in_ls == out_ls and temp_ls == out_ls:
    print(min(c1_count, c2_count))
elif in_ls == out_ls:
    print(c2_count)
elif temp_ls == out_ls:
    print(c1_count)
else:
    print(-1)