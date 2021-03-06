package com.haocang.curve.more.iview;

import android.content.Context;

import com.haocang.curve.more.bean.PointEntity;

import java.util.List;

/**
 * Copyright(C) 2015-2020 Shang hai haocang-tech Co., Ltd. All Rights Reserved.
 * 版权所有(C)2015-2020
 * 公司名称：上海昊沧系统控制技术有限责任公司
 * 产品规格书 Version 0.01
 * Document ID: SEP002 内部使用 Page 14/ 49
 * 公司地址：中国上海市徐汇区龙兰路277号一号楼9楼
 * 网址：http://www.haocang.com/
 * 标 题：
 * 部 门：产品研发部
 * 版 本： 1.0
 * 创 建 者：hy
 * 创建时间：2018/5/31 14:24
 * 修 改 者：
 * 修改时间：
 */
public interface PointListView {

    String getQueryName();

    String getCurrentPage();

    String getPageSize();

    Context getContexts();

    String getSiteId();

    String getCategoryId();

    /**
     * 获取已选列表
     *
     * @return
     */
    List<PointEntity> getSelectList();

    /**
     * 设置数据
     *
     * @param list
     */
    void setPointList(List<PointEntity> list);
}
