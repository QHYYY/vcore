package cn.qatech.vcore;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/10/23　13:24
 * @ClassName:TestExcel
 */
public class TestExcel {
    public static void main(String[] args) {
        try {
            List<File> fileList = getAllFile("C:\\Users\\31429\\Desktop\\数据检索_1603360420158.xlsx");
            Map<String, Set<String>> results = new HashMap<String, Set<String>>();
            for (File file : fileList) {
                XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
                XSSFSheet sheet1 = workbook.getSheetAt(0);
                List<XSSFSheet> sheets = new ArrayList<XSSFSheet>();
                sheets.add(sheet1);

                for (XSSFSheet sheet : sheets) {
                    for (int i = 1; i < sheet.getLastRowNum(); i++) {
                        XSSFRow row = sheet.getRow(i);
                        if (row == null) {
                            continue;
                        }
                        XSSFCell cell1 = row.getCell(4);
                        XSSFCell cell3 = row.getCell(5);
                        if (cell1 == null || cell3 == null || cell1.getStringCellValue() == null || cell1.getStringCellValue().equals("unknown") || cell3.getStringCellValue().equals("unknown") || cell3.getStringCellValue() == null) {
                            continue;
                        }
                        String vendor = cell1.getStringCellValue();
                        String deviceName = cell3.getStringCellValue();
                        Set<String> devices = results.get(vendor);
                        if (devices == null) {
                            devices = new HashSet<String>();
                            devices.add(deviceName);
                            results.put(vendor, devices);
                        } else {
                            devices.add(deviceName);
                        }
                    }
                }
            }
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet0 = wb.createSheet("Sheet0");
            int i = 0;
            for (Map.Entry<String, Set<String>> entry : results.entrySet()) {
                if (entry.getKey().equals("") || entry.getValue() == null) {
                    continue;
                }
                for (String value : entry.getValue()) {
                    XSSFRow row = sheet0.createRow(i++);
                    row.createCell(0).setCellValue(entry.getKey());
                    row.createCell(1).setCellValue(value);
                }

            }
            FileOutputStream outputStream = new FileOutputStream("D:\\rules\\result2.xlsx");
            wb.write(outputStream);
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getAllFile(String directoryPath) {
        List<File> list = new ArrayList<File>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile()) {
            list.add(baseFile);
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            list.add(new File(file.getAbsolutePath()));
        }
        return list;
    }
}
