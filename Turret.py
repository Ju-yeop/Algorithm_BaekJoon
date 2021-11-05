n = int(input())
for _ in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = (x2 - x1) ** 2 + (y2 - y1) ** 2
    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
    elif (r1 + r2)**2 == d or (r1 - r2)**2 == d:
        print(1)
    elif (r1 + r2)**2 > d > (r1 - r2)**2:
        print(2)
    else:
        print(0)