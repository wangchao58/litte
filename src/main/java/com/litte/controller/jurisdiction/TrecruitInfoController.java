package com.litte.controller.jurisdiction;

import com.litte.entity.jurisdiction.TRecruitInfo;
import com.litte.service.jurisdiction.TrecruitInfoService;
import com.litte.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trecruitInfo")
public class TrecruitInfoController extends BaseController {
    @Autowired
    TrecruitInfoService trecruitInfoService;

    /**
     * @Description: 进入招聘信息管理页面
     * @Param: 
     * @return: 
     * @Author: Mr.Jiang
     * @Date: 2018/12/13 10:49
     */
    @RequestMapping(value = "/toTrecruitInfo")
    public String toTrecruitInfo(Model model) {
         TRecruitInfo tRecruitInfo = trecruitInfoService.selTrecruitInfo();
        model.addAttribute("tRecruitInfo", tRecruitInfo);
        return "html/authority/trecruitInfo/trecruitInfoupd";
    }

    /**
     * @Description: 修改招聘联系人相关信息
     * @Param: 
     * @return: 
     * @Author: Mr.Jiang
     * @Date: 2018/12/13 10:48
     */
    @RequestMapping(value = "/updTrecruitInfo")
    @ResponseBody
    public int updTrecruitInfo(TRecruitInfo tRecruitInfo) {
        int i = trecruitInfoService.updTrecruitInfo(tRecruitInfo);
        return i;
    }
}
