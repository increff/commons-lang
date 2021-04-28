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

package com.increff.commons.lang;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileFormatUtilTest {

    private File baseDir = null;

    @Before
    public void init() {
        baseDir = new File(System.getProperty("user.dir"));
        baseDir = new File(baseDir, "/src/test/java/com/increff/commons/lang/resources");
    }

    @Test
    public void testTsvToCsv() throws IOException {
        File tsvFile = new File(baseDir, "tsv1.tsv");
        File csvFile = new File(baseDir, "csv1.csv");
        FileFormatUtil.tsvToCsv(tsvFile, csvFile);
        assertArrayEquals(Files.readAllBytes(Paths.get(baseDir + "/expectedCsv1.csv")),
                Files.readAllBytes(Paths.get(baseDir + "/csv1.csv")));
    }

    @Test
    public void testTsvToCsvWithCommasInTsvRows() throws IOException {
        File tsvFile = new File(baseDir, "tsvWithCommasInRows.tsv");
        File csvFile = new File(baseDir, "csv2.csv");
        FileFormatUtil.tsvToCsv(tsvFile, csvFile);
        assertArrayEquals(Files.readAllBytes(Paths.get(baseDir + "/expectedCsv2.csv")),
                Files.readAllBytes(Paths.get(baseDir + "/csv2.csv")));
    }

}