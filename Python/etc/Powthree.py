"""N의 패턴은 공백으로 채워진 가운데의(N / 3)×(N / 3)
정사각형을 크기 N / 3의 패턴으로 둘러싼 형태"""


def pr(pl):
    for p in range(m):
        for q in range(m):
            print(pl[p][q], end="")
        print('')


def hole(n, li):
    a = int(n/3)
    if n == 1:
        pr(ls)
        return
    for i in range(n):
        for j in range(n):
            if n / 3 < i + 1 <= 2 * n / 3 and n / 3 < j + 1 <= 2 * n / 3:
                li[i][j] = " "
    hole(int(n/3), li)


m = int(input())
ls = []
new_ls = []

for _ in range(m):
    ls.append(list("*" * m))

hole(m, ls)