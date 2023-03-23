from itertools import combinations

L, C = map(int, input().split())
ls = list(input().split())
ls = sorted(ls)
vowel_ls = ['a', 'e', 'i', 'o', 'u']
del_num = 0

result = list(map(''.join, combinations(ls, L)))
for i in range(len(result)):
    vowel_cnt = 0
    for j in vowel_ls:
        if j in result[i-del_num]:
            vowel_cnt += 1
    if vowel_cnt == 0 or vowel_cnt > L-2:
        del result[i-del_num]
        del_num += 1

for each in result:
    print(each)