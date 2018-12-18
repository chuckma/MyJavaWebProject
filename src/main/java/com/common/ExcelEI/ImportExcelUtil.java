package com.common.ExcelEI;

/**
 * @author Administrator
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;

import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;


public class ImportExcelUtil {
    private static Logger log = Logger.getLogger(ImportExcelUtil.class);

    private final static String excel2003L = ".xls"; // 2003- 版本的excel
    private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel
    private final static String ERROR_TYPE = "50001"; // 错误格式

    /**
     * 将流中的Excel数据转成List<Map>
     *
     * @param in       输入流
     * @param fileName 文件名（判断Excel版本）
     * @param mapping  字段名称映射
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> parseExcel(InputStream in, String fileName,
                                                       Map<String, String> mapping) throws Exception {
        // 根据文件名来创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        // 返回数据
        List<Map<String, Object>> res = new ArrayList<>();

        // 遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            // 取第一行标题
            row = sheet.getRow(0);
            String title[] = null;
            if (row != null) {
                title = new String[row.getLastCellNum()];

                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    title[y] = (String) getCellValue(cell);
                }

            } else {
                continue;
            }
            log.info(JSON.toJSONString(title));

            // 遍历当前sheet中的所有行
            for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                row = sheet.getRow(j);
                if (isRowEmpty(row)) {
                    continue;
                }
                Map<String, Object> m = new HashMap<String, Object>();
                // 遍历所有的列
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    String key = title[y];

                    // 如果是数字类型并且日期格式不是 yyyy/mm/dd 类型 则出错
                    if (key.equals("monitor_date") && !cell.getCellStyle().getDataFormatString().equals("m/d/yy")) {
                        //return new ArrayList<>();
                    }

                    if (StringUtils.isNotBlank(key)) {
                        m.put(mapping.get(key), getCellValue(cell));
                    }
                }
                res.add(m);
            }

        }
        work.close();
        return res;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr ,fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr); // 2003-
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr); // 2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    public static Object getCellValue(Cell cell) {
//        if (cell.getCellTypeEnum().equals(NUMERIC)){
//            System.out.println(cell.getCellStyle().getDataFormatString());
//        }
        Object value = null;
        DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
        DecimalFormat df2 = new DecimalFormat("0"); // 格式化数字

        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }


    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellTypeEnum() != BLANK) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/Administrator/Desktop/sj/2017年全国跨境电商监测数据（FOR ACCESS）.xls");
        FileInputStream fis = new FileInputStream(file);
        Map<String, String> m = new HashMap<String, String>();
        m.put("org_name", "org_name");
        m.put("monitor_date", "monitor_date");
        m.put("procduct_name", "procduct_name");
        m.put("product_comm_name", "product_comm_name");

//        m.put("检测区域", "org_name");
//        m.put("检测日期", "monitor_date");
//        m.put("产品名称", "procduct_name");
//        m.put("通用名称", "product_comm_name");
        List<Map<String, Object>> res = parseExcel(fis, file.getName(), m);
        if (!res.isEmpty()) {
            for (Map<String, Object> ll : res) {
                System.out.println(ll.get("org_name"));
//                System.out.println(JSON.toJSONString(ll.get("org_name")));
            }
        } else {
            System.out.println("日期格式错误");
        }
    }
}
