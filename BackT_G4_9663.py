"""
8 -> 92
"""
from sys import stdin
N = int(stdin.readline())

board = [[0 for _ in range(N)] for _ in range(N)]
answer = [0]
def backt(stack):
    if len(stack) == N: answer[0] += 1
    for i in range(N):
        if i in stack: continue
        cant = []
        for idx, j in enumerate(stack):
            cant.append(j + (len(stack) - idx))
            cant.append(j - (len(stack) - idx))
        if i in cant: continue
        stack.append(i)
        backt(stack)
        stack.pop()

backt([])
print(answer[0])