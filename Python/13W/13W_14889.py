from itertools import combinations
from sys import stdin

N = int(stdin.readline())
score = [list(map(int, stdin.readline().strip().split())) for _ in range(N)]
item = [i for i in range(N)]
comb = list(combinations(item, 2))
total_score = []
result = []
for i, j in comb:
    temp = score[i][j] + score[j][i]
    total_score.append([i, j, temp])  #점수 합계를 리스트로 저장

team = list(combinations(item, N//2))  #팀을 나누는 경우의 수도 combinations으로 나눠
for i in team:
    temp = combinations(i, 2)    #팀을 나눈 뒤에 각팀에 combination을 해줘서 점수 합계에 저장된 점수와 연결해줘
    #아으 인덱스끼리 이어줄수가 없네....4중포문 써야돼
    #이어주지말고 바로 더해서 비교?