package com.zyb.traffic.parser.data.builder;

import com.zyb.iplocation.IpLocationParser;
import com.zyb.traffic.LogPreparser;
import com.zyb.traffic.parser.data.object.BaseDataObject;
import com.zyb.traffic.parser.data.utils.ColumnReader;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.List;

public abstract class AbstractDataObjectBuilder {

    public abstract String getCommand();

    public abstract List<BaseDataObject> doBuildDataObjects(LogPreparser logPreparser);

    public void fillCommonBaseDataObjectValue(BaseDataObject baseDataObject,
                                              LogPreparser logPreparser, ColumnReader columnReader) {
        baseDataObject.setProfileId(logPreparser.getProfileId());
        baseDataObject.setServerTimeString(logPreparser.getServTime().toString());

        baseDataObject.setUserId(columnReader.getStringValue("gsuid"));
        baseDataObject.setTrackerVersion(columnReader.getStringValue("gsver"));
        baseDataObject.setPvId(columnReader.getStringValue("pvid"));
        baseDataObject.setCommand(columnReader.getStringValue("gscmd"));

        //结合ip位置信息
        baseDataObject.setClientIp(logPreparser.getClientIp().toString());
        baseDataObject.setIpLocation(IpLocationParser.parse(logPreparser.getClientIp().toString()));
        //解析UserAgent信息
        baseDataObject.setUserAgent(logPreparser.getUserAgent().toString());
        baseDataObject.setUserAgentInfo(UserAgent.parseUserAgentString(logPreparser.getUserAgent().toString()));

    }

}
