def solution(A, B, C, D, N, Chips):
    choco = [[0] * (A + 1) for _ in range(B + 1)]

    for chip in Chips:
        choco[chip[1]][chip[0]] = 1

    for i in range(1, B + 1):
        for j in range(1, A + 1):
            choco[i][j] += choco[i - 1][j] + choco[i][j - 1] - choco[i - 1][j - 1]

    answer = 0
    for frame in [(C, D), (D, C)]:
        for i in range(frame[0], B + 1):
            for j in range(frame[1], A + 1):
                chips = choco[i][j] - choco[i - frame[0]][j] - choco[i][j - frame[1]] + choco[i - frame[0]][j - frame[1]]
                answer = max(answer, chips)

    return answer

print(solution(10, 10, 3, 2, 7, [[2, 2], [2, 3], [2, 4], [6, 2], [6, 3], [6, 4], [3, 5]]))
