package excel;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhangbj
 * @version 1.0
 * @Type ExcelParseUtils
 * @Desc
 * @data 2016/10/27
 */

public class ExcelParseUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelParseUtils.class);

    /**
     * @param file
     * @param start 从该行开始遍历数据
     */
    private static List<String> XSSFparseExcel(File file, Integer start) {
        List<String> jsonStrList = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            //读取excel表格内容
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //创建sheet集合
            int sheetCounts = workbook.getNumberOfSheets();
            List<XSSFSheet> sheets = new ArrayList<>();
            //遍历所有sheet表格
            for (int index = 0; index < sheetCounts; index++) {
                XSSFSheet sheet = workbook.getSheetAt(index);
                sheets.add(sheet);
            }

            /*// 得到最后一个表格内容，用于拼接Json字符串Key值
            XSSFSheet lastSheet = sheets.get(sheets.size() - 1);
            // 获得表格中字段名
            XSSFRow lastSheetRow = lastSheet.getRow(lastSheet.getFirstRowNum());
            Iterator<Cell> cellList = lastSheetRow.cellIterator();
            List<String> columns = new ArrayList<>();
            while (cellList.hasNext()) {
                columns.add(cellList.next().toString());
            }*/

            //遍历sheets-1中每行内容
            sheets.forEach(sheet -> {
                for (int rowIndex = start; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    XSSFRow rowData = sheet.getRow(rowIndex);
                    StringBuilder buffer = new StringBuilder("{");
                    for (int colIndex = 0; colIndex < rowData.getLastCellNum(); colIndex++) {
                        if (rowData.getCell(colIndex).getCellTypeEnum() == CellType.NUMERIC) {
                            DecimalFormat format = new DecimalFormat("#.##");
                            if (colIndex == rowData.getLastCellNum() - 1) {
                                buffer.append("\"" + colIndex + "\":\"" + format.format(rowData.getCell(colIndex).getNumericCellValue()).toString() + "\"");
                            } else {
                                buffer.append("\"" + colIndex + "\":\"" + format.format(rowData.getCell(colIndex).getNumericCellValue()).toString() + "\",");
                            }
                        } else {
                            if (colIndex == rowData.getLastCellNum() - 1) {
                                buffer.append("\"" + colIndex + "\":\"" + rowData.getCell(colIndex).toString() + "\"");
                            } else {
                                buffer.append("\"" + colIndex + "\":\"" + rowData.getCell(colIndex).toString() + "\",");
                            }
                        }
                    }
                    buffer.append("}");
                    jsonStrList.add(buffer.toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return jsonStrList;
    }

    private static List<String> HSSFparseExcel(File file, Integer start) {
        List<String> jsonStrList = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            //读取excel表格内容
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //创建sheet集合
            int sheetCounts = workbook.getNumberOfSheets();
            List<HSSFSheet> sheets = new ArrayList<>();
            //遍历所有sheet表格
            for (int index = 0; index < sheetCounts; index++) {
                HSSFSheet sheet = workbook.getSheetAt(index);
                sheets.add(sheet);
            }
            //遍历sheets-1中每行内容
            sheets.forEach(sheet -> {
                for (int rowIndex = start; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    HSSFRow rowData = sheet.getRow(rowIndex);
                    StringBuffer buffer = new StringBuffer("{");
                    for (int colIndex = 0; colIndex < rowData.getLastCellNum(); colIndex++) {
                        if (rowData.getCell(colIndex).getCellTypeEnum() == CellType.NUMERIC) {
                            DecimalFormat format = new DecimalFormat("0");
                            if (colIndex == rowData.getLastCellNum() - 1) {
                                buffer.append("\"" + colIndex + "\":\"" + format.format(rowData.getCell(colIndex).getNumericCellValue()).toString() + "\"");
                            } else {
                                buffer.append("\"" + colIndex + "\":\"" + format.format(rowData.getCell(colIndex).getNumericCellValue()).toString() + "\",");
                            }
                        } else {
                            if (colIndex == rowData.getLastCellNum() - 1) {
                                buffer.append("\"" + colIndex + "\":\"" + rowData.getCell(colIndex).toString() + "\"");
                            } else {
                                buffer.append("\"" + colIndex + "\":\"" + rowData.getCell(colIndex).toString() + "\",");
                            }
                        }
                    }
                    buffer.append("}");
                    jsonStrList.add(buffer.toString());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return jsonStrList;
    }

    public static List<String> parseExcel(File file, Integer start) {
        boolean isXSSF = file.getName().endsWith("xlsx");
        boolean isHSSF = file.getName().endsWith("xls");
        if (isXSSF) {
            return XSSFparseExcel(file, start);
        } else if (isHSSF) {
            return HSSFparseExcel(file, start);
        } else {
            LOGGER.error("Excel解析错误，请检查源文件是否为xlsx或xls文件！");
            return null;
        }
    }

    public static void exportExcel(String[] titles, List<String> list, OutputStream outputStream, String fileName, Map<Integer, String[]> templete) {
        // 创建一个workbook 对应一个excel应用文件
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        //Sheet名称，可以自定义中文名称
        XSSFSheet sheet = workBook.createSheet("sheet");
        ExportInternalUtil exportUtil = new ExportInternalUtil(workBook, sheet);
        XSSFCellStyle headStyle = exportUtil.getHeadStyle();
        XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();
        // 构建表头
        XSSFRow headRow = sheet.createRow(0);
        XSSFCell cell = null;

        for (int i = 0; i < titles.length; i++) {
            cell = headRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(titles[i]);
            cell.setCellType(CellType.STRING);
        }

        for (int i = 0; i < list.size(); i++) {
            XSSFRow bodyRow = sheet.createRow(i + 1);
            String[] str = list.get(i).split(",");
            int sheetCount = 1;
            for (int j = 0; j < str.length; j++) {
                cell = bodyRow.createCell(j);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(str[j]);
                if (templete.containsKey(j)) {
                    try {
                        Test.dropDownList2003(workBook, sheet, templete.get(j), 1, 20, j, j, "hidden" + sheetCount, sheetCount);
                        sheetCount++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        try {
            workBook.write(outputStream);
            workBook.close();
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            LOGGER.error("生成EXCEL出错", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                LOGGER.error("outputStream 关闭失败， errMsg={}", e.getMessage());
            }
        }


    }

    public static void main(String[] args) {
        FileOutputStream outputStream = null;
        String[] titles = {"机构", "签约医生总数", "签约居民总数", "居民（男）", "居民（女）", "省医保", "市医保", "其他医保"};
        String name = "周报";

        List<String> list = new ArrayList<>();
        list.add("1,1,1,1,1,1,1,1");
        String[] templete1 = {"未知", "A", "B", "C"};
        String[] templete2 = {"未知", "D", "E", "F"};
        Map<Integer, String[]> list1 = new HashMap<>();
        list1.put(0, templete1);
        list1.put(5, templete2);
        try {

            File file = new File("C:\\Users\\SEEBLACK\\Desktop\\vvv.xlsx");
            outputStream = new FileOutputStream(file);
            exportExcel(titles, list, outputStream, "xxx", list1);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                LOGGER.error("outputStream 关闭失败， errMsg={}", e.getMessage());
            }

        }

    }


}
