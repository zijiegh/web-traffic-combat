package com.zyb.traffic.parser.data.builder;

import com.zyb.traffic.LogPreparser;
import com.zyb.traffic.parser.data.object.BaseDataObject;
import com.zyb.traffic.parser.data.object.HeartbeatDataObject;
import com.zyb.traffic.parser.data.utils.ColumnReader;
import com.zyb.traffic.parser.data.utils.ParserUtils;

import java.util.ArrayList;
import java.util.List;

public class HeartbeatDataObjectBuilder extends AbstractDataObjectBuilder {

    @Override
    public String getCommand() {
        return "hb";
    }

    @Override
    public List<BaseDataObject> doBuildDataObjects(LogPreparser preParsedLog) {
        List<BaseDataObject> dataObjects = new ArrayList<>();
        HeartbeatDataObject dataObject = new HeartbeatDataObject();
        ColumnReader columnReader = new ColumnReader(preParsedLog.getQueryString());
        fillCommonBaseDataObjectValue(dataObject, preParsedLog, columnReader);

        int loadingDuration = 0;
        String plt = columnReader.getStringValue("plt");
        if (!ParserUtils.isNullOrEmptyOrDash(plt)) {
            loadingDuration = Math.round(Float.parseFloat(plt));
        }
        dataObject.setLoadingDuration(loadingDuration);

        int clientPageDuration = 0;
        String psd = columnReader.getStringValue("psd");
        if (!ParserUtils.isNullOrEmptyOrDash(psd)) {
            clientPageDuration = Math.round(Float.parseFloat(psd));
        }
        dataObject.setClientPageDuration(clientPageDuration);

        dataObjects.add(dataObject);
        return dataObjects;
    }
}
