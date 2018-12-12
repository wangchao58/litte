package com.litte.service.tree;

import com.litte.entity.jurisdiction.TMenu;

import java.util.Map;

public interface TreeService {

    String selectByExample(Map<String, Object> map);

    String selectByLisAll(TMenu menu);
}
