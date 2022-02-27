from sys import stdin

N, K = map(int, stdin.readline().strip().split())
coin = []
dp = [0] * (K+1)
dp[0] = 1
for i in range(N):
    coin.append(int(stdin.readline().strip()))
coin.sort()
for i in range(N):
    for j in range(coin[i], K+1):
        if i == 0:
            if j % coin[i] == 0:   #첫 dp는 만들려는 수를 동전으로 나눴을 때 나누어떨어지는 수들만 +1
                dp[j] += 1
        else:
            dp[j] += dp[j-coin[i]]   #만들려는 수에서 해당 동전수만큼을 뺀 인덱스의 dp를 기존 dp에 더한다

print(dp[K])

#숫자별 총 경우의 수로 규칙찾기 -> 실패
#경우의 수를 동전 별로 나눠서 구해놓고 규칙찾기 -> 성공
#dp를 동전별로 따로 다 선언하려고 했는데 어떻게 하는지 몰라서 실패
#dp 하나로 선언 -> 성공