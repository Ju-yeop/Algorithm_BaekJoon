n = int(input())
ls = []
ord_list = []

for _ in range(n):
    wh = list(map(int, input().split()))
    ls.append(wh)

for i in range(len(ls)):
    order = 1
    for j in range(len(ls)):
        if ls[i][0] < ls[j][0] and ls[i][1] < ls[j][1]:
            order += 1
    print(order, end=' ')