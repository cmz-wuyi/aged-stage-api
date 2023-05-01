package cn.age.service;

import cn.age.interaction.internal.auth.AsyncAuthMeta;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.service
 * @Description: 异步处理服务
 * @date 2021-09-30
 */
public interface AsyncHandlerService {


    /**
     * 异步处理登录
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/9/30
     * @param authMeta 异步认证所需的基元信息
     */
    void handleLoginAsync(AsyncAuthMeta authMeta);


    /**
     * 当前用户登出
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-21
     * @param authUserId 当前用户的ID
     */
    void asyncHandleLogOut(String authUserId);

}
