package cn.age.interaction.resp.export;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.interaction.resp.export
 * @Description: 系统用户导出Resp
 * @date 2021-03-22
 */
@Data
public class AuthUserExportResp implements Serializable {


    private static final long serialVersionUID = -4123630354443443297L;


    /**
     * 用户名
     */
    @Excel(name = "真实姓名", width = 10)
    private String userName;


    /**
     * 手机号
     */
    @Excel(name = "手机号", width = 10)
    private String phoneNumber;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", format = "yyyy-MM-dd", width = 15)
    private LocalDateTime createTime;

}
