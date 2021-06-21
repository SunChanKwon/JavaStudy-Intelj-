package Data0617;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DecimalDataFormat {

    public DecimalDataFormat(String s){

     try {   //데이터를 원하는 출력형식으로 만들수 있는 클래스
         //숫자를 원하는 형식으로 출력
         int data = 5211233;
         DecimalFormat format = new DecimalFormat("#,###원");

         String Format = format.format(data);

         System.out.println("dataFormat" + Format);

         NumberFormat nf = NumberFormat.getInstance();
         Number num = nf.parse(Format);

         int dataParse = num.intValue();
         System.out.println("dataParse"+ dataParse);

         //날짜 포멧
         //2021년 6월 4일 (금) 15:21
         Calendar now = Calendar.getInstance();
         SimpleDateFormat SdataFormat = new SimpleDateFormat("yyyy년 MM월 DD일 (E) hh:mm:ss a");
         String dataStr = SdataFormat.format(now.getTime());
         System.out.println("dateStr--->"+dataStr);

     }catch (Exception e) {}
    }

    public static void main(String[] args)
    {
        new DecimalDataFormat("#,###원");
    }
}
