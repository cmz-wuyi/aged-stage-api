package cn.age.api.controller;

import cn.age.common.redis.RedisRepository;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.statistics.StatisticsVisitCountResp;
import cn.age.service.AuthUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description: 系统统计前端控制器
 * @date 2019-08-22
 */
@RestController
@RequestMapping(value = "api/v1/systemStatistics")
public class SystemStatisticsController extends BaseApiController {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private RedisRepository redisRepository;



    /**
     *  统计系统访问总量
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2019-08-22
     * @param  userName 用户名
     * @return StatisticsVisitCountResp
     */
    @GetMapping("/statisticsVisitCount/{userName}")
    public ApiResponse<StatisticsVisitCountResp> statisticsVisitCount(@PathVariable(name = "userName") String userName){
        return apiResponse(authUserService.statisticsVisitCount(userName));
    }


}
