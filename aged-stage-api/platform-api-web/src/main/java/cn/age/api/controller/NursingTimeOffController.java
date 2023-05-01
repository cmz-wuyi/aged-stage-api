package cn.age.api.controller;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.exception.ApiException;
import cn.age.common.exception.BusinessException;
import cn.age.interaction.req.NursingTimeOffAddReq;
import cn.age.interaction.req.NursingTimeOffReq;
import cn.age.interaction.req.NursingTimeOffUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.NursingTimeOffResp;
import cn.age.service.NursingTimeOffService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.api.controller
 * @Description: 税收前端控制器
 * @date 2021-04-23
 */
@RestController
@RequestMapping(value = "api/v1/nursingTimeOff")
@Slf4j
public class NursingTimeOffController extends BaseApiController {

    @Resource
    private NursingTimeOffService nursingTimeOffService;

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
    @RequiresPermissions("nursingTimeOff:add")
    public ApiResponse addItem(@RequestBody @Valid NursingTimeOffAddReq addReq) throws Exception {

        nursingTimeOffService.addItem(addReq);
        return apiResponse();
    }

    /**
     * 主键ID集合批量
     *
     * @param mainIdList 主键ID集合
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/2
     */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("nursingTimeOff:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList) {
        nursingTimeOffService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
     * 更新
     *
     * @param updateReq 更新请求参数
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/2
     */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("nursingTimeOff:edit")
    public ApiResponse updateItem(@RequestBody @Valid NursingTimeOffUpdateReq updateReq) {
        nursingTimeOffService.updateItem(updateReq);
        return apiResponse();
    }

    /**
     * 分页查询
     *
     * @param pageReq 分页查询Req
     * @return Pagination
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/2/15
     */
    @PostMapping(value = "/queryByPage")
    @RequiresPermissions("nursingTimeOff:itemList")
    public ApiResponse<Pagination<NursingTimeOffResp>> queryByPage(
            @RequestBody @Valid NursingTimeOffReq pageReq) {
        return apiResponse(nursingTimeOffService.queryByPage(pageReq));
    }

    @PutMapping(value = "/approved")
    @RequiresPermissions("nursingTimeOff:approved")
    public ApiResponse approvedItem(@RequestBody Map<String, String> params) {
        String mainId = params.get("mainId");
        String status = params.get("status");
        nursingTimeOffService.approved(mainId, Integer.parseInt(status));
        return apiResponse();
    }
}
