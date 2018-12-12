package com.litte.mapper.reception;

import com.litte.entity.reception.TSlideshow;
import com.litte.entity.reception.TSlideshowExample;
import java.util.List;

public interface TSlideshowMapper {
    int insert(TSlideshow record);

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TSlideshow record);

    List<TSlideshow> selectByExample(TSlideshow record);

    List<TSlideshow> selectByExampleByTime();

    TSlideshow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSlideshow record);

    int updateByPrimaryKey(TSlideshow record);
}