"""
첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
둘째 줄에는 A1, A2, ..., AN이 주어진다.
(1 ≤ Ai ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데,
차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
2
5 6
0 0 1 0
"""

n = int(input())
n_arr = list(map(int, input().split()))
o_arr = list(map(int, input().split()))
result_ls = []

def operator(depth, result, plus, minus, multi, division):
    if depth == n:
        result_ls.append(result)
        return
    if plus:
        operator(depth + 1, result + n_arr[depth], plus - 1, minus, multi, division)
    if minus:
        operator(depth + 1, result - n_arr[depth], plus, minus - 1, multi, division)
    if multi:
        operator(depth + 1, result * n_arr[depth], plus, minus, multi - 1, division)
    if division:
        operator(depth + 1, int(result / n_arr[depth]), plus, minus, multi, division - 1)


operator(1, n_arr[0], o_arr[0], o_arr[1], o_arr[2], o_arr[3])
print(max(result_ls))
print(min(result_ls))
