package cn.age.interaction.excel;

import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

/**
 * @Description: 基础的导入和导出数据校验
 */
@Data
public class BaseExcelEntity implements IExcelDataModel, IExcelModel {

    /**
     * 行号
     */
    private Integer rowNum;

    /**
     * 错误
     */
    private String errorMsg;

    @Override
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }
}
