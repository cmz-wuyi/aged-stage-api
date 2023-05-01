package cn.age.service;


import cn.age.interaction.req.TemplateServiceAddReq;
import cn.age.interaction.req.TemplateServiceReq;
import cn.age.interaction.req.TemplateServiceUpdateReq;
import cn.age.interaction.resp.OldSketchResp;
import cn.age.interaction.resp.TemplateServiceResp;
import cn.age.interaction.resp.page.Pagination;

import java.util.List;

/**
*
*/
public interface TemplateServiceService {

    void addItem(TemplateServiceAddReq addReq);

    Pagination<TemplateServiceResp> queryByPage(TemplateServiceReq pageReq);

    void batchDeleteItem(List<String> asList);

    void updateItem(TemplateServiceUpdateReq updateReq);

    List<TemplateServiceResp> allServiceSketch();
}
