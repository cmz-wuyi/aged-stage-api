package cn.age.api.controller;

import cn.age.interaction.req.*;
import cn.age.interaction.resp.OldSketchResp;
import cn.age.interaction.resp.TemplateServiceResp;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.service.TemplateServiceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/templateService")
@Slf4j
public class TemplateServiceController extends BaseApiController {
    @Resource
    TemplateServiceService templateService;


    /**
     * 新增
     */
    @PostMapping(value = "/addItem")
    @RequiresPermissions("templateService:add")
    public ApiResponse addItem(@RequestBody @Valid TemplateServiceAddReq addReq){
        templateService.addItem(addReq);
        return apiResponse();
    }

    /**
     * 分页查询
     */
    @PostMapping(value = "/queryByPage")
    @RequiresPermissions("templateService:itemList")
    public ApiResponse<Pagination<OldSketchResp>> queryByPage(
            @RequestBody @Valid TemplateServiceReq pageReq){
        return apiResponse(templateService.queryByPage(pageReq));
    }

    /**
     * @param mainIdList 主键ID集合
     */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("templateService:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList){
        templateService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
     * 更新
     * @param updateReq 更新请求参数
     */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("templateService:edit")
    public ApiResponse updateItem(@RequestBody @Valid TemplateServiceUpdateReq updateReq){
        templateService.updateItem(updateReq);
        return apiResponse();
    }

    /**
     * 查询所有服务配置信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @return java.util.List
     */
    @GetMapping(value = "/allServiceSketch")
    public ApiResponse<List<TemplateServiceResp>> allServiceSketch(){
        return apiResponse(templateService.allServiceSketch());
    }

}
