package cn.age.interaction.resp.menu;

import cn.age.common.entity.Tree;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统认证菜单分页查询Resp 包装Resp
 * @date 2019-08-26
 */
@Data
public class AuthMenuTreeQueryWrapResp implements Serializable {


    private static final long serialVersionUID = -7552351002493492192L;



    /**
      * 菜单ID
      */
    private List<String> ids;


    /**
     * 数据
     */
    @JSONField(name = "rows")
    private Tree<AuthMenuTreeResp> menuTree;

    /**
     * 总数量
     */
    private Integer total;

}
