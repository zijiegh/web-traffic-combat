package com.zyb.traffic.parser.data.builder;



import com.zyb.traffic.LogPreparser;
import com.zyb.traffic.parser.data.object.BaseDataObject;
import com.zyb.traffic.parser.data.object.EventDataObject;
import com.zyb.traffic.parser.data.utils.ColumnReader;
import com.zyb.traffic.parser.data.utils.ParserUtils;
import com.zyb.traffic.parser.data.utils.UrlParseUtils;

import java.util.ArrayList;
import java.util.List;

public class EventDataObjectBuilder extends AbstractDataObjectBuilder {

    @Override
    public String getCommand() {
        return "ev";
    }

    @Override
    public List<BaseDataObject> doBuildDataObjects(LogPreparser logPreparser) {
        List<BaseDataObject> baseDataObjects = new ArrayList<>();
        EventDataObject eventDataObject = new EventDataObject();
        ColumnReader columnReader = new ColumnReader(logPreparser.getQueryString());
        fillCommonBaseDataObjectValue(eventDataObject, logPreparser, columnReader);

        eventDataObject.setEventCategory(columnReader.getStringValue("eca"));
        eventDataObject.setEventAction(columnReader.getStringValue("eac"));
        eventDataObject.setEventLabel(columnReader.getStringValue("ela"));
        String eva = columnReader.getStringValue("eva");
        if (!ParserUtils.isNullOrEmptyOrDash(eva)) {
            eventDataObject.setEventValue(Float.parseFloat(eva));
        }
        eventDataObject.setUrl(columnReader.getStringValue("gsurl"));
        eventDataObject.setOriginalUrl(columnReader.getStringValue("gsourl"));
        eventDataObject.setTitle(columnReader.getStringValue("gstl"));
        eventDataObject.setHostDomain(UrlParseUtils.getInfoFromUrl(eventDataObject.getUrl()).getDomain());

        baseDataObjects.add(eventDataObject);
        return baseDataObjects;
    }
}
