package com.tuyendev.control;

import com.tuyendev.controller.BaseController;
import com.tuyendev.dto.ExcelProperDTO;

import com.tuyendev.fw.DataUtil;

import java.io.File;
import java.io.FileOutputStream;

import java.nio.charset.StandardCharsets;

import java.util.*;

import java.util.function.Function;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import one.util.streamex.StreamEx;

import oracle.adf.share.logging.ADFLogger;

import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelImportController extends BaseController {

    private final static ADFLogger logger = ADFLogger.createADFLogger(ExcelImportController.class);

    private List<ExcelProperDTO> lstSpecs = new ArrayList<>();
    private List<ExcelProperDTO> lstSelected = new ArrayList<>();
    private List<ExcelProperDTO> lstOrders = new ArrayList<>();
    private String sortedValue;
    private String step;
    private String headerTitle;
    private int rowCountSameple = 10;

    @PostConstruct
    private void init() {
        try {
            lstSpecs.add(new ExcelProperDTO(1, "CT1"));
            lstSpecs.add(new ExcelProperDTO(2, "CT2"));
            lstSpecs.add(new ExcelProperDTO(3, "CT3"));
            lstSpecs.add(new ExcelProperDTO(4, "CT4"));
            lstSpecs.add(new ExcelProperDTO(5, "CT5"));
            lstSpecs.add(new ExcelProperDTO(7, "CT7"));
            lstSpecs.add(new ExcelProperDTO(8, "CT8"));
            lstSpecs.add(new ExcelProperDTO(9, "CT9"));
            lstSpecs.add(new ExcelProperDTO(10, "CT10"));
            lstSpecs.add(new ExcelProperDTO(11, "CT11"));
            lstSpecs.add(new ExcelProperDTO(12, "CT12"));
            lstSpecs.add(new ExcelProperDTO(13, "CT13"));
            lstSpecs.add(new ExcelProperDTO(14, "CT14"));
            lstSpecs.add(new ExcelProperDTO(15, "CT15"));
            lstSpecs.add(new ExcelProperDTO(17, "CT16"));
            step = "1";
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    public String nextStep() {
        lstSelected = StreamEx.of(lstSpecs)
                              .filter(x -> x.isSelected() && !DataUtil.isNullOrEmpty(x.getRefName()))
                              .toList();
        StreamEx.of(lstSpecs).forEach(x -> {
            if (!x.isSelected()) {
                x.setRefName(null);
            }
        });

        if (!DataUtil.isNullOrEmpty(lstSelected)) {
            sortedValue = StreamEx.of(lstSelected)
                                  .map(x -> x.getId() + " - " + x.getName())
                                  .joining(",");
            step = "2";
            refreshPage(FacesContext.getCurrentInstance());
        } else {
            reportWarm("Thông tin không đủ");
        }

        return null;
    }

    public String downloadTemplate() {
        lstOrders = new ArrayList<>();
        Map<String, ExcelProperDTO> mapSelected =
            StreamEx.of(lstSelected).toMap(x -> x.getId() + " - " + x.getName(), Function.identity());
        List<String> codes = Arrays.asList(sortedValue.split(","));
        codes.forEach(x -> { lstOrders.add(mapSelected.get(x)); });
        createTemplate();
        return null;
    }

    private void createTemplate() {
        try {
            //create new workbook
            String path = FacesContext.getCurrentInstance()
                                      .getExternalContext()
                                      .getRealPath("/");
            Workbook wb = new XSSFWorkbook(new File(path + "WEB-INF//resources//template.xlsx"));
            Sheet sheet = wb.getSheetAt(0);
            int column = lstOrders.size();
            //Create header
            XSSFRow hdRow = (XSSFRow) sheet.createRow(0);
            if (column > 1) {
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, column - 1));
            }
            XSSFCell hdCell = (XSSFCell) CellUtil.createCell(hdRow, 0, DataUtil.upperFirstChar(headerTitle));
            XSSFCellStyle hdCellStyle = (XSSFCellStyle) wb.createCellStyle();
            hdCell.setCellStyle(hdCellStyle);

            //style - align
            hdCellStyle.setAlignment(HorizontalAlignment.CENTER);
            hdCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // color
            hdCellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(51, 153, 255)));
            hdCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            hdCellStyle.setBorderBottom(BorderStyle.THIN);
            hdCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            hdCellStyle.setLocked(true);
            //font
            Font hdFont = wb.createFont();
            hdFont.setFontHeightInPoints((short) 20);
            hdFont.setFontName("Times New Roman");
            hdFont.setBold(true);
            hdFont.setColor(IndexedColors.WHITE.index);
            hdCellStyle.setFont(hdFont);
            // End heeader

            //Create cell
            XSSFRow ttRow = (XSSFRow) sheet.createRow(1);
            XSSFCellStyle ttCellStyle = (XSSFCellStyle) wb.createCellStyle();
            ttCellStyle.setAlignment(HorizontalAlignment.CENTER);
            ttCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // color
            ttCellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 128, 0)));
            ttCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            ttCellStyle.setBorderBottom(BorderStyle.THIN);
            ttCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            ttCellStyle.setBorderLeft(BorderStyle.THIN);
            ttCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            ttCellStyle.setBorderRight(BorderStyle.THIN);
            ttCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            ttCellStyle.setBorderTop(BorderStyle.MEDIUM);
            ttCellStyle.setLocked(true);
            ttCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            //font
            Font ttFont = wb.createFont();
            ttFont.setFontHeightInPoints((short) 16);
            ttFont.setFontName("Times New Roman");
            ttFont.setBold(true);
            ttFont.setColor(IndexedColors.WHITE.index);
            ttCellStyle.setFont(ttFont);
            sheet.protectSheet("123456");
            for (int i = 0; i < column; i++) {
                ExcelProperDTO tmp = lstOrders.get(i);
                sheet.setColumnWidth(i, 255 * 40);
                XSSFCell ttCell = ttRow.createCell(i);
                ttCell.setCellValue(tmp.getName() + " - " + tmp.getRefName());
                ttCell.setCellStyle(ttCellStyle);
            }

            //default style for next row
            XSSFCellStyle dfCellStyle = (XSSFCellStyle) wb.createCellStyle();
            dfCellStyle.setBorderBottom(BorderStyle.THIN);
            dfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            dfCellStyle.setBorderLeft(BorderStyle.THIN);
            dfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            dfCellStyle.setBorderRight(BorderStyle.THIN);
            dfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            dfCellStyle.setBorderTop(BorderStyle.THIN);
            dfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            //font
            Font dfFont = wb.createFont();
            dfFont.setFontHeightInPoints((short) 14);
            dfFont.setFontName("Times New Roman");
            dfFont.setColor(IndexedColors.BLACK.index);
            dfCellStyle.setFont(dfFont);
            dfCellStyle.setLocked(false);

            for (int i = 0; i < rowCountSameple; i++) {
                XSSFRow dfRow = (XSSFRow) sheet.createRow(2 + i);
                for (int j = 0; j < column; j++) {
                    XSSFCell dfCell = dfRow.createCell(j);
                    dfCell.setCellStyle(dfCellStyle);
                }
            }

            //Create File
            FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            reportError(e);
        }
    }

    public String backStep() {
        step = "1";
        return null;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;
    }


    public void setLstSpecs(List<ExcelProperDTO> lstSpecs) {
        this.lstSpecs = lstSpecs;
    }

    public List<ExcelProperDTO> getLstSpecs() {
        return lstSpecs;
    }

    public void setLstSelected(List<ExcelProperDTO> lstSelected) {
        this.lstSelected = lstSelected;
    }

    public List<ExcelProperDTO> getLstSelected() {
        return lstSelected;
    }

    public void setSortedValue(String sortedValue) {
        this.sortedValue = sortedValue;
    }

    public String getSortedValue() {
        return sortedValue;
    }


    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }
}
