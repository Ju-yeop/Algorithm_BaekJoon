N = int(input())
color_ls = []
answer = 1
for _ in range(N):
    color = list(input())
    color_ls.append(color)

def judge(ls):
    result = 1
    for i in range(N):
        temp = 1
        for j in range(N-1):
            if ls[i][j] == ls[i][j+1]:
                temp += 1
            else:
                temp = 1
            if result < temp:
                result = temp

    for p in range(N):
        temp = 1
        for q in range(N-1):
            if ls[q][p] == ls[q+1][p]:
                temp += 1
            else:
                temp = 1
            if result < temp:
                result = temp

    return result


for i in range(N):
    for j in range(N-1):
        color_ls[i][j], color_ls[i][j+1] = color_ls[i][j+1], color_ls[i][j]
        if answer < judge(color_ls):
            answer = judge(color_ls)
        color_ls[i][j+1], color_ls[i][j] = color_ls[i][j], color_ls[i][j+1]

for p in range(N):
    for q in range(N-1):
        color_ls[q][p], color_ls[q+1][p] = color_ls[q+1][p], color_ls[q][p]
        if answer < judge(color_ls):
            answer = judge(color_ls)
        color_ls[q+1][p], color_ls[q][p] = color_ls[q][p], color_ls[q+1][p]

print(answer)