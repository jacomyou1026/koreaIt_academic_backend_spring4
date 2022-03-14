import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellMain {
	public static void main(String[] args) throws IOException {
		
		
		ZipSecureFile.setMinInflateRatio(0);
		
		try {
			//엑셀 형태로 읽어오는부분
			FileInputStream fis = new FileInputStream("position.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//엑셀 시트 선택
			XSSFSheet sheet = workbook.getSheetAt(0);//엑셀 시트 순번으로 읽어옴
			//시트명으로도 읽어올 수 있음
			
			System.out.println("전체 행 개수 : "+sheet.getPhysicalNumberOfRows());//전체 행 개수 
			System.out.println("해당 라인의 컬럼수 : "+sheet.getRow(0).getPhysicalNumberOfCells()); //열개수
			System.out.println("4행 5열에 있는 셀값 : "+ sheet.getRow(3).getCell(4)); //0부터 시작
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				String row ="";
				for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
					row+= sheet.getRow(i).getCell(j)+"\t";
					
				}
				System.out.println(row);
				
			}
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
