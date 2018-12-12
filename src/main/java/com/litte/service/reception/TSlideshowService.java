package com.litte.service.reception;

import com.litte.entity.reception.TSlideshow;

import java.util.List;

public interface TSlideshowService {

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TSlideshow record);

    List<TSlideshow> selectByExample(TSlideshow record);

    List<TSlideshow> selectByExampleByTime();

    TSlideshow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSlideshow record);

}
