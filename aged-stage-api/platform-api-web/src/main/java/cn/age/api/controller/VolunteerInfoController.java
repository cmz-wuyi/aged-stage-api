package cn.age.api.controller;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.interaction.req.VolunteerInfoAddReq;
import cn.age.interaction.req.VolunteerInfoReq;
import cn.age.interaction.req.VolunteerInfoUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.VolunteerInfoResp;
import cn.age.service.VolunteerInfoService;
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

/**
* @author Singer create by Singer email:singer-coder@qq.com
* @packageName cn.age.api.controller
* @Description: 税收前端控制器
* @date 2021-04-23
*/
@RestController
@RequestMapping(value = "api/v1/volunteerInfo")
@Slf4j
public class VolunteerInfoController extends BaseApiController {

    @Resource
    private VolunteerInfoService volunteerInfoService;

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
    @RequiresPermissions("volunteer:add")
    public ApiResponse addItem(@RequestBody @Valid VolunteerInfoAddReq addReq){
        volunteerInfoService.addItem(addReq);
        return apiResponse();
    }

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("nursingSalary:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList){
        volunteerInfoService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("nursingSalary:edit")
    public ApiResponse updateItem(@RequestBody @Valid VolunteerInfoUpdateReq updateReq){
        volunteerInfoService.updateItem(updateReq);
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
    @RequiresPermissions("nursingSalary:itemList")
    public ApiResponse<Pagination<VolunteerInfoResp>> queryByPage(
        @RequestBody @Valid VolunteerInfoReq pageReq){
        return apiResponse(volunteerInfoService.queryByPage(pageReq));
    }
}
