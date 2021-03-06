package com.github.loggly.log4j.helpers;

import java.io.IOException;
import java.io.Writer;

import org.junit.Ignore;
import org.junit.Test;

public class SyslogUdpWriter64kTest {
	@Test
	@Ignore
	public void createWriterWithPort() throws IOException {
		Writer writer = new SyslogUdpWriter64k("rlog001.yak2.net:6514");
		writer.write("abc");
		writer.close();
	}
	
	@Test
	@Ignore
	public void createWriterWithoutPort() throws IOException {
		Writer writer = new SyslogUdpWriter64k("localhost");
		writer.write("abc");
		writer.close();
	}
}
