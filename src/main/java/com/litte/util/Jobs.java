package com.litte.util;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.litte.entity.jurisdiction.TDept;
import com.litte.entity.reception.TIndent;
import com.litte.service.jurisdiction.TDeptService;
import com.litte.service.reception.TIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Jobs {

    @Autowired
    TIndentService tIndentService;

    @Autowired
    TDeptService tDeptService;
    //表示方法执行完成后5秒
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException, ClientException {
        TIndent record = tIndentService.selectJob();

        if(record != null) {
            String id = record.getDeptId();
            TDept dept = tDeptService.selectBySmsKey(id);
            String TemplateCode = "SMS_152507676";
            String TemplateParam = "{\"name\":\""+dept.getDeptName()+"\"}";
            SendSmsResponse response = SmsXsk.sendSms(record.getiPhone(),TemplateParam,TemplateCode);
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + response.getCode());
            System.out.println("Message=" + response.getMessage());
            System.out.println("RequestId=" + response.getRequestId());
            System.out.println("BizId=" + response.getBizId());
            record.setIsSms("1");
            tIndentService.updateByPrimaryKeyJob(record);
        }

       // System.out.println(record);
        //System.out.println("fixedDelay 每隔5秒"+new Date());
    }

    //表示每隔3秒
    @Scheduled(fixedRate=3000)
    public void fixedRateJob(){
        TIndent record = tIndentService.selectCancelIndent();
        if(record != null) {
            record.setiCondition("7");
            tIndentService.updateByPrimaryKeyJob(record);
        }
    }

    /*//表示每天8时30分0秒执行
    @Scheduled(cron="0 0,30 0,8 ? * ? ")
    public void cronJob(){ System.out.println(new Date()+" ...>>cron...."); }*/
}
