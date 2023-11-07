from sys import stdin

N = int(stdin.readline().strip())
ls = []
for _ in range(N):
    ls.append(int(stdin.readline().strip()))

result = 0
while len(ls) != 1:
    ls.sort(reverse=True)
    first = ls.pop()
    second = ls.pop()
    result += (first + second)
    ls.append(result)

print(result)

#시간복잡도 대충 생각해봐도 무조건 시간초과나는 코드...
#sort 계속 하지않고 처음 한번만 한 후에 <append한 수, 가장 마지막 수 2개>중 작은 수 2개를 더해서 append -> pop(item) 시간초과
