package com.nextscm.commons.lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CmdUtilTest {

    @Test
    public void testRunCmd() throws IOException, InterruptedException {
        CmdUtil.runCmd(new String[]{"java", "-version"}, ProcessBuilder.Redirect.INHERIT, ProcessBuilder.Redirect.INHERIT);
        assertTrue(true);
    }

    @Test
    public void testRunCmdWithInvalidCommand() throws IOException, InterruptedException {
        try{
            CmdUtil.runCmd(new String[]{"java", "-invalidCommandExample"}, ProcessBuilder.Redirect.INHERIT, ProcessBuilder.Redirect.INHERIT);
            fail("Should throw Exception for invalid commands");
        } catch (IOException exception){
            assertTrue(true);
        }
    }

}
