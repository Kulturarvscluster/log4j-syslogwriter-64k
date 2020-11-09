# log4j-64k-syslogwriter
Writes log4j events to Syslog of size max up to 64K

Sample config
```ini
log4j.appender.SYSLOG=com.github.loggly.log4j.SyslogAppender64k
log4j.appender.SYSLOG.Facility=LOCAL7
log4j.appender.SYSLOG.FacilityPrinting=false
log4j.appender.SYSLOG.Header=true
log4j.appender.SYSLOG.Rfc5424Format=true
log4j.appender.SYSLOG.SyslogHost={{syslog_server}}:{{syslog_server_port}}
log4j.appender.SYSLOG.layout=org.apache.log4j.PatternLayout
log4j.appender.SYSLOG.layout.ConversionPattern=%-5p [%t:%C{1}@%L] - %m%n
# https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
```

These properties control the format of the output
```ini
log4j.appender.SYSLOG.FacilityPrinting=false
log4j.appender.SYSLOG.Header=true
log4j.appender.SYSLOG.Rfc5424Format=true
```
If `log4j.appender.SYSLOG.Rfc5424Format=false`, the messages will be output as rfc3164

When using Rfc5424Format, the header fields will be used as

* HOSTNAME: local hostname
* APP-NAME: Main class, determined as 
    ```java
   ManagementFactory.getRuntimeMXBean()
                       .getSystemProperties()
                       .get("sun.java.command")
                       .split(" ", 2)
                       [0]);
    ```
* PROCID: The process PID
* MSGID: The timestamp in milliseconds