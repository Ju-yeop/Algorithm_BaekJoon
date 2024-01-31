from itertools import combinations

global cnt


def solution(dice):
    global cnt
    answer = []
    result = 0
    dl = len(dice)
    temp = list(combinations(range(dl), dl // 2))
    cb = temp[:dl // 2 + 1]
    for target in cb:
        opponent = []
        for i in range(dl):
            if i not in target:
                opponent.append(i)
        cnt = 0
        dfs(target, opponent, [], [], dice)

        if result < cnt:
            result = cnt
            answer = target

    return answer


def dfs(ta, op, t, o, dice):
    global cnt
    if len(t) == len(ta) and len(o) == len(op):
        if sum(t) > sum(o): cnt += 1
        return

    if len(t) != len(ta):
        for i in dice[ta[len(t)]]:
            t.append(i)
            dfs(ta, op, t, o, dice)
            t.pop()
    elif len(o) < len(op):
        for j in dice[op[len(o)]]:
            if sum(t) <= sum(o): return
            o.append(j)
            dfs(ta, op, t, o, dice)
            o.pop()

solution([[1,2,3,4,5,6],[3,3,3,3,4,4],[1,3,3,4,4,4],[1,1,4,4,5,5]])