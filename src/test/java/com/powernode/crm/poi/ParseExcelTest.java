package com.powernode.crm.poi;


import com.powernode.crm.commons.utils.CELLUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseExcelTest {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("D:\\work\\activityList.xls");
        HSSFWorkbook wb = new HSSFWorkbook(is);
        HSSFSheet sheet = wb.getSheetAt(0);//第一页
        HSSFRow row = null;
        HSSFCell cell = null;
        for (int i = 0; i <=sheet.getLastRowNum() ; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j <row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                System.out.printf(CELLUtils.getCellValueForStr(cell)+" ");
            }
            System.out.println();
        }
    }

    //获取cell的值

}
