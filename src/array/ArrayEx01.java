package com.array;

import java.util.Scanner;

public class ArrayEx01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] ScoreData = {"국어","영어","수학","과학","물리","한국사","도덕"};

        int score[] = new int[7];  /// 모든 점수가 0으로 초기화됨
        System.out.print("점수 입력해주세요!!!");
        for(int index=0; index<ScoreData.length; index++)
        {
            score[index]=scan.nextInt();
            System.out.print(ScoreData[index]+"=");
        }
        //총점
        int tot=0;
        for(int i=0; i<score.length; i++)
        {
            tot = tot + score[i];
        }
        int average =tot/7;

        for(int index=0; index<ScoreData.length; index++)
        {
            System.out.println(score[index]);
        }
        System.out.println("총점:"+tot);
        System.out.println("평균:"+average);
    }
}
