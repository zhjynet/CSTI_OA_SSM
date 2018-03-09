package com.util;

import net.sf.json.JSONArray;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjingyu
 */
public class ExcleUtils {
        private XSSFSheet excelWsheet;

    //设定要操作的Excel 的文件路径和Excel 文件中的sheet名称
        //在读写excel的时候，均需要先调用此方法，设定要操作的excel 文件路径和要操作的sheet名称

        public ExcleUtils(String path, String sheetName) throws Exception{
            FileInputStream excelFile;

            //实例化excel 文件的FileInputStream 对象
            excelFile = new FileInputStream(path);
            //实例化excel 文件的XSSFWorkbook 对象
            XSSFWorkbook excelWBook = new XSSFWorkbook(excelFile);
            //实例化ExcelWSheet 对象，指定excel 文件中的sheet 名称，后续用于sheet 中行、列和单元格的操作
            excelWsheet = excelWBook.getSheet(sheetName);
        }

        private String getCellData(int rowNum, int colNum){
            try{
                XSSFCell cell = excelWsheet.getRow(rowNum).getCell(colNum);
                String cellData = "";
                if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    cellData = cell.getStringCellValue();
                }if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
                    DecimalFormat df = new DecimalFormat("0");
                    cellData=df.format(cell.getNumericCellValue());
                }else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK){
                    cellData = "";
                }
                return cellData;
            }catch (Exception e){
                e.printStackTrace();
                return  "";
            }
        }

        public JSONArray getResult(){
            Map<String, String> map = new HashMap<>(16);
            JSONArray json = new JSONArray();
            for (int i = 4;i < getLastCellNum();i++){
                map.put("studentNumber",getCellData(i,0));
                map.put("name",getCellData(i,1));
                map.put("groupID",getCellData(i,2));
                map.put("configPermission",getCellData(i,3));
                json.add(map);
            }
            return json;
        }

        private int getLastCellNum(){
            return excelWsheet.getPhysicalNumberOfRows();
        }





    public static void main(String[] args) throws Exception {
        ExcleUtils excleUtils = new ExcleUtils("/Users/zhangjingyu/Documents/Programing/2018/2018FirstQuarter/2018寒假/CSTI_OA/target/CSTI_OA/file/用户信息模版.xlsx","Sheet1");
        System.out.println(excleUtils.getLastCellNum());
        System.out.println(excleUtils.getResult().toString());
        JSONArray result = excleUtils.getResult();
        System.out.println(((Map) result.get(0)).get("name"));
    }
}
