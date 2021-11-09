n, m = map(int, input().split())

ls = []

def dfs():
    if len(ls) == m:
        print(' '.join(map(str, ls)))
        return
    for i in range(1, n+1):
        if i not in ls:
            ls.append(i)
            dfs()
            ls.pop()

dfs()