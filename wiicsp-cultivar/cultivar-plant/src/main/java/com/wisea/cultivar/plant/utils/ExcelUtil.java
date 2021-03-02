package com.wisea.cultivar.plant.utils;

import com.wisea.cloud.common.util.ConverterUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wangh
 *
 */
public class ExcelUtil {
	Workbook wb =null;
	Sheet sheet =null;
	CellStyle style = null;
	/**
	 * 当前行号
	 */
	private int rownum;
	/**
	 * 样式列表
	 */
	public Map<String, CellStyle> styles;

	public ExcelUtil(){
		  wb = new XSSFWorkbook();
		  sheet = wb.createSheet("new sheet");
		  style = wb.createCellStyle(); // 样式对象
		  style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
		  style.setAlignment(CellStyle.ALIGN_CENTER);// 水平

		  //style.setBottomBorderColor(HSSFCellStyle.BORDER_DOTTED);
		  style.setWrapText(true);

		  styles = createStyles(wb);

	}

	/**
	 * 创建表格样式
	 * @param wb 工作薄对象
	 * @return 样式列表
	 */
	private Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		Font titleFont = wb.createFont();
		titleFont.setFontName("Arial");
		titleFont.setFontHeightInPoints((short) 16);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(titleFont);
		styles.put("title", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		Font dataFont = wb.createFont();
		dataFont.setFontName("Arial");
		dataFont.setFontHeightInPoints((short) 10);
		style.setFont(dataFont);
		styles.put("data", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_LEFT);
		styles.put("data1", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		styles.put("data2", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		styles.put("data3", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
//			style.setWrapText(true);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font headerFont = wb.createFont();
		headerFont.setFontName("Arial");
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(headerFont);
		styles.put("header", style);

		return styles;
	}

	/**
	 * 保存生成的文件
	 * @param name
	 */
	public void saveAaSpecName(String name){
		OutputStream out;
		try {
			out = new FileOutputStream(name);
			wb.write(out);

			System.out.println(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(HttpServletResponse response, String fileName) throws IOException{
		response.reset();
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"iso-8859-1"));
		wb.write(response.getOutputStream());
	}

	public Row addRow(){
		return sheet.createRow(rownum++);
	}

	public  void addRow(int count){
		for(int i = 0; i<count; i++)
		 sheet.createRow((short) i);
	}

	public Row getRow(int rownum){
		return sheet.getRow(rownum);
	}


	/**
	 * 合并cell并设置值
	 * @param startRow
	 * @param startCell
	 * @param endRow
	 * @param endCell
	 * @param cellMove
	 * @param content
	 */
	public  void mergeCell(int startRow,int endRow,int startCell,int endCell,int cellMove,String content){
		sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, startCell, endCell));
		Row row = sheet.getRow(startRow);
		Cell cell= row.createCell(cellMove);
		cell.setCellValue(content);
		cell.setCellStyle(style);
	}

	/**
	 * 合并cell并设置值
	 * @param startRow
	 * @param startCell
	 * @param endRow
	 * @param endCell
	 * @param cellMove
	 * @param content
	 */
	public  void mergeCell(int startRow,int endRow,int startCell,int endCell,int cellMove,String content,String styleKey){
		CellRangeAddress cellRangeAddress = new CellRangeAddress(startRow, endRow, startCell, endCell);
		sheet.addMergedRegion(cellRangeAddress);
		Row row = sheet.getRow(startRow);
		Cell cell= row.createCell(cellMove);
		cell.setCellValue(content);
		cell.setCellStyle(styles.get(styleKey) == null ? style : styles.get(styleKey));
		setRegionBorder(CellStyle.BORDER_NONE, IndexedColors.GREY_50_PERCENT.getIndex(), cellRangeAddress);
	}


	/**
	 * 设置合并单元格后的边框样式
	 * @param border 边框样式
	 * @param color  边框颜色
	 * @param region  合并单元格对象
	 */
	public void setRegionBorder(short border, short color, CellRangeAddress region){

		RegionUtil.setBorderBottom(border,region, sheet, wb);
		RegionUtil.setBorderTop(border,region, sheet, wb);
		RegionUtil.setBorderLeft(border,region, sheet, wb);
		RegionUtil.setBorderRight(border,region, sheet, wb);

		RegionUtil.setTopBorderColor(color, region, sheet, wb);
		RegionUtil.setBottomBorderColor(color, region, sheet, wb);
		RegionUtil.setLeftBorderColor(color, region, sheet, wb);
		RegionUtil.setRightBorderColor(color, region, sheet, wb);
	}

	/**
	 * 生成Excel头信息
	 * @param titleName 头内容
	 * @param rowMerge 列
	 */
	public void getTitleTemp(String titleName, List<String> rowMerge){
		int rowMergeSize = rowMerge == null ? 0 : rowMerge.size();
		// 生成一个样式
		CellStyle style = styles.get("title");
		Row row1 = addRow();
		//合并单元格
		CellRangeAddress titleCell = new CellRangeAddress(0, 0, 0, rowMergeSize - 1);
		sheet.addMergedRegion(titleCell);
		Cell row1_Cell = row1.createCell(0);

		row1_Cell.setCellStyle(style);
		row1_Cell.setCellValue(titleName);
	}

	/**
	 * 生成Excel头信息
	 * @param titleName 头内容
	 * @param rowMerge 列
	 */
	public void getTitleTemp(String titleName, Integer rowMerge){
		// 生成一个样式
		CellStyle style = styles.get("title");
		Row row1 = addRow();
		//合并单元格
		CellRangeAddress titleCell = new CellRangeAddress(0, 0, 0, rowMerge - 1);
		sheet.addMergedRegion(titleCell);
		Cell row1_Cell = row1.createCell(0);

		row1_Cell.setCellStyle(style);
		row1_Cell.setCellValue(titleName);
	}

	/**
	 * 生成表格Title
	 * @param rowMerge 表头列
	 */
	public void getTableTitle(List<String> rowMerge){
		int rowMergeSize = rowMerge == null ? 0 : rowMerge.size();
		// 生成一个样式
		CellStyle style = styles.get("title");
		Row row = addRow();
		style = styles.get("header");
		for (int i = 0; i < rowMergeSize; i++) {
			CellRangeAddress cra = new CellRangeAddress(row.getRowNum(), row.getRowNum(), i, i);
			sheet.addMergedRegion(cra);
			Cell row2_Cell = row.createCell(i);
			row2_Cell.setCellStyle(style);
			row2_Cell.setCellValue(rowMerge.get(i));
			//设置合并后的单元格边框
			CellRangeAddress cellRangeAddress = new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, rowMerge.size() - 1);
			setRegionBorder(CellStyle.BORDER_THIN, IndexedColors.GREY_50_PERCENT.getIndex(), cellRangeAddress);
		}
	}

	/**
	 * 生成Excel头信息
	 * @param titleName  sheet名称和第一行相同
	 * @param rowMerge  合并行
	 * @param columnMerge  和并列
	 * @param splitColumn  和并列下面的拆分列
	 * @return
	 */
	public void getInitTemp(String titleName, List<String> rowMerge, List<String> columnMerge, List<String> splitColumn){
		int rowMergeSize = rowMerge == null ? 0 : rowMerge.size();
		int columnMergeSize = columnMerge == null ? 0 : columnMerge.size();
		int splitColumnSize = splitColumn == null ? 0 : splitColumn.size();

		// 生成一个样式
		CellStyle style = styles.get("title");
		// 设置这些样式
		//style.setAlignment(HorizontalAlignment.CENTER);//水平居中
		//style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中


		Row row1 = addRow();
		Row row2 = addRow();
		Row row3 = addRow();
		//合并单元格
		CellRangeAddress titleCell = new CellRangeAddress(0, 0, 0, rowMergeSize+(columnMergeSize*splitColumnSize-1));
		sheet.addMergedRegion(titleCell);
		Cell row1_Cell = row1.createCell(0);
		//Font font = wb.createFont();
		//font.setBold(true);
		//font.setFontHeightInPoints((short) 16);
		//style.setFont(font);

		row1_Cell.setCellStyle(style);
		row1_Cell.setCellValue(titleName);
		//设置合并后的单元格边框
		//setRegionBorder(BorderStyle.THIN.getCode(), HSSFColor.GREY_25_PERCENT.index, titleCell, sheet);

		//背景色
		//style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		//font.setColor(HSSFColor.WHITE.index);
		//font.setBold(true);
		//font.setFontHeightInPoints((short) 10);
		//style.setFont(font);
		style = styles.get("header");
		for (int i = 0; i < rowMergeSize; i++) {
			CellRangeAddress cra = new CellRangeAddress(1, 2, i, i);
			sheet.addMergedRegion(cra);
			Cell row2_Cell = row2.createCell(i);
			row2_Cell.setCellStyle(style);
			row2_Cell.setCellValue(rowMerge.get(i));
			//设置合并后的单元格边框
			//setRegionBorder(BorderStyle.THIN.getCode(), HSSFColor.GREY_25_PERCENT.index, cra, sheet);
		}

		for (int i = 0; i < columnMergeSize; i++) {
			int began = rowMergeSize+i*splitColumnSize;
			int end = rowMergeSize+i*splitColumnSize+splitColumnSize-1;
			CellRangeAddress cra = new CellRangeAddress(1, 1, began, end);
			sheet.addMergedRegion(cra);
			Cell row3_Cell = row2.createCell(began);
			row3_Cell.setCellValue(columnMerge.get(i));
			row3_Cell.setCellStyle(style);

			//设置合并后的单元格边框
			//setRegionBorder(BorderStyle.THIN.getCode(), HSSFColor.GREY_25_PERCENT.index, cra, sheet);

			for (int j = 0; j < splitColumnSize; j++) {
				Cell cell = row3.createCell(began+j);
				cell.setCellStyle(style);
				cell.setCellValue(splitColumn.get(j));
			}
		}
	}

	public void setCellValue(Row row, Integer cellIndex, String cellValue, String cellStyleKey){
		Cell cell = row.createCell(cellIndex);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(cellValue);
		row.getCell(cellIndex).setCellStyle(styles.get(cellStyleKey));
	}

	public void setCellValue(Row row, Integer cellIndex, double cellValue, String cellStyleKey){
		row.createCell(cellIndex).setCellValue(cellValue);
		row.getCell(cellIndex).setCellStyle(styles.get(cellStyleKey));
	}

	/**
	 * 设置必须填写的项目的背景色为红色
	 *
	 * @param row
	 * @param str
	 */
	public void setCellBackColor(Row row, String[] str){
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		for(int i = 0;i < str.length; i++){
			row.getCell(ConverterUtil.toInteger(str[i])).setCellStyle(style);
		}
	}

	public Workbook getWb(){
		return wb;
	}
}
