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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Converts a TSV (Tab Separated Value) File into a CSV File. Ignores first Row
 */
public class FileFormatUtil {

	/**
	 * Converts a TSV file into a CSV file
	 * @param tsvFile TSV file to be converted into CSV
	 * @param csvFile File on which to save the converted CSV
	 */
	public static void tsvToCsv(File tsvFile, File csvFile) throws IOException {

		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			br = new BufferedReader(new FileReader(tsvFile));
			pw = new PrintWriter(new FileWriter(csvFile));
			// ignore the warning : using password on command line
			br.readLine();
			String tsvRow;
			while ((tsvRow = br.readLine()) != null) {
				String csvRow = replace(tsvRow);
				pw.println(csvRow);
			}
		} finally {
			FileUtil.closeQuietly(br);
			FileUtil.closeQuietly(pw);
		}

	}

	/**
	 * Convert a line of TSV text into corresponding CSV text
	 * @param line TSV text line
	 * @return CSV text line
	 */
	public static String replace(String line) {
		String[] columns = line.split("\\t");
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].contains(",")) {
				columns[i] = "\"" + columns[i] + "\"";
			}
		}
		return String.join(",", columns);
	}

}
