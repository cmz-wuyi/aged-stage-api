package cn.age.common.enums.auth.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 用户简略信息关联其他信息的枚举
 * @date 2021-05-08
 */
@Getter
@AllArgsConstructor
public enum AuthUserOtherTypeEnum {

    /**
     * 企业
     */
    CORP ("CORP"),

    /**
     * 地区
     */
    REGION("REGION");

    /**
     * 状态码
     */
    private String code;

    public String getCode() {
        return code;
    }

}
