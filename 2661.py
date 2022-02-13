from sys import stdin

N = int(stdin.readline().strip())
ls = [1]
option = [1, 2, 3]

def comparison():     #겹치는 부분수열이 있는지 확인
    judge = False
    temp = ls[::-1]
    for i in range(1, len(ls)//2 + 1):
        if temp[0:i] == temp[i:i*2]:
            judge = True
            return judge


def b_t(depth, ls):
    if comparison():
        return False
    if depth == N:
        for num in ls:
            print(num, end='')
        return True
    for i in range(3):
        ls.append(option[i])
        if b_t(depth + 1, ls) is True:
            return True
        ls.pop()

b_t(1, ls)