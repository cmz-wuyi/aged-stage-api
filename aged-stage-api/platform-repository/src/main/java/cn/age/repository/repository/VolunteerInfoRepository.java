package cn.age.repository.repository;
import cn.age.common.config.BaseRepository;
import cn.age.repository.entity.VolunteerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Singer create by singer email:singer-coder@qq.com
* @packageName cn.singer.repository.entity
* @Description: 护工薪资->Repository
* @date 2019-08-12
*/
@Mapper
public interface VolunteerInfoRepository extends BaseRepository<VolunteerInfo> {



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
        " UPDATE volunteer_info item set item.delete_status = #{deleteStatus} " +
        " WHERE item.volunteer_info_id IN " +
        " <foreach collection='mainIdList' item= 'item' index= 'index' open='(' separator=',' close=')' > " +
        "          #{item} " +
        " </foreach>" +
        "</script>")
    void batchUpdateDeleteStatus(@Param("deleteStatus") Integer deleteStatus,
    @Param("mainIdList") List<String> mainIdList);

}
