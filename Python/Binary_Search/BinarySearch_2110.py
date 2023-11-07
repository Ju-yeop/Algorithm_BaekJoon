from sys import stdin
n, c = map(int, stdin.readline().split())
house = []
for _ in range(n):
    temp = int(stdin.readline())
    house.append(temp)
house.sort()

start = 1
end = house[-1] - house[0]

while start <= end:
    mid = (start + end) // 2
    count = 1
    current = house[0]
    for i in range(1, n):
        if house[i] >= current + mid:
            count += 1
            current = house[i]
    if count >= c:
        start = mid + 1
    else:
        end = mid - 1
print(start-1)