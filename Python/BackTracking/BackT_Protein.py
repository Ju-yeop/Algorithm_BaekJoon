day, dec = map(int, input().split())
inc_ls = list(map(int, input().split()))
visited = [0] * day
cnt = 0

def protein(i, arr, total):
    global cnt
    if i == day:
        cnt += 1
    else:
        for j in range(day):
            if not visited[j]:
                visited[j] = True
                if total + arr[j] - dec >= 0:
                    total = total + arr[j] - dec
                    protein(i+1, arr, total)
                    total = total - (arr[j] - dec)
                visited[j] = False


protein(0, inc_ls, 0)
print(cnt)