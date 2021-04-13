package com.nextscm.commons.lang;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileUtilTest {

    private File baseDir = null;

    @Before
    public void init() {
        baseDir = new File(System.getProperty("user.dir"));
        baseDir = new File(baseDir, "/src/test/java/com/nextscm/commons/lang/resources");
    }

    @Test
    public void testGetTempDir() throws IOException {
        File file = FileUtil.getTempDir("directory");
        assertTrue(file.exists());
        assertTrue(file.isDirectory());
        assertEquals("directory", file.getName());
        assertEquals(0, file.listFiles().length, 0);
        assertTrue(file.delete());
    }

    @Test
    public void testCreateTempFile() throws IOException {
        File file = FileUtil.createTempFile(baseDir, "testFileCreate.txt");
        // In-Memory files return false for file.exits()
        assertFalse(file.exists());
        assertEquals("testFileCreate.txt", file.getName());
    }

    @Test
    public void testDeleteFileWithExistingFile() throws IOException {
        File testFile = new File(baseDir+"/toDelete.txt");
        testFile.createNewFile();
        assertTrue(testFile.exists());
        FileUtil.deleteFile(baseDir+"/toDelete.txt");
        assertFalse(testFile.exists());
    }

    @Test
    public void testDeleteFileWithNonExistingFile() {
        // Must quietly delete non existent files
        FileUtil.deleteFile(baseDir+"NonExistentFile");
    }

    @Test
    public void testCreateTempFileWithExt() throws IOException {
        File file = FileUtil.createTempFileWithExt(baseDir, ".csv");
        // In-Memory files return false for file.exits()
        assertFalse(file.exists());
        assertTrue(file.getName().endsWith(".csv"));
    }

    @Test
    public void testCloseQuietly() throws IOException {
        File file = new File(baseDir+"/tsv1.tsv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileUtil.closeQuietly(br);
    }

}
