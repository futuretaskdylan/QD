package com.haocang.waterlink.home.iview;

import android.content.Context;

import com.haocang.waterlink.home.bean.HomeDataEntity;

import java.util.List;

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
 * 创建时间：2018/8/3上午9:08
 * 修  改  者：
 * 修改时间：
 */
public interface HomeDataView {
    Context getContext();

    String getIds();

    void renderData(final List<HomeDataEntity> list);

    void setTopic(String topic);
}
