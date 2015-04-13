package code;


/**
 * @author WUJIAJUN  
 */

import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;  
import java.util.List;  
   







import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsMain {
	
	
	public static void main(String[] args) throws IOException, SQLException {  
        XlsMain xlsMain = new XlsMain();  
        //����
      List<XlsDto> listfj = xlsMain.readXls("1111111.xlsx",6,7);  
      List<XlsDto> list2 = xlsMain.readXls("222222.xlsx",6,7);  
     
      System.out.println(listfj.size());
      
      
      for (XlsDto xlsDto : listfj) {
    	 
    	  System.out.println( xlsDto.getXkh());
    	  System.out.println( xlsDto.getXh());
      }
      

      System.out.println(list2.size());
      
      
     
      
      
      
      
        
        
    }  
	
	
	
	
	private static  void  doUpdate(List<XlsDto>  list) throws SQLException{
		

        for (XlsDto xlsDto : list) {
        	
        	String olddoc = (String) xlsDto.getXkh();
        	String newdoc =xlsDto.getXh();
        	

         	
         	
         	if(!olddoc.equals(newdoc)){
            	System.out.println(olddoc);
             	System.out.println(newdoc);
         		
         		JDBCSQL.forupdate_ZIXUN_CloseQue(olddoc, newdoc);
             	JDBCSQL.forupdate_ZiXun_ConsumerOrders(olddoc, newdoc);
             	JDBCSQL.forupdate_ZiXun_DoctorFreeCount(olddoc, newdoc);
             	JDBCSQL.forupdate_ZiXun_QuesMain(olddoc, newdoc);
             	JDBCSQL.forupdate_ZiXun_Reply(olddoc, newdoc);
             	
         	}
         	
         	
         	System.out.println("===========next===============");	
		}
        
        
        
        
        System.out.println("+++++ȫ������+++++");
		
	}
	
	
	
   
    /**  
     * ��ȡxls�ļ�����  
     *  
     * @return List<XlsDto>����  
     * @throws IOException  
     *             ����/���(i/o)�쳣  
     */ 
    private List<XlsDto> readXls(String xlsname, int olddoc, int   newdoc ) throws IOException {  
        InputStream is = new FileInputStream(xlsname);  
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);  
        XlsDto xlsDto = null;  
        List<XlsDto> list = new ArrayList<XlsDto>();  
        // ѭ��������Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
        	XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {  
                continue;  
            }  
            // ѭ����Row  
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	XSSFRow hssfRow = hssfSheet.getRow(rowNum);  
                if (hssfRow == null) {  
                    continue;  
                }  
                xlsDto = new XlsDto();  
                // ѭ����Cell  
   
                // for (int cellNum = 0; cellNum <=4; cellNum++) {  
                //
                XSSFCell xkh = hssfRow.getCell(olddoc);  
                if (xkh == null||xkh.getNumericCellValue()==0) {  
                    continue;  
                } 
                
                
                DecimalFormat format = new DecimalFormat("#");
                
                String sMoney = format.format(xkh.getNumericCellValue());
              
                xlsDto.setXkh(String.valueOf(sMoney));  
                
                
                //
                XSSFCell xh = hssfRow.getCell(newdoc);  
                if (xh == null||xh.getNumericCellValue()==0) {  
                    continue;  
                }  
                String fMoney = format.format(xh.getNumericCellValue());
                xlsDto.setXh(String.valueOf(fMoney));  
                

                

                
                
                list.add(xlsDto);  
            }  
        }  
        return list;  
    }  
   
    /**  
     * �õ�Excel���е�ֵ  
     *  
     * @param hssfCell  
     *            Excel�е�ÿһ������  
     * @return Excel��ÿһ�������е�ֵ  
     */ 
    @SuppressWarnings("static-access")  
    private String getValue(XSSFCell hssfCell) {  
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {  
            // ���ز������͵�ֵ  
            return String.valueOf(hssfCell.getBooleanCellValue());  
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {  
            // ������ֵ���͵�ֵ  
            return String.valueOf(hssfCell.getNumericCellValue());  
        } else {  
            // �����ַ������͵�ֵ  
            return String.valueOf(hssfCell.getStringCellValue());  
        }  
    }  

}
