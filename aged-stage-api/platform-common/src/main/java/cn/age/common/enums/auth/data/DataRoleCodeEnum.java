package cn.age.common.enums.auth.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 角色数据隔离枚举
 * @date 2021-05-25
 */
@Getter
@AllArgsConstructor
public enum DataRoleCodeEnum {

    /**
     * 超级管理员
     */
    ADMIN_ACCOUNT ("ADMIN_ACCOUNT"),

    /**
     * 普通管理员
     */
    COMMON_ADMIN("COMMON_ADMIN"),

    /**
     * 普通员工
     */
    COMMON_STAFF("COMMON_STAFF"),

    /**
     * 推广人员
     */
    PROMOTION_STAFF("PROMOTION_STAFF");

    /**
     * 状态码
     */
    private String code;

    public String getCode() {
        return code;
    }
}
