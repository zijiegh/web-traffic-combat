package com.zyb.traffic.parser.data.configuration.loader;

import com.zyb.traffic.parser.data.configuration.SearchEngineConfig;

import java.util.List;

/**
 *  搜索引擎配置的加载接口
 */
public interface SearchEngineConfigLoader {
    /**
     * 获取所有的搜索引擎配置信息
     * @return
     */
    public List<SearchEngineConfig> getSearchEngineConfigs();
}
