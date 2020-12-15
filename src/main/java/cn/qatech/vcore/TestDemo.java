package cn.qatech.vcore;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/10/23　16:55
 * @ClassName:TestDemo
 */
public class TestDemo {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("D:\\rules\\result2.xlsx"));
        XSSFSheet sheet = workbook.getSheetAt(0);
        Map<String, Set<String>> result = new HashMap<String, Set<String>>();
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null || row.getCell(0) == null || row.getCell(1) == null) continue;
            String vendor = row.getCell(0).getStringCellValue();
            String device = row.getCell(1).getStringCellValue();

            Set<String> deviceList = result.get(vendor);
            if (deviceList == null) {
                deviceList = new HashSet<String>();
                deviceList.add(device);
                result.put(vendor, deviceList);
            } else {
                deviceList.add(device);
            }
        }

        XSSFWorkbook export = new XSSFWorkbook();
        XSSFSheet sheet1 = export.createSheet("sheet1");
        XSSFRow row1 = sheet1.createRow(0);
        row1.createCell(0).setCellValue("設備");
        row1.createCell(1).setCellValue("廠商");
        int i = 1;
        for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
            for (String value : entry.getValue()) {
                XSSFRow row = sheet1.createRow(i++);
                row.createCell(0).setCellValue(value);
                row.createCell(1).setCellValue(entry.getKey());
            }
        }
        FileOutputStream outputStream = new FileOutputStream("D:\\rules\\qhy.xlsx");
        export.write(outputStream);
        export.close();
    }
}
