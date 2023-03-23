N = int(input())
distance = list(map(int, input().split()))
price = list(map(int, input().split()))
total = distance[0] * price[0]
min_price = price[0]

for i in range(1, N-1):
    if min_price > price[i]:
        min_price = price[i]
    total += (distance[i] * min_price)

print(total)