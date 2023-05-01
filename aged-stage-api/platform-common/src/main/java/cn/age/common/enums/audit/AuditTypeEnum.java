package cn.age.common.enums.audit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 审核类型的枚举
 * @date 2021-05-08
 */
@Getter
@AllArgsConstructor
public enum AuditTypeEnum {

    /**
     * 企业信息
     */
    CORP_DATA ("CORP_DATA","企业信息"),

    /**
     * 企业报告
     */
    CORP_REPORT("CORP_REPORT","企业报告"),

    /**
     * 民营经济
     */
    NO_AUTH_ECONOMY("NO_AUTH_ECONOMY","民营经济");

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
