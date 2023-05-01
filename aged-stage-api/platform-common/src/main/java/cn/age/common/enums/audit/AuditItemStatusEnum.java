package cn.age.common.enums.audit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 审核流程状态的枚举
 * @date 2021-05-08
 */
@Getter
@AllArgsConstructor
public enum AuditItemStatusEnum {

    /**
     * 通过
     */
    APPROVED ("APPROVED","通过"),

    /**
     * 驳回
     */
    REJECT("REJECT","驳回"),

    /**
     * 待处理
     */
    WAIT_HANDLE("WAIT_HANDLE","待处理"),

    /**
     * 最终通过
     */
    ULTIMATE_APPROVED("ULTIMATE_APPROVED","最终通过"),

    /**
     * 最终驳回
     */
    ULTIMATE_REJECT("ULTIMATE_REJECT","最终驳回");

    /**
     * 状态码
     */
    private String code;

    /**
     * 描述
     */
    private String description;


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
