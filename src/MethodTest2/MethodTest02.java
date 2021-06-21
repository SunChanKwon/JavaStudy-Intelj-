package MethodTest2;

public class MethodTest02 {
    boolean power = true;//true 일때 켜짐 false 꺼짐
    final int CHANNEL_MIN=1;
    final int CHANNEL_MAX=20;
    int channelNow=12;
    public MethodTest02(){}

    //power 버튼을 누른 경우
    //반환형 메소드명(매개변수, 매개변수,....){
    //  //실행문; //기능구현
    // }

    void powerStart() {
        power = !power;
        if (power) {
            power = false;
        } else {
            power = true;
        }
        System.out.println("Power=" + power);
    }
        String gugudan(int dan)
        {
            String result ="";
            for(int i=1; i<10; i++)
            {
                result+= dan + "*" +i+"="+dan*i+"\n";
            }
            return result;
        }
        //채널 번호 올리기 한개
        //채널 내리기
    void channelUp(){
        if(channelNow==CHANNEL_MAX)
        {
            channelNow=CHANNEL_MIN;
        }
        else{
            channelNow++;
        }
        channelPrint(); //현재클래스의 다른 메소드 호출
    }
    void channelDonw(){
        if(channelNow==CHANNEL_MIN)
        {
            channelNow=CHANNEL_MAX;
        }
        else{
            channelNow--;
        }
        channelPrint(); //현재클래스의 다른 메소드 호출
    }
    void channelPrint()
    {
        System.out.println("채널번호:"+channelNow);
    }
    static void sum(int max)
    {
        int total=0;
        for(int i=0; i<=max; i++)
        {
            total+=i;
        }
        System.out.println("1~"+max+"의 합은 "+total);
    }
}

