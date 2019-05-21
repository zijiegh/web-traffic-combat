package com.zyb.traffic.metastore.api;

import com.zyb.traffic.metastore.model.TargetPage;

import java.util.List;

/**
 *  和profile相关的配置信息的管理接口
 */
public interface ProfileConfigManager {
    /**
     * 加载所有的目标页面配置
     * @return
     */
    public List<TargetPage> loadAllTargetPagesConfig();

}
