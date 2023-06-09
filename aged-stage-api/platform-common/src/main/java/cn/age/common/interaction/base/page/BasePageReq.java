package cn.age.common.interaction.base.page;

import cn.age.common.interaction.base.BaseReq;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.*;

/**
 * 基本的分页查询封装
 * @author singer E-mail:singer-coder@qq.com
 * 创建时间：2018/5/9 下午10:11
 */
@Data
//@ApiModel
public class BasePageReq extends BaseReq implements Serializable {

    private static final long serialVersionUID = -5187157098146320356L;

    /**
     * 当前页码数
     */
    @JSONField(name = "pageNum")
    private Integer currentPage = 1;

    /**
     * 每页条数
     */
    @JSONField(name = "pageSize")
    private Integer itemsPerPage = 10;

}
