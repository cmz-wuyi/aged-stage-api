package cn.age.interaction.req.common;

import cn.age.common.validation.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 多个文件访问地址
 * @date 2020-06-14
 */
@Data
public class MultipleFileAccessUrlReq implements Serializable {

    private static final long serialVersionUID = -6873656812450906963L;



    /**
      * 文件名称集合
      */
    @NotEmpty(message = "文件名称集合->不可为空")
    private List<String> fileNameList;

}
