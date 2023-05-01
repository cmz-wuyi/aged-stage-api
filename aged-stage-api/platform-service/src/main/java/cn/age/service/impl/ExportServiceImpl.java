package cn.age.service.impl;


import cn.age.common.constants.BaseConstant;
import cn.age.repository.repository.AuthRoleRepository;
import cn.age.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.zmi.service.impl
 * @Description: 导出相关服务方法实现
 * @date 2021-03-22
 */
@Service("exportService")
@Slf4j
public class ExportServiceImpl {


    @Resource
    private AuthUserService authUserService;

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private BaseConstant baseConstant;

    @Resource
    private AuthRoleRepository authRoleRepository;


}
