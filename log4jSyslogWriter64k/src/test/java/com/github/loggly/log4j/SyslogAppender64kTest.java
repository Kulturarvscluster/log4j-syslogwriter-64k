package com.github.loggly.log4j;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogSF;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class SyslogAppender64kTest {
    
    @Test
    void append() {
        SyslogAppender64k appender = new SyslogAppender64k();
        
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%-5p [%t:%C{1}@%L] - %m%n");
        appender.setLayout(layout);
        
        appender.setSyslogHost("rlog001.yak2.net:6514");
        
        appender.setFacilityPrinting(false);
        appender.setHeader(true);
        appender.setRfc5424Format(true);
        
        appender.append(new LoggingEvent(SyslogAppender64kTest.class.getName(), Logger.getRootLogger(), Level.INFO,"message",null));
    }
}