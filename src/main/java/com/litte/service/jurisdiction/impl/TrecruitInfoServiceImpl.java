package com.litte.service.jurisdiction.impl;

import com.litte.entity.jurisdiction.TRecruitInfo;
import com.litte.mapper.jurisdiction.TRecruitInfoMapper;
import com.litte.service.jurisdiction.TrecruitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrecruitInfoServiceImpl implements TrecruitInfoService {
    @Autowired
    TRecruitInfoMapper tRecruitInfoMapper;

    /**
     * @Description: 查询招聘联系人相关信息
     * @Param: 
     * @return: 
     * @Author: Mr.Jiang
     * @Date: 2018/12/13 9:53
     *
     */
    public TRecruitInfo selTrecruitInfo() {
        // 数据主键ID(数据只有一条，再此查询数据主键写死)
        String id = "44d179fbb11b447aa3b4c0451010bd99";
        TRecruitInfo tRecruitInfo = tRecruitInfoMapper.selectByPrimaryKey(id);
        return tRecruitInfo;
    }

    /**
     * @Description: 修改招聘联系人相关信息
     * @Param: 
     * @return: 
     * @Author: Mr.Jiang
     * @Date: 2018/12/13 10:48
     */
    @Override
    public int updTrecruitInfo(TRecruitInfo tRecruitInfo) {
        int i = tRecruitInfoMapper.updateByPrimaryKey(tRecruitInfo);
        return i;
    }
}
