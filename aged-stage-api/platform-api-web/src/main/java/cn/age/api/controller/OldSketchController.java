package cn.age.api.controller;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.interaction.req.OldSketchAddReq;
import cn.age.interaction.req.OldSketchReq;
import cn.age.interaction.req.OldSketchUpdateReq;
import cn.age.interaction.resp.base.ApiResponse;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.OldSketchResp;
import cn.age.service.OldSketchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
* @date 2021-04-23
*/
@RestController
@RequestMapping(value = "api/v1/oldSketch")
@Slf4j
public class OldSketchController extends BaseApiController {

    @Resource
    private OldSketchService oldSketchService;

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
    @RequiresPermissions("oldSketch:add")
    public ApiResponse addItem(@RequestBody @Valid OldSketchAddReq addReq){
        oldSketchService.addItem(addReq);
        return apiResponse();
    }

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    @DeleteMapping(value = "/batchDeleteItem/{mainIdList}")
    @RequiresPermissions("oldSketch:batchDelete")
    public ApiResponse batchDeleteItem(@PathVariable(name = "mainIdList") String mainIdList){
        oldSketchService.batchDeleteItem(Arrays.asList(mainIdList.split(",")));
        return apiResponse();
    }

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    @PutMapping(value = "/updateItem")
    @RequiresPermissions("oldSketch:edit")
    public ApiResponse updateItem(@RequestBody @Valid OldSketchUpdateReq updateReq){
        oldSketchService.updateItem(updateReq);
        return apiResponse();
    }

    /**
     * 分配床位
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/31
     * @param req 分配床位请求参数
     * @return
     */
//    @PutMapping(value = "/allotBed")
//    @RequiresPermissions("bedSketch:allot")
//    public ApiResponse allotBed(@RequestBody @Valid OldSketchUpdateReq req){
//        oldSketchService.allotBed(req);
//        return apiResponse();
//    }

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    @PostMapping(value = "/queryByPage")
    @RequiresPermissions("oldSketch:itemList")
    public ApiResponse<Pagination<OldSketchResp>> queryByPage(
        @RequestBody @Valid OldSketchReq pageReq){
        return apiResponse(oldSketchService.queryByPage(pageReq));
    }

    /**
     * 查询所有老人信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @return java.util.List
     */
    @GetMapping(value = "/allOldSketch")
    public ApiResponse<List<OldSketchResp>> allOldSketch(){
        return apiResponse(oldSketchService.allOldSketch());
    }
}
