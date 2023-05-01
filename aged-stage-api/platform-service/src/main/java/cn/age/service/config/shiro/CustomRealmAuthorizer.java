package cn.age.service.config.shiro;

import cn.age.common.enums.ApiAccessType;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 自定义的授权器
 * @date 2019-09-09
 */
public class CustomRealmAuthorizer extends ModularRealmAuthorizer {

    /**
      * 判断是否有权限访问某个权限
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/3/30
      * @param principals 认证成功的身份集合
      * @param permission 权限
      * @return boolean
      */
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();

        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)){ continue;}
            //  todo 授权配置
            // 判断realm
            if (realm.getName().contains(ApiAccessType.API_ACCESS_TYPE_APP.toString())) {
                // 判断是否改realm的资源
                if (permission.contains("app")) {
                    // 使用改realm的授权方法
                    return ((AppAuthorizationRealm) realm).isPermitted(principals, permission);
                }
            }
            if (realm.getName().contains(ApiAccessType.API_ACCESS_TYPE_WEB.toString())) {
                if (permission.contains("web")) {
                    return ((ShiroAuthorizationRealm) realm).isPermitted(principals, permission);
                }
            }
        }
        return false;
    }
}
