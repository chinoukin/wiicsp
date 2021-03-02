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
 * @ClassName: 检查导入数据字段类型是否正确
 * @Author: tgz
 * @Date: 2020/8/12 15:52
 */
public class CheckExcelField {

    private static final Logger logger = LoggerFactory.getLogger(CheckExcelField.class);

    public static List<String> test(Object object) {
        Class<?> c1 = object.getClass();
        List<String> annotationList = new ArrayList<>();
        System.out.println(c1.getName());
        try {
            Class clazz = Class.forName(c1.getName());
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

    public static Boolean checkExcelFields(Object object, ImportExcel importExcel) {
        Row row = importExcel.getRow(1);
        List<String> stringList = test(object);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            if (!(cell.getStringCellValue().equals(stringList.get(i)))){
                return false;
            }
        }
        return true;
    }
}
