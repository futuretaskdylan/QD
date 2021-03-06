package com.haocang.waterlink.self.iview;

import android.content.Context;

import com.haocang.waterlink.home.bean.TaskEntity;

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
 * 创建时间：2018/5/14 15:08
 * 修 改 者：
 * 修改时间：
 */
public interface TaskBooardView {

    Context getContexts();

    /**
     * 任务类别（ 1：巡检；2：缺陷；3：维修；4：养护）
     *
     * @return
     */
    int getType();

    /**
     * 任务状态
     *
     * @return
     */
    int getStatus();

    /**
     * 页数
     *
     * @return
     */
    int getCurrentPage();

    void setTaskList(List<TaskEntity> taskList);
}
