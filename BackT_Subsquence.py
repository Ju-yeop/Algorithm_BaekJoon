n, result = map(int, input().split())
num_ls = list(map(int, input().split()))
result_ls = []
total = 0

def dfs(i, arr):
    global total
    if i >= n:
        return
    total = total + arr[i]
    dfs