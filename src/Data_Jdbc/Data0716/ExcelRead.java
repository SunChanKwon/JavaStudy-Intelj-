package Data_Jdbc.Data0716;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data0705.FileInputStreamTest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



public class ExcelRead {

    public ExcelRead(){

    }
    public void start() {
        try {
            File file = new File("D://testFile","member.xls");

            FileInputStream fis = new FileInputStream(file);

            //byteCode인 InputStream 엑셀 파일로 변환하는 클래스
            POIFSFileSystem poi = new POIFSFileSystem(fis);

            //1.workbook객체 얻어오기
            HSSFWorkbook workbook = new HSSFWorkbook(poi);

            //시트의 수구하기
            int sheetCnt = workbook.getNumberOfSheets();
            System.out.println("시트수 = "+sheetCnt);

            HSSFSheet sheet = workbook.getSheet("회원목록");

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("행의수 ="+rowCount);

            //System.out.println("번호\t이름\t연락쳐\t나이\t등록일");

            for(int rowIdx=1; rowIdx<rowCount; rowIdx++)
            {
                HSSFRow row = sheet.getRow(rowIdx);

                int cellCount = row.getPhysicalNumberOfCells();
                System.out.println("셀의 수 = "+cellCount);

                for(int cellIdx = 0; cellIdx<cellCount; cellIdx++)
                {
                    HSSFCell cell = row.getCell(cellIdx);

                    if(cellIdx==0 || cellIdx==3)
                    {

                        int data = (int) cell.getNumericCellValue();
                        System.out.print(data+"\t");
                    }else if(cellIdx==1 || cellIdx==2)
                    {

                        String data = cell.getStringCellValue();
                        System.out.print(data+"\t");
                    }
                    else if(cellIdx==4){
                    Date date =cell.getDateCellValue();
                        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
                        String dateStr = format.format(date);
                        System.out.println(dateStr);
                    }
                }

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ExcelRead().start();
    }
}
