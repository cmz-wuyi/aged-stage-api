package cn.age.service;


import cn.age.interaction.req.OldSketchAddReq;
import cn.age.interaction.req.OldSketchReq;
import cn.age.interaction.req.OldSketchUpdateReq;
import cn.age.interaction.resp.page.Pagination;
import cn.age.interaction.resp.OldSketchResp;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Singer create by Singer email:singer-coder@qq.com
* @packageName cn.age.service
* @Description: 老人信息相关服务
* @date 2021-04-23
*/
public interface OldSketchService {

    /**
    * 新增
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param addReq 新增Req
    */
    void addItem(OldSketchAddReq addReq);

    /**
    * 主键ID集合批量
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/2
    * @param mainIdList 主键ID集合
    */
    void batchDeleteItem(List<String> mainIdList);

    /**
     * 查询所有老人信息
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/12/14
     * @return java.util.List
     */
    List<OldSketchResp> allOldSketch();

    /**
    * 分页查询
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/2/15
    * @param  pageReq 分页查询Req
    * @return Pagination
    */
    Pagination<OldSketchResp> queryByPage(
        OldSketchReq pageReq);


    /**
    * 更新
    * @author: create by singer - Singer email:singer-coder@qq.com
    * @date 2021/4/2
    * @param updateReq 更新请求参数
    */
    void updateItem(OldSketchUpdateReq updateReq);

}
