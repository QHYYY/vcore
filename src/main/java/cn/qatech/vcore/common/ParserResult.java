package cn.qatech.vcore.common;

public class ParserResult {
    private String vulClass;
    private String vulSubtype;

    public ParserResult(String vulClass, String vulSubtype) {
        this.vulClass = vulClass;
        this.vulSubtype = vulSubtype;
    }

    @Override
    public String toString() {
        return "ParseResult{" +
                "vulClass='" + vulClass + '\'' +
                ", vulSubtype='" + vulSubtype + '\'' +
                '}';
    }

    public String getVulClass() {
        return vulClass;
    }

    public void setVulClass(String vulClass) {
        this.vulClass = vulClass;
    }

    public String getVulSubtype() {
        return vulSubtype;
    }

    public void setVulSubtype(String vulSubtype) {
        this.vulSubtype = vulSubtype;
    }

}
