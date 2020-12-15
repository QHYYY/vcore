package cn.qatech.vcore;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/11/16　10:47
 * @ClassName:TestNtp
 */
public class TestNtp {
    public static void main(String[] args) {
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            timeClient.setDefaultTimeout(2000);
            String timeServerUrl = "129.6.15.29";//服务器ip
            InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);
            TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            Date date = timeStamp.getDate();
            Date systemDate = new Date();
            System.out.println(date);
            System.out.println(systemDate);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateFormat.format(date));
            System.out.println(dateFormat.format(systemDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

