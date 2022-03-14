import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CityListMain {
	public static void main(String[] args) {
		
		ZipSecureFile.setMinInflateRatio(0);
		
		XSSFWorkbook workbook;
		try {
			FileInputStream fis= new FileInputStream("position.xlsx");
			workbook = new XSSFWorkbook(fis);
			

			XSSFSheet sheet = workbook.getSheetAt(0);
			HashSet<String> hs = new HashSet();
			
			
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				String row ="";
					hs.add(sheet.getRow(i).getCell(2).toString());
					}
			
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
