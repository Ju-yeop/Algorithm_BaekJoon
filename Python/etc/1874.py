N = int(input())
ls = []
result = []
count = 1
judge = True
for _ in range(N):
    num = int(input())
    for i in range(count, num+1):
        if count <= num:
            result.append('+')
            ls.append(count)
            count += 1
    if ls[-1] == num:
        result.append('-')
        ls.pop()
    else:
        judge = False

if judge == True:
    for i in result:
        print(i)
else:
    print('NO')