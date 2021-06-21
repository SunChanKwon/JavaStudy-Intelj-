package StaticTest;

import java.util.Scanner;

public class w1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // if, if~else, if~else if, switch~ case

        // 데이터 콘솔입력
        System.out.println("나이 = ");
        int age = scan.nextInt();
        System.out.println("성별 (1:남자, 2:여자) ");
        int sex = scan.nextInt();
        System.out.println("키 = ");
        int height = scan.nextInt();
        System.out.println("체중 = ");
        int weight = scan.nextInt();

        // 상수와 변수 정의
        double avgWeight = 0; // 표준체중
        double avgWeight_Kpi = 0; // 표준체중 지수
        String message = ""; // 표준체중 지수 평가

        // 표준체중 구하기
        if (age < 36) {
            if (sex == 1) {
                avgWeight = (height - 100) * 0.90;
            } else {
                avgWeight = (height - 100) * 0.85;
            }
            if (age >= 36) {
                if (sex == 1) {
                    avgWeight = (height - 100) * 0.95;
                } else {
                    avgWeight = (height - 100) * 0.90;
                }
            }

            // 표준체중지수 구하기
            avgWeight_Kpi = (weight / avgWeight) * 100;

            // 표준체중 지수 평가기준 결정
            if (avgWeight_Kpi < 85) {
                message = "마른형";
            } else if (avgWeight_Kpi <= 86 && avgWeight_Kpi <= 95) {
                message = "조금마른형";
            } else if (avgWeight_Kpi <= 96 && avgWeight_Kpi <= 115) {
                message = "표준형";
            } else if (avgWeight_Kpi <= 116 && avgWeight_Kpi <= 125) {
                message = "조금비만형";
            } else {
                message = "비만형";
            }

            System.out.printf("나이=%d\n 성별(1:남성, 2:여성)=%d\n 키=%d/\n", age, sex, height);
            System.out.printf("현재체중=%d\n 표준체중=%f\n", weight, avgWeight);
            System.out.printf("당신의 표준체중지수는 %3f으로.", avgWeight_Kpi);

        }
    }
}