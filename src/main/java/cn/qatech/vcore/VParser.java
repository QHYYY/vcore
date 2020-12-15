package cn.qatech.vcore;

import cn.qatech.vcore.common.CweInfo;
import cn.qatech.vcore.common.ParserResult;
import cn.qatech.vcore.common.VclzInfo;

import java.io.IOException;

public class VParser {
    private VConfigurer conf;

    public VParser() throws IOException {
        conf = new VConfigurer();
        conf.load();
    }

    public ParserResult parser(String content, String cweName){
        String vendor = null, vclzCode = null, subType = null;

        if(content != null) content = content.replace('\r', ' ').replace('\n', ' ');
        if(cweName != null) cweName = cweName.replace('\r', ' ').replace('\n', ' ').trim();

        CweInfo ci = conf.getCweMap().get(cweName);
        if(ci != null) subType = ci.getSubType();

        for(VclzInfo vci: conf.getVclzList()){
            if(vci.isMatch(content)){
                if(vclzCode == null) vclzCode = vci.getVclzCode();
                else if(!vclzCode.contains(vci.getVclzCode())) vclzCode =vclzCode + "|" + vci.getVclzCode();
            }
        }

        return new ParserResult(vclzCode, subType);
    }
}
