package cn.age.service;


import cn.age.interaction.req.ActivityAddReq;
import cn.age.interaction.req.ActivityReq;
import cn.age.interaction.req.ActivityUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.ActivityResp;

import java.util.List;

/**
* @author Singer create by Singer email:singer-coder@qq.com
* @packageName cn.age.service
* @Description: 床位相关服务
* @date 2021-04-23
*/
public interface ActivityService {

    /**
    * 新增
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param addReq 新增Req
    */
    void addItem(ActivityAddReq addReq);

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    void batchDeleteItem(List<String> mainIdList);

    /**
     * 查询所有床位信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @param  req 查询Req
     * @return java.util.List
     */
    List<ActivityResp> allBedSketch(ActivityReq req);

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    Pagination<ActivityResp> queryByPage(
        ActivityReq pageReq);

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    void updateItem(ActivityUpdateReq updateReq);

}
