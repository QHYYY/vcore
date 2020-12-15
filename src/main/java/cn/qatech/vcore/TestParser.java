package cn.qatech.vcore;

import cn.qatech.vcore.common.ParserResult;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestParser {
    public static void main(String[] args) {
        try {
            VParser parser = new VParser();
            XSSFSheet sheet = new XSSFWorkbook(new FileInputStream(new File("camera.xlsx"))).getSheetAt(0);

            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet0 = wb.createSheet("Sheet0");
            HSSFRow head = sheet0.createRow(0);
            createHeadRow(head);

            int cveIdx = 10, cweIdx = 12, cnDescIdx = 13, cnSummaryIdx = 17, cnnvdIdx = 7, cnvdIdx = 8, nameChsIdx = 17;
            for (int i = 1; ; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null || row.getCell(cveIdx) == null || row.getCell(cveIdx).getStringCellValue() == null || row.getCell(cveIdx).getStringCellValue().trim().length() == 0)
                    break;
                String content = row.getCell(cnDescIdx).getStringCellValue() + " | " + row.getCell(cnSummaryIdx).getStringCellValue();

                String cweName = row.getCell(cweIdx).getStringCellValue();
                String cve = row.getCell(cveIdx).getStringCellValue();
                String cnnvd = row.getCell(cnnvdIdx).getStringCellValue();
                String cnvd = null;
                if (row.getCell(cnvdIdx) != null) {
                     cnvd = row.getCell(cnvdIdx).getStringCellValue();
                }
                String nameChs = row.getCell(nameChsIdx).getStringCellValue();
                String desChs = row.getCell(nameChsIdx).getStringCellValue();

                ParserResult pr = parser.parser(content, cweName);
                if (pr.getVulClass() == null
                        || pr.getVulSubtype() == null
                ) {
//                    System.out.println(content);
//                    System.out.println("CWE: " + cweName);
//                    System.out.println(pr);
//
//                    System.out.println("Processed:"+ i);
//                    System.exit(-1);
                    System.out.println("Press Enter to continue ....");
//                    System.in.read();
                } else {
                    System.out.println(pr);
                    HSSFRow row1 = sheet0.createRow(i);
                    row1.createCell(0).setCellValue(cve);
                    row1.createCell(1).setCellValue(cnnvd);
                    row1.createCell(2).setCellValue(cnvd);
                    row1.createCell(3).setCellValue(nameChs);
                    row1.createCell(4).setCellValue(desChs);
                    row1.createCell(5).setCellValue(pr.getVulClass());
                    row1.createCell(6).setCellValue(pr.getVulSubtype());
                    row1.createCell(7).setCellValue(cweName);
                }
            }
            FileOutputStream outputStream = new FileOutputStream("D:\\rules\\111.xls");
            wb.write(outputStream);
//            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createHeadRow(HSSFRow head) {
        head.createCell(0).setCellValue("cve");
        head.createCell(1).setCellValue("cnnvd");
        head.createCell(2).setCellValue("cnvd");
        head.createCell(3).setCellValue("nameChs");
        head.createCell(4).setCellValue("descriptionChs");
        head.createCell(5).setCellValue("vul_class");
        head.createCell(6).setCellValue("vul_subtype");
        head.createCell(7).setCellValue("cwe");
    }
}
