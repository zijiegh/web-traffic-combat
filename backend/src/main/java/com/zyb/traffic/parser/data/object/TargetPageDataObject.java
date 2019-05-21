package com.zyb.traffic.parser.data.object;

import com.zyb.traffic.parser.data.object.dim.TargetPageInfo;

import java.util.List;

/**
 * 目标页面实体
 */
public class TargetPageDataObject extends BaseDataObject {

    private List<TargetPageInfo> targetPageInfos;
    private PvDataObject pvDataObject;

    public List<TargetPageInfo> getTargetPageInfos() {
        return targetPageInfos;
    }

    public void setTargetPageInfos(List<TargetPageInfo> targetPageInfos) {
        this.targetPageInfos = targetPageInfos;
    }

    public PvDataObject getPvDataObject() {
        return pvDataObject;
    }

    public void setPvDataObject(PvDataObject pvDataObject) {
        this.pvDataObject = pvDataObject;
    }
}
