package com.zyb.traffic;

import com.zyb.traffic.parser.data.builder.AbstractDataObjectBuilder;
import com.zyb.traffic.parser.data.object.InvalidLogObject;
import com.zyb.traffic.parser.data.object.ParsedDataObejct;

import java.util.ArrayList;
import java.util.List;

public class LogParser {
    private LogParserSetting logParserSetting;
    private List<AbstractDataObjectBuilder> builders;

    public LogParser(LogParserSetting logParserSetting, List<AbstractDataObjectBuilder> builders) {
        this.logParserSetting = logParserSetting;
        this.builders = builders;
    }

    /**
     * 日志解析接口方法
     * @param logPreparser
     * @return
     */
    public List<? extends ParsedDataObejct> parse(LogPreparser logPreparser){
        String cmd=logPreparser.getCommand();
        ArrayList<ParsedDataObejct> list=new ArrayList<ParsedDataObejct>();

        if(!this.logParserSetting.getCmds().contains(cmd)){
            list.add(new InvalidLogObject("not supported cmd"));
            return list;

        }else if(this.logParserSetting.getCmds().contains(cmd)){
            for(AbstractDataObjectBuilder builder: this.builders){
                if(builder.getCommand().equals(cmd)){
                    return builder.doBuildDataObjects(logPreparser);
                }
            }
        }else{
            list.add(new InvalidLogObject("not find cmd unexpectedly"));
            return list;
        }

        return list;
    }
}
