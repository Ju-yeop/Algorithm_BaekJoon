n = int(input())
ls = []
order = 1
ord_list = []
for _ in range(n):
    wh = list(map(int, input().split()))
    ls.append(wh)

while len(ls) != 0:
    for i in range(len(ls)):
        judge = True
        for j in range(len(ls)):
            if ls[i][0] < ls[j][0] or ls[i][1] < ls[j][1]:
                judge = False
                break
        if judge:
            ls.pop(i)
            ord_list.append(order)
    order += 1
print(ord_list)



