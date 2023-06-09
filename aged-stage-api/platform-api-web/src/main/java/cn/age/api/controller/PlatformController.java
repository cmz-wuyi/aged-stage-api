package cn.age.api.controller;


import cn.age.common.anon.ApiLog;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.service.PlatformService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description:
 * @date 2020-06-11
 */
@RestController
@RequestMapping(value = "api/v1/platform")
@Slf4j
public class PlatformController extends BaseApiController {

    @Resource
    private PlatformService platformService;

    /**
     * 生成雪花算法ID
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/10
     * @return String
     */
    @GetMapping(value = "/snowflakeId")
    @ApiLog(value = "生成雪花算法ID")
    public ApiResponse<String> snowflakeId(){
        return apiResponse(platformService.snowflakeId());
    }

    /**
     * 当前服务器时间
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/5/10
     * @return String
     */
    @GetMapping(value = "/currenLongTime")
    @ApiLog(value = "当前服务器时间")
    public ApiResponse<Long> currenLongTime(){
        return apiResponse(platformService.currenLongTime());
    }

    /**
     * 从配置文件读取配置编辑器配置信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/6/8
     * @return java.util.List
     */
    @GetMapping(value = "/editorConfig")
    @ApiLog(value = "从配置文件读取配置编辑器配置信息")
    public JSONObject editorConfig(){
        return platformService.editorConfig();
    }

}
