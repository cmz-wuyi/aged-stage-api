//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.age.common.export;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHandler {
    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(dataList, clz, fileName, response, exportParams);
    }

    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, boolean isCreateHeader, HttpServletResponse response, IExcelDictHandler dictHandler) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        if (null != dictHandler) {
            exportParams.setDictHandler(dictHandler);
        }

        defaultExport(dataList, clz, fileName, response, exportParams);
    }

    private ExcelHandler() {
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    private static <T> void defaultExport(List<T> dataList, Class<?> clz, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, clz, dataList);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }

    }

    public static <T> void exportExcel(List<T> dataList, String title, String sheetName, Class<?> clz, String fileName, HttpServletResponse response) {
        defaultExport(dataList, clz, fileName, response, new ExportParams(title, sheetName));
    }

    private static void defaultExport(List<Map<String, Object>> dataList, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(dataList, ExcelType.HSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }

    }

    public static void exportExcel(List<Map<String, Object>> dataList, String fileName, HttpServletResponse response) {
        defaultExport(dataList, fileName, response);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> clz) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        } else {
            ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);

            try {
                return ExcelImportUtil.importExcel(new File(filePath), clz, params);
            } catch (Exception var6) {
                throw new RuntimeException(var6.getMessage());
            }
        }
    }

    public static <T> List<T> importExcel(File file, Integer titleRows, Integer headerRows, Class<T> clz, IExcelDictHandler dictHandler) {
        if (file == null) {
            return null;
        } else {
            ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);
            params.setNeedVerify(true);
            if (null != dictHandler) {
                params.setDictHandler(dictHandler);
            }

            try {
                return ExcelImportUtil.importExcel(file, clz, params);
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> clz, IExcelDictHandler dictHandler) {
        if (file == null) {
            return null;
        } else {
            ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);
            params.setNeedVerify(true);
            if (null != dictHandler) {
                params.setDictHandler(dictHandler);
            }

            try {
                return ExcelImportUtil.importExcel(file.getInputStream(), clz, params);
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public static <T> ExcelImportResult<T> importExcelMore(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> clz, IExcelDictHandler dictHandler) {
        if (file == null) {
            return null;
        } else {
            ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);
            params.setNeedVerify(true);
            if (null != dictHandler) {
                params.setDictHandler(dictHandler);
            }

            try {
                ExcelImportResult<T> importResult = ExcelImportUtil.importExcelMore(file.getInputStream(), clz, params);
                return importResult;
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }
}
