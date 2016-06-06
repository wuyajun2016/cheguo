package com.kernel.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.log4j.Logger;

public class ExcelUtil {
	private static Logger logger = Logger.getLogger(ExcelUtil.class);

	/**
	 * 读取指定EXCEL中的内容
	 * @param excelname
	 * @param sheetname
	 * @param findContent
	 * @return
	 */
	public static Map<String, String> importDataTable(String excelname,
			String sheetname, String findContent) {
		String excelpath = System.getProperty("user.dir") + File.separator
				+ "resource" + File.separator + excelname;

		@SuppressWarnings("unchecked")
		Map<String, String> mapdata = new LinkedMap();
		mapdata = getSpecifySheet(excelpath, sheetname, findContent);

		logger.info("Imported data,the imported Map data is:" + mapdata);
		return mapdata;
	}

	/**
	 * 读取excel中数据的具体实现
	 * @param excelpath
	 * @param sheetname
	 * @param caseName
	 * @return
	 */
	public static Map<String, String> getSpecifySheet(String excelpath,
			String sheetname, String caseName) {

		List<String> header = null;
		Map<String, String> rowmap = new HashMap<String, String>();

		boolean findrow = false;
		int rownumber = 0;

		try {
			Workbook workbook = Workbook.getWorkbook(new File(excelpath));
			Sheet sheet = workbook.getSheet(sheetname);
			// the row index begin with 0
			int rows = sheet.getRows();
			// the column index begin with 0
			int columns = sheet.getColumns();
			header = new ArrayList<String>();
			for (int columnindex = 0; columnindex < columns; columnindex++) {
				String headerelement = sheet.getCell(columnindex, 0)
						.getContents().trim();
				header.add(columnindex, headerelement);
			}
			logger.debug("Current excel header is :" + header);
			for (int rowindex = 1; rowindex < rows; rowindex++) {
				String cellcontent = sheet.getCell(0, rowindex).getContents()
						.toLowerCase().trim();
				logger.info("found the first column content in excel is:"
						+ cellcontent);

				if (cellcontent.equalsIgnoreCase(caseName)) {
					logger.debug("Found the correct cell data,the content we found in excel is:"
							+ cellcontent);
					findrow = true;
					rownumber = rowindex;
					break;
				} else {
					findrow = false;
				}
			}

			if (findrow) {
				for (int columnindex = 0; columnindex < columns; columnindex++) {
					String findcontent = sheet.getCell(columnindex, rownumber)
							.getContents().trim();
					String mapheader = header.get(columnindex);
					rowmap.put(mapheader, findcontent);
				}
			}

			logger.debug("current Row data is :" + rowmap);

		} catch (BiffException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

		return rowmap;
	}
}
