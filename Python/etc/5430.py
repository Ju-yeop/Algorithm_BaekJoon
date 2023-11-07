#AC

from collections import deque
from sys import stdin

T = int(stdin.readline())

for _ in range(T):
    P = list(stdin.readline().strip())
    N = int(stdin.readline())
    ls = deque(stdin.readline().strip()[1:-1].split(','))
    judge = 0   #빈 리스트 판단 변수
    R_C = 0  #R의 개수 Count

    if N == 0:
        ls = []   #빈 리스트로 초기화

    for i in P:
        if i == 'R':
            R_C += 1
        elif i == 'D':
            if len(ls) == 0:
                print('error')
                judge = 1
                break
            else:
                if R_C % 2 == 0:
                    ls.popleft()
                else:               #Reverse->popleft와 pop은 같은 요소를 삭제
                    ls.pop()        #다만 for문이 끝났을때 R의 개수가 홀수개라면 마지막에 Reverse

    if judge == 0:
        if R_C % 2 == 1:
            ls.reverse()
        print('['+','.join(ls)+']')


# R:Reverse D:popleft -> 시간초과
# R이 연속해서 두번나오면 기존의 것이랑 같다 : D가 나올때마다
# 전까지 나온 R의 개수 체크해서 Reverse 판단 -> 시간초과