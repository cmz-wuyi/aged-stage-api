package cn.age.repository.repository;
import cn.age.common.config.BaseRepository;
import cn.age.repository.entity.OldSketch;
import cn.age.repository.entity.TemplateService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 服务模板配置Repository
 */
@Mapper
public interface TemplateServiceRepository extends BaseRepository<TemplateService> {


    /**
     *
     * @param deleteStatus
     * @param mainIdList
     */
    @Update(
        "<script>" +
        " UPDATE se_template_service item set item.delete_status = #{deleteStatus} " +
        " WHERE item.service_template_id IN " +
        " <foreach collection='mainIdList' item= 'item' index= 'index' open='(' separator=',' close=')' > " +
        "          #{item} " +
        " </foreach>" +
        "</script>")
    void batchUpdateDeleteStatus(@Param("deleteStatus") Integer deleteStatus,
    @Param("mainIdList") List<String> mainIdList);

}
