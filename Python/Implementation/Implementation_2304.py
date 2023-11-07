"""
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6
"""

# from sys import stdin
# n = int(stdin.readline())
# ls = []
# for _ in range(n):
#     temp = list(map(int, stdin.readline().strip().split()))
#     ls.append(temp)
# ls.sort()
# answer = 0
# most = ls.index(max(ls, key=lambda x: x[1]))
# flag = 0
# judge = False
# if n == 1:
#     print(ls[0][1])
#     exit()
# for i in range(most+1):
#     if ls[i][1] > ls[flag][1]:
#         answer += ((ls[i][0] - ls[flag][0]) * ls[flag][1])
#         flag = i
# for j in range(most, n):
#     h = ls.index(max(ls[flag+1:], key=lambda x: x[1]))
#     if ls[h][1] == ls[most][1]:
#         judge = True
#     if j < h: continue
#     answer += ((ls[h][0] - ls[flag][0]) * ls[h][1])
#     flag = h
# if judge is False:
#     print(answer + ls[most][1])
# else:
#     print(answer)

from sys import stdin
input = stdin.readline
m = 0
m_idx = 0
pli = [0 for _ in range(1001)] # 기둥
for _ in range(int(input())):
    L, H = map(int, input().split())
    pli[L] = H
    if m < H: # 가장 높은 기둥과 그 기둥의 인덱스를 찾음
        m_idx = L
        m = H
curr = 0
answer = 0
for i in range(m_idx+1): # 왼쪽 그룹
    curr = max(curr, pli[i])
    answer += curr
curr = 0
for i in range(1000, m_idx, -1): # 오른쪽 그룹
    curr = max(curr, pli[i])
    answer += curr
print(answer)

