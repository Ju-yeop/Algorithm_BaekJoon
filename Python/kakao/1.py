def solution(friends, gifts):
    answer = 0
    dic = defaultdict(int)
    for n, f in enumerate(friends):
        dic[f] = n
    fc = len(friends)
    board = [[0 for _ in range(fc)] for _ in range(fc)]
    for i in range(len(gifts)):
        gift = gifts[i]
        l = gift.split(" ")
        board[dic[l[0]]][dic[l[1]]] += 1
    print(board)
    return answer