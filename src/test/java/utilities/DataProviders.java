package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		
		String path = "C:/Users/supritha sunil/eclipse-workspace/CartApp/testData/userCred.xlsx";
		
		ExcelUtility excelUtility = new ExcelUtility(path);
		
		int totalrows = excelUtility.getRowCount("Sheet1");
		int totalcells = excelUtility.getCellCount("Sheet1", 1);
		String loginData[][] = new String[totalrows][totalcells];
		for(int i=1;i<= totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				loginData[i-1][j]= excelUtility.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
		
	}
	
}
