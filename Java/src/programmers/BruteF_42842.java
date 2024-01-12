package programmers;

class BruteF_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 1 ; i <= Math.sqrt(total); i++){
            if (total % i == 0){
                int x = i;
                int y = total / i;
                if ((x + y) == ((brown + 4) / 2) && ((x-2) * (y-2)) == yellow){
                    answer[0] = y;
                    answer[1] = x;
                    break;
                }
            }
        }
        return answer;
    }
}
