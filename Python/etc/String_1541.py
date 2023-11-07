x = input()
ls = []
temp_n = 0
total = 0

for i in range(len(x)):
    if x[i] == "-":
        temp_ls = x[temp_n:i]
        temp_n = i+1
        ls.append(temp_ls)
ls.append(x[temp_n:])

for j in range(len(ls)):
    if j == 0:
        total += sum(map(int, ls[j].split('+')))
    else:
        total -= sum(map(int, ls[j].split('+')))

print(total)


"""
x = input().split('-')
total = 0

def cal(ls, a):
    return sum(map(int, ls[a].split('+')))


for j in range(len(x)):
    if j == 0:
        total += cal(x, j)
    else:
        total -= cal(x, j)

print(total)
"""