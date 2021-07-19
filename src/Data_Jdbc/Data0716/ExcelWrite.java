package Data_Jdbc.Data0716;
//
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Calendar;
//
//public class ExcelWrite {
//
//    public ExcelWrite(){
//
//    }
//
//    public void start(){
//    //1. workbook객체를 생성
//        HSSFWorkbook workbook = new HSSFWorkbook();
//
//    //2. sheet객체를 생성
//        HSSFSheet sheet1 =workbook.createSheet();
//        HSSFSheet sheet2 =workbook.createSheet("회원목록");
//    //3. row객체를 생성
//
//        HSSFRow row = sheet2.createRow(0);
//
//    //4. cell객체를 생성성
//        row.createCell(0).setCellValue("번호");
//        row.createCell(1).setCellValue("이름");
//        row.createCell(2).setCellValue("연락처");
//        row.createCell(3).setCellValue("나이");
//        row.createCell(4).setCellValue("등록일");
//
//        HSSFRow row1 =sheet2.createRow(1);
//        row1.createCell(0).setCellValue(100);
//        row1.createCell(1).setCellValue("홍길동");
//        row1.createCell(2).setCellValue("010-2740-7662");
//        row1.createCell(3).setCellValue(25);
//        row1.createCell(4).setCellValue(Calendar.getInstance());
//
//        HSSFRow row2 = sheet2.createRow(2);
//
//        row2.createCell(0).setCellValue(200);
//        row2.createCell(1).setCellValue("권길동");
//        row2.createCell(2).setCellValue("010-2740-1111");
//        row2.createCell(3).setCellValue(27);
//        row2.createCell(4).setCellValue(Calendar.getInstance());
//
//
//        HSSFRow row3 = sheet2.createRow(2);
//
//       row3.createCell(0).setCellValue(300);
//       row3.createCell(1).setCellValue("장길동");
//       row3.createCell(2).setCellValue("010-2111-1111");
//       row3.createCell(3).setCellValue(28);
//       row3.createCell(4).setCellValue(Calendar.getInstance());
//
//        File f =new File("D://testFile","member.xls");
//
//        try {
//            FileOutputStream fos = new FileOutputStream(f);
//            workbook.write(fos);
//            fos.close();
//            workbook.close();
//        }catch (Exception e)
//        {
//
//            e.printStackTrace();
//        }
//        //5. 파일로 쓰기
//   }
//
//    public static void main(String[] args) {
//new  ExcelWrite().start();
//    }
//
//}
