package cn.age.api.controller;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.interaction.req.ActivityAddReq;
import cn.age.interaction.req.ActivityReq;
import cn.age.interaction.req.ActivityUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.ActivityResp;
import cn.age.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
* @author Singer create by Singer email:singer-coder@qq.com
* @packageName cn.age.api.controller
* @Description: 税收前端控制器
*/
@RestController
@RequestMapping(value = "api/v1/activity")
@Slf4j
public class ActivityController extends BaseApiController {

    @Resource
    private ActivityService activityService;

    @Resource
    private HttpServletResponse response;

    @Resource
    private IExcelDictHandler excelDictHandler;

    /**
    * 新增
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param addReq 新增Req
    */
    @PostMapping(value = "/addItem")
    @RequiresPermissions("activity:add")
    public ApiResponse addItem(@RequestBody @Valid ActivityAddReq addReq){
        activityService.addItem(addReq);
        return apiResponse();
    }

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("activity:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList){
        activityService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("activity:edit")
    public ApiResponse updateItem(@RequestBody @Valid ActivityUpdateReq updateReq){
        activityService.updateItem(updateReq);
        return apiResponse();
    }

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    @PostMapping(value = "/queryByPage")
    @RequiresPermissions("activity:itemList")
    public ApiResponse<Pagination<ActivityResp>> queryByPage(
        @RequestBody @Valid ActivityReq pageReq){
        return apiResponse(activityService.queryByPage(pageReq));
    }

    /**
     * 查询所有床位信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @return java.util.List
     */
    @PostMapping(value = "/allBedSketch")
    public ApiResponse<List<ActivityResp>> allBedSketch(@RequestBody @Valid ActivityReq pageReq){
        return apiResponse(activityService.allBedSketch(pageReq));
    }
}
