package cn.qatech.vcore.common;

import java.util.regex.Pattern;

public class VclzInfo {
    private String regex = null;
    private String vclzCode = null;
    private String cnDesc = null;

    public VclzInfo(String regex, String vclzCode, String cnDesc){
        this.regex = regex;
        this.vclzCode = vclzCode;
        this.cnDesc = cnDesc;
    }

    public boolean isMatch(String content){
        return Pattern.matches(regex, content);
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getVclzCode() {
        return vclzCode;
    }

    public void setVclzCode(String vclzCode) {
        this.vclzCode = vclzCode;
    }

    public String getCnDesc() {
        return cnDesc;
    }

    public void setCnDesc(String cnDesc) {
        this.cnDesc = cnDesc;
    }
}
