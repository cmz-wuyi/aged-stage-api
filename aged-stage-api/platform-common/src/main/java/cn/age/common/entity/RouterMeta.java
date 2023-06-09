package cn.age.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: Vue路由 Meta
 * @date 2019-08-22
 */
@Data
@AllArgsConstructor
public class RouterMeta implements Serializable {


    private static final long serialVersionUID = -6132929392806589628L;


    /**
      * 是否可以关闭
      */
    private Boolean closeable;


    /**
     * 是否展示
     */
    private Boolean isShow;

}
