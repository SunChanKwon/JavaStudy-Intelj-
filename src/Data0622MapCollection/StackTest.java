package Data0622MapCollection;

import java.util.Stack;

public class StackTest {
    public StackTest(){
        Stack<String> stack = new Stack(); //문자열을 담는다.
        // 문자열을 담는 Collection을 담는다.

        //Stack은 먼저 입력된 정보가 나중에 출력된다.(FILO: First in Last Out)
        //queue은 (FIFO) 먼저 들어가건이 먼저 나오는거;
        //PUSH() : 입력, POP() : 출력
        
        stack.push("홍길동");
        stack.push("세종대왕");
        stack.push("이순신");
        stack.push("김정희");

        //empty() : stack객체 있으면 fasle, 객체가 있을 때 true
        while (!stack.empty())//객체가 있을때
        {
            String name = stack.pop();
            System.out.println(name);
        }

    }

    public static void main(String[] args) {
        new StackTest();
    }
}
