package com.haocang.waterlink.login.iview;

import com.haocang.base.bean.UserEntity;
import com.haocang.offline.bean.user.OffLineUserEntity;

import java.util.List;

/**
 * Copyright(C) 2015-2020 Shang hai haocang-tech Co., Ltd. All Rights Reserved.
 * 版权所有(C)2015-2020
 * 公司名称：上海昊沧系统控制技术有限责任公司
 * 产品规格书 Version 0.01
 * Document ID: SEP002 内部使用 Page 14/ 49
 * 公司地址：中国上海市徐汇区云锦路 500 号绿地汇中心 A 座 20 楼 2001
 * 网址：http://www.haocang.com/
 * 标 题：
 * 部 门：产品研发部
 * 版 本： 1.0
 * 创 建 者：hy
 * 创建时间：${DATA} 10:53
 * 修 改 者：
 * 修改时间：
 */
public interface AccountSwitchView {

    void setRecyclerCount(int count);//设置recyclerview每行现实的个数

    void setUserList(List<OffLineUserEntity> list);


}
