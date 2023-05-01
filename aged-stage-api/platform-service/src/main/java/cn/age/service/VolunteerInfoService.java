package cn.age.service;


import cn.age.interaction.req.VolunteerInfoAddReq;
import cn.age.interaction.req.VolunteerInfoReq;
import cn.age.interaction.req.VolunteerInfoUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.VolunteerInfoResp;

import java.util.List;

/**
* @author Singer create by Singer email:singer-coder@qq.com
* @packageName cn.age.service
* @Description: 志愿者招募信息相关服务
* @date 2021-04-23
*/
public interface VolunteerInfoService {

    /**
    * 新增
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param addReq 新增Req
    */
    void addItem(VolunteerInfoAddReq addReq);

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    void batchDeleteItem(List<String> mainIdList);

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    Pagination<VolunteerInfoResp> queryByPage(
        VolunteerInfoReq pageReq);

    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    void updateItem(VolunteerInfoUpdateReq updateReq);

}
