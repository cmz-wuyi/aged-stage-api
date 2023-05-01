package cn.age.common.enums.other;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.enums
 * @Description: 文件类型枚举
 * @date 2021-02-16
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    /**
      * 男-图片
      */
    IMAGE ("man","男性"),

    /**
     * 女-视频
     */
    VIDEO("woman","女性");

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
