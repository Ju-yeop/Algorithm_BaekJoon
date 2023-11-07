num = int(input())
for i in range(num):
    ls = list(map(int, str(i)))
    if i + sum(ls) == num:
        print(i)
        break
    if i == num-1:
        print(0)