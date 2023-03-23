N, K = map(int, input().split())
ls = []
cnt = 0
for _ in range(N):
    ls.append(int(input()))

ls.reverse()
for i in range(N):
    if K // ls[i] > 0:
        cnt += K // ls[i]
        K = K % ls[i]
    if K == 0:
        print(cnt)
        break