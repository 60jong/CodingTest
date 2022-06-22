import java.util.Arrays;

public class First {
    public int[] solution(int[] lottos, int[] win_nums) {

        int[] lotto = {44, 1, 0, 0, 31, 25};
        int[] win = {31, 10, 45, 1, 6, 19};
        int[] answer = new int[2];

        int cntZero = 0;
        cntZero = (int) Arrays.stream(lotto).filter(i -> i==0).count();

        int cntMatch = 0;
        for (int i = 0; i < lotto.length; i++) {
            if(lotto[i] > 0)
                for (int j = 0; j < win.length; j++) {
                    if(lotto[i] == win[j])
                        cntMatch++;
                }
        }
        answer[0] = grade(cntMatch + cntZero);
        answer[1] = grade(cntMatch);
        
        return  answer;
    }

    public static int grade(int cntMatch) {
        if(cntMatch >= 6)
            return 1;
        if(cntMatch >= 5)
            return 2;
        if(cntMatch >= 4)
            return 3;
        if(cntMatch >= 3)
            return 4;
        if(cntMatch >= 2)
            return 5;
        return 6;
    }
}
