package cn.age.api.controller;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.interaction.req.ServiceRecordAddReq;
import cn.age.interaction.req.ServiceRecordReq;
import cn.age.interaction.req.ServiceRecordUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.ServiceRecordResp;
import cn.age.service.ServiceRecordService;
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
@RequestMapping(value = "api/v1/serviceRecord")
@Slf4j
public class ServiceRecordController extends BaseApiController {

    @Resource
    private ServiceRecordService serviceRecordService;

    @Resource
    private HttpServletResponse response;

    @Resource
    private IExcelDictHandler excelDictHandler;

    /**
     * 新增
     *
     * @param addReq 新增Req
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @PostMapping(value = "/addItem")
    @RequiresPermissions("serviceRecord:add")
    public ApiResponse addItem(@RequestBody @Valid ServiceRecordAddReq addReq) {
        try {
            serviceRecordService.addItem(addReq);
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponse(e.getMessage());
        }
        return apiResponse();
    }

    /**
     * 主键ID集合批量
     *
     * @param mainIdList 主键ID集合
     */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("serviceRecord:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList) {
        serviceRecordService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
     * 更新
     *
     * @param updateReq 更新请求参数
     */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("serviceRecord:edit")
    public ApiResponse updateItem(@RequestBody @Valid ServiceRecordUpdateReq updateReq) {
        serviceRecordService.updateItem(updateReq);
        return apiResponse();
    }

    /**
     * 分页查询
     */
    @PostMapping(value = "/queryByPage")
    @RequiresPermissions("serviceRecord:itemList")
    public ApiResponse<Pagination<ServiceRecordResp>> queryByPage(
            @RequestBody @Valid ServiceRecordReq pageReq) {
        return apiResponse(serviceRecordService.queryByPage(pageReq));
    }

    /**
     * 接单
     *
     * @param updateReq 更新请求参数
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2022/2/6
     */
    @PutMapping(value = "/receiving/{serviceRecordId}")
    @RequiresPermissions("serviceRecord:receiving")
    public ApiResponse orderReceiving ( @PathVariable String serviceRecordId) {
        serviceRecordService.receiving(serviceRecordId);
        return apiResponse();
    }

    /**
     * 结束订单
     *
     * @param updateReq 更新请求参数
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2022/2/6
     */
    @PutMapping(value = "/finish/{serviceRecordId}")
    @RequiresPermissions("serviceRecord:receiving")
    public ApiResponse finish ( @PathVariable String serviceRecordId) {
        serviceRecordService.finish(serviceRecordId);
        return apiResponse();
    }

    /**
     * 取消订单
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2022/2/6
     */
    @PutMapping(value = "/cancel/{serviceRecordId}")
    @RequiresPermissions("serviceRecord:receiving")
    public ApiResponse cancel ( @PathVariable String serviceRecordId) {
        serviceRecordService.cancel(serviceRecordId);
        return apiResponse();
    }
}
