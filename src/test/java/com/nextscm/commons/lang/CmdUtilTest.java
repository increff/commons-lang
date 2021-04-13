/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

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
