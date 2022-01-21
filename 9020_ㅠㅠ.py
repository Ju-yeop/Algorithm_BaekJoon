"""
import math
def judgement(num):
    if num == 1:
        return False
    for i in range(2, int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    return True

all_list = list(range(2, 10001))
prn_list = []
for i in all_list:
    if judgement(i):
        prn_list.append(i)
n = int(input())
for _ in range(n):
    x = int(input())
    ls = []
    miva = []
    for i in range(len(prn_list)):
        for j in range(i, len(prn_list)):
            if prn_list[i] + prn_list[j] == x:
                ls.append([prn_list[i], prn_list[j]])
    if len(ls) > 1:
        for v in range(len(ls)):
            mi = abs(ls[v][1] - ls[v][0])
            miva.append(mi)
        ind = miva.index(min(miva))
        print(sorted(ls[ind])[0], sorted(ls[ind])[1])
    else:
        print(sorted(ls[0])[0], sorted(ls[0])[1])

내 코드 시간초과... 다시 풀자
"""


def Goldbach():
    check = [False, False] + [True] * 10000

    for i in range(2, 101):
        if check[i] == True:
            for j in range(i + i, 10001, i):
                check[j] = False

    T = int(input())
    for _ in range(T):
        n = int(input())
        A = n // 2
        B = A
        for _ in range(10000):
            if check[A] and check[B]:
                print(A, B)
                break
            A -= 1
            B += 1

Goldbach()

#결국 구글링...

