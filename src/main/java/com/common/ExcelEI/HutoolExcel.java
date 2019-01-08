package com.common.ExcelEI;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.List;

public class HutoolExcel {


    public static void main(String[] args) {

//        BigExcelWriter writer= ExcelUtil.getBigWriter("/Users/lucasma/Downloads/monitor_data2.xlsx");

        ExcelUtil.read07BySax("/Users/lucasma/Downloads/monitor_data2.xlsx", 0, createRowHandler());


    }


    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
            }
        };
    }
}
