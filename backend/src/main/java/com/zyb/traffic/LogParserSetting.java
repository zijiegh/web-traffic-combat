package com.zyb.traffic;

import java.util.Set;

//支持解析的日志类型
public class LogParserSetting {
    public Set<String> getCmds() {
        return cmds;
    }

    public void setCmds(Set<String> cmds) {
        this.cmds = cmds;
    }

    private Set<String> cmds;


    public LogParserSetting(Set<String> cmds) {
        this.cmds = cmds;
    }
}
