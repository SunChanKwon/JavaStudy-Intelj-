package Data0622MapCollection;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

    public PropertiesTest(){
        Properties prop = new Properties();

        prop.setProperty("네이버","http://www.naver.com");
        prop.setProperty("다음","http://www.daum.net");
        prop.setProperty("네이트","http://www.nate.com");
        prop.setProperty("구글","http://www.google.com");
        //getPoroperty():키를 이용하여 객체 얻어오기;
        
        System.out.print(prop.getProperty("다음"));

        Enumeration e = prop.propertyNames(); //object으로 사용된다 객체가 키 목록이 들어가져 있다.

        while(e.hasMoreElements()) { // 객체가 남아 있을 경우 true, 없으면 false
            String str = (String)e.nextElement();  // 상위인 object가 하위인 object로 넣지 못하기떄문에 형변환을 통해서 값을 넣어야 한다.
            System.out.println("Key="+str+", value"+ prop.getProperty(str));
        }
    }
    public static void main(String[] args) {
        new PropertiesTest();
    }
}
