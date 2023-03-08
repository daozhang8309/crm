package com.powernode.crm.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 使用apache-poi生成Excel文件
 */
public class CreateExcelTest {
    public static void main(String[] args) throws IOException {
        //创建HSSFWorkbook对象，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //使用wb创建HSSFSheet对象，对应Excel文件中的一页
        HSSFSheet sheet = wb.createSheet("学生列表");
        //使用sheet对象创建HSSFRow对象，对应一页中的一行
        HSSFRow row = sheet.createRow(0);
        //使用row创建HSSFCell对象，对应一行中一列
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell = row.createCell(2);
        cell.setCellValue("年龄");

        for (int i = 1; i <= 10 ; i++) {
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue("学号"+i);
            cell = row.createCell(1);
            cell.setCellValue("姓名"+i);
            cell = row.createCell(2);
            cell.setCellValue("年龄"+i);
        }

        //调用工具函数生成Excel文件
        FileOutputStream os = new FileOutputStream("D:\\work\\studentList.xls");
        wb.write(os);

        os.close();
        wb.close();

        System.out.println("_________________________________________________");
    }
}
