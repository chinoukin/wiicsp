package com.wisea.cultivar.explorer.utils;

import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * explain:
 * </p>
 *
 * @author wangjunming
 * @since 2020/7/24 14:12
 */
public final class CheckUtils {
    private static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);

    /**
     * 效验文件大小
     *
     * @param len  文件大小
     * @param size 效验的大小
     * @param unit 单位
     * @return boolean
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        switch (unit.toUpperCase()) {
            case "B":
                fileSize = (double) len;
                break;
            case "K":
                fileSize = (double) len / 1024;
                break;
            case "M":
                fileSize = (double) len / 1048576;
                break;
            case "G":
                fileSize = (double) len / 1073741824;
                break;
        }
        return  fileSize > size;
    }

    /**
     * 验证文件格式
     *
     * @param fileName 文件名
     * @param fileStyle 文件格式
     * @return boolean
     */
    public static boolean checkFileName(String fileName, String fileStyle) {
        final String fileFormat = fileName.substring(fileName.lastIndexOf("."));
        switch (fileStyle) {
            case "excel":
                return !(".xls".equals(fileFormat.toLowerCase()) || ".xlsx".equals(fileFormat.toLowerCase()));
            case "pdf":
                return !".pdf".equals(fileFormat.toLowerCase());
            default:return false;
        }
    }

    public static List<String> test(Class<?> clazz) {
        List<String> annotationList = new ArrayList<>();
        try {
            // 返回所有的属性
            Field[] field02 = clazz.getDeclaredFields();
            for (Field field : field02) {
                ExcelField annotation = field.getAnnotation(ExcelField.class);
                //有该类型的注解存在
                if (null != annotation) {
                    annotationList.add(annotation.title());
                }
            }
        } catch (Exception e) {
            logger.error("获取字段标题失败！",e);
        }
        return annotationList;
    }

    public static Boolean checkExcelFields(Class<?> clazz, ImportExcel importExcel) {
        Row row = importExcel.getRow(1);
        List<String> stringList = test(clazz);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            if (!(cell.getStringCellValue().equals(stringList.get(i)))){
                return false;
            }
        }
        return true;
    }

    public static Double getJdWdSplit(String jdWd, int index) {
        String[] jdWdSplit = new String[]{"0","0"};
        try {
            if (jdWd.contains(",")) {
                jdWdSplit = jdWd.split(",");
            }
        } catch (Exception e) {
            try {
                jdWdSplit = jdWd.split("，");
            } catch (Exception ignored) {
            }
        }
        return Double.valueOf(jdWdSplit[index]);
    }

}
