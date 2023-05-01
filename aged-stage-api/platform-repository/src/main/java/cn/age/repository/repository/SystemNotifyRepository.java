package cn.age.repository.repository;
import cn.age.common.config.BaseRepository;
import cn.age.repository.entity.SystemNotify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 通知类Repository
 */
@Mapper
public interface SystemNotifyRepository extends BaseRepository<SystemNotify> {



    /**
    * 根据业务主键批量删除
    * @title: AuthRoleRepository.java
    * @author create by Singer - Singer email:singer-coder@qq.com
    * @date 2019/4/28 11:05
    * @param mainIdList 业务主键ID集合
    * @param deleteStatus 是否删除 1 删除 2 未删除
    * @return List
    */
    @Update(
        "<script>" +
        " UPDATE old_sketch item set item.delete_status = #{deleteStatus} " +
        " WHERE item.old_sketch_id IN " +
        " <foreach collection='mainIdList' item= 'item' index= 'index' open='(' separator=',' close=')' > " +
        "          #{item} " +
        " </foreach>" +
        "</script>")
    void batchUpdateDeleteStatus(@Param("deleteStatus") Integer deleteStatus,
    @Param("mainIdList") List<String> mainIdList);

}
