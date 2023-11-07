n, m = map(int, input().split())

ls = []

def dfs(start):
    if len(ls) == m:
        print(' '.join(map(str, ls)))
        return
    for i in range(start, n+1):
        if i not in ls:
            ls.append(i)
            dfs(i+1)
            ls.pop()

dfs(1)