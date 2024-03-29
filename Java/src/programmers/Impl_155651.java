package programmers;

class Impl_155651 {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] times = new int[1450];
        for (int i = 0; i < book_time.length; i++){
            int start = toInt(book_time[i][0]);
            int end = toInt(book_time[i][1]);
            for (int j = start; j < end + 10; j++){
                times[j] ++;
            }
        }
        for (int i = 0; i < times.length; i++){
            answer = Math.max(answer, times[i]);
        }
        return answer;
    }

    int toInt(String time){
        int result = 0;
        String[] st = time.split(":");
        result += Integer.parseInt(st[0]) * 60;
        result += Integer.parseInt(st[1]);
        return result;
    }
}
