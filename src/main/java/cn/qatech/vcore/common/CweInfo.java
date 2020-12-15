package cn.qatech.vcore.common;

public class CweInfo {
    private String name = null;
    private String subType = null;
    private String cnDesc = null;

    public CweInfo(String name, String subType, String cnDesc){
        this.name = name;
        this.subType = subType;
        this.cnDesc = cnDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCnDesc() {
        return cnDesc;
    }

    public void setCnDesc(String cnDesc) {
        this.cnDesc = cnDesc;
    }
}
