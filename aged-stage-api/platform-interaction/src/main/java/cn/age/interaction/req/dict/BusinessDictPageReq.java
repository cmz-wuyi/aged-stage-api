package cn.age.interaction.req.dict;

import cn.age.common.interaction.base.page.BasePageReq;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统业务字典分页查询Req
 * @date 2020-07-07
 */
@Data
public class BusinessDictPageReq extends BasePageReq implements Serializable {

    private static final long serialVersionUID = 6341081874728412289L;


    /**
     * 业务字典类型
     */
    private String  dictType;

    /**
     * 键
     */
    private String  dictKey;

    /**
     * 值
     */
    private String  dictValue;

    /**
     * 排序字段
     */
    private Integer sortIndex;

}
