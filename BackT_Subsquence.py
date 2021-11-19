n, result = map(int, input().split())
num_ls = list(map(int, input().split()))
cnt = 0

def dfs(i, arr, total):
    global cnt
    if i >= n:
        return
    total = total + arr[i]
    dfs(i+1, arr, total - arr[i])
    dfs(i+1, arr, total)
    if total == result:
        cnt += 1


dfs(0, num_ls, 0)
print(cnt)