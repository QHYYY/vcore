package cn.qatech.vcore;

import cn.qatech.vcore.common.CweInfo;
import cn.qatech.vcore.common.VclzInfo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VConfigurer {
    private ConcurrentHashMap<String, CweInfo> cweMap = new ConcurrentHashMap<String, CweInfo>();
    private List<VclzInfo> vclzList = new ArrayList<VclzInfo>();

    public synchronized void load() throws IOException {
        XSSFSheet sheet;
        XSSFRow row;

        cweMap.clear();
        XSSFWorkbook cweBook = new XSSFWorkbook(new FileInputStream(new File("cwe.xlsx")));
        sheet = cweBook.getSheetAt(0);
        for(int i = 0;;i++){
            row = sheet.getRow(i);
            String cweName, subType = null, cnDesc = null;
            if(row == null
                    || row.getCell(0) == null
                    || row.getCell(0).getStringCellValue() == null
                    || (cweName = row.getCell(0).getStringCellValue().trim()).length() == 0){
                break;
            }

            if(row.getCell(1) != null) subType = row.getCell(1).getStringCellValue();
            if(row.getCell(2) != null) cnDesc = row.getCell(2).getStringCellValue();

            if(cweMap.get(cweName) != null) throw new RuntimeException("Duplicate CWE Name:" + cweName);

            cweMap.put(cweName, new CweInfo(cweName, subType, cnDesc));
        }

        vclzList.clear();
        XSSFWorkbook vclzBook = new XSSFWorkbook(new FileInputStream(new File("vclz.xlsx")));
        sheet = vclzBook.getSheetAt(0);
        for(int i = 0;;i++){
            row = sheet.getRow(i);
            String vclzRegex, vclzCode = null, cnDesc = null;
            if(row == null
                    || row.getCell(0) == null
                    || row.getCell(0).getStringCellValue() == null
                    || (vclzRegex = row.getCell(0).getStringCellValue().trim()).length() == 0){
                break;
            }

            if(row.getCell(1) != null) vclzCode = row.getCell(1).getStringCellValue();
            if(row.getCell(2) != null) cnDesc = row.getCell(2).getStringCellValue();

            vclzList.add(new VclzInfo(vclzRegex, vclzCode, cnDesc));
        }
    }

    public ConcurrentHashMap<String, CweInfo> getCweMap() {
        return cweMap;
    }

    public void setCweMap(ConcurrentHashMap<String, CweInfo> cweMap) {
        this.cweMap = cweMap;
    }


    public List<VclzInfo> getVclzList() {
        return vclzList;
    }

    public void setVclzList(List<VclzInfo> vclzList) {
        this.vclzList = vclzList;
    }
}
