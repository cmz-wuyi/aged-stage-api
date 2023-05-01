package cn.age.common.enums.audit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 整体流程状态的枚举
 * @date 2021-05-08
 */
@Getter
@AllArgsConstructor
public enum AuditStatusEnum {

    /**
     * 开始流程
     */
    BEGIN ("BEGIN"),

    /**
     * 进行中
     */
    PROCESSING("PROCESSING"),

    /**
     * 结束
     */
    END("END");

    /**
     * 状态码
     */
    private String code;

    public String getCode() {
        return code;
    }

}
