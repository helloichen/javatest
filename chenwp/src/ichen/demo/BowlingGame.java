package ichen.demo;


import java.util.Scanner;

public class BowlingGame {
    public static final int TOTAL_ROUND = 10;   //总局数

    private int[] scores;                       //每局得分的数组；
    private int[][] numberOfHits;               //每局两球击倒的瓶子数组
    private int lastOneHit, lastTwoHit;         //最后两次击球
    private int totalScore;                     //总分数
    private int currentRound;                   //当前第几局
    private boolean isFirstHit;                 //是否第一次击球

    public BowlingGame() {
        scores = new int[TOTAL_ROUND];
        numberOfHits = new int[TOTAL_ROUND][2];
        isFirstHit = true;
    }

    /**
     * 扔出第一颗球
     */
    public void throwTheBall(int num) {
        if (isFirstHit) {
            numberOfHits[currentRound][0] = num;
            if (num != 10) {
                isFirstHit = false;//第一球不是全中就需要打第二球
            } else {
                currentRound++;//第一球全中直接进入下一局
            }
        } else {
            numberOfHits[currentRound][1] = num;
            currentRound++;//准备进入下一局
            isFirstHit = true;
        }
    }

    public void recordScore() {
        //第一局到第九局
        for (int i = 0; i < numberOfHits.length - 1; i++) {
            if (numberOfHits[i][0] == 10) {//strike
                scores[i] += 10;
                if (numberOfHits[i + 1][0] == 10) {
                    scores[i] += 10;
                    if (i < 8) {
                        scores[i] += numberOfHits[i + 2][0];
                    } else {
                        scores[i] += lastOneHit;
                    }
                } else {
                    scores[i] += numberOfHits[i + 1][0] + numberOfHits[i + 1][1];
                }
            } else if (numberOfHits[i][0] + numberOfHits[i][1] == 10) {//spare
                scores[i] += 10;
                scores[i] += numberOfHits[i + 1][0];
            } else {
                scores[i] += numberOfHits[i][0] + numberOfHits[i][1];
            }
        }
        //last round
        if (numberOfHits[9][0] == 10) {
            scores[9] += 10;
            scores[9] += lastOneHit + lastTwoHit;
        } else if (numberOfHits[9][0] + numberOfHits[9][1] == 10) {
            scores[9] += 10;
            scores[9] += lastOneHit;
        } else {
            scores[9] += numberOfHits[9][0] + numberOfHits[9][1];
        }
    }

    //设置最后第一球球击倒瓶子数
    public void setLastOneHit(int lastOneHit) {
        this.lastOneHit = lastOneHit;
    }

    //设置最后第二球球击倒瓶子数
    public void setLastTwoHit(int lastTwoHit) {
        this.lastTwoHit = lastTwoHit;
    }

    //计算总分
    public int getTotalScore() {
        for (int i : scores) {
            totalScore += i;
        }
        return totalScore;
    }
}

class TestBowling {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        char[] chars = str.toCharArray();
        int score = 0;
        int round = 1;
        int index = 0;
        while (round <= 10) {
            if (chars[index] == 'x') {
                score += bowlingScore(chars[index]);
                score += bowlingScore(chars[index + 1]);
                score += bowlingScore(chars[index + 2]);
                index++;
                round++;
            } else if (isDigit(chars[index])) {
                score += bowlingScore(chars[index]);
                if (isDigit(chars[index + 1])) {
                    score += bowlingScore(chars[++index]);
                    round++;
                }
                index++;
            } else if (chars[index] == '/') {
                score = score - bowlingScore(chars[index - 1]) + 10;
                score += bowlingScore(chars[++index]);
                round++;
            } else if (chars[index] == '-') {
                score += bowlingScore(chars[index]);
                score += bowlingScore(chars[++index]);
                round++;
            } else {
                System.out.println("输入有误");
                return;
            }

        }
        System.out.println(score);
    }

    private static boolean isDigit(char aChar) {
        return aChar > '0' && aChar <= '9';
    }

    public static int bowlingScore(char c) {
        if (c == 'x') return 10;
        if (c == '-') return 0;
        if (isDigit(c)) return c - '0';
        return 0;
    }
}
