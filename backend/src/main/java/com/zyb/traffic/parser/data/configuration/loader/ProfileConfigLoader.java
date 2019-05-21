package com.zyb.traffic.parser.data.configuration.loader;

import com.zyb.traffic.metastore.model.TargetPage;

import java.util.List;
import java.util.Map;

/**
 *  和profile相关配置的加载的接口
 */
public interface ProfileConfigLoader {
    /**
     * 获取所有的目标页面的配置
     * @return
     */
    public Map<Integer, List<TargetPage>> getTargetPages();
}
