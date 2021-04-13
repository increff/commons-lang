package com.nextscm.commons.lang;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileFormatUtilTest {

    private File baseDir = null;

    @Before
    public void init() {
        baseDir = new File(System.getProperty("user.dir"));
        baseDir = new File(baseDir, "/src/test/java/com/nextscm/commons/lang/resources");
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