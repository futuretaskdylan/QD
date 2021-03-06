package com.haocang.base.bean;

import java.util.Map;

/**
 * Copyright(C) 2015-2020 Shang hai haocang-tech Co., Ltd. All Rights Reserved.
 * 版权所有(C)2015-2020
 * 公司名称：上海昊沧系统控制技术有限责任公司
 * 公司地址：中国上海市徐汇区云锦路500号绿地汇中心A座20楼2001
 * 网址：http://www.haocang.com/
 * 标        题：
 * 部        门：产品研发部
 * 版        本： 1.0
 * 创  建  者：whhc
 * 创建时间：2018/4/12下午1:24
 * 修  改  者：
 * 修改时间：
 */
public class MapEvent {
    /**
     *
     */
    private Map<String, Object> map;

    /**
     *
     * @param map
     */
    public MapEvent(final Map<String, Object> map) {
        this.map = map;
    }
}
