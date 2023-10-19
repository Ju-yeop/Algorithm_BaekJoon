"""
4 4
1231 1232 1233 1234
"""
from sys import stdin

n, m = map(int, stdin.readline().split())
ls = list(map(int, stdin.readline().strip().split()))
ls.sort()

def dfs(stack):
    if len(stack) == m:
        print(' '.join(map(str, stack)))
        return
    for i in range(n):
        if ls[i] in stack: continue
        stack.append(ls[i])
        dfs(stack)
        stack.pop()

dfs([])