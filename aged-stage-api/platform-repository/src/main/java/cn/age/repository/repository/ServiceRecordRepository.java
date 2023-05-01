package cn.age.repository.repository;
import cn.age.common.config.BaseRepository;
import cn.age.repository.entity.ServiceRecord;
import cn.age.repository.result.UserSketchResult;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
* @author Singer create by singer email:singer-coder@qq.com
* @packageName cn.singer.repository.entity
* @Description: 事故记录->Repository
* @date 2019-08-12
*/
@Mapper
public interface ServiceRecordRepository extends BaseRepository<ServiceRecord> {



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
        " UPDATE service_record item set item.delete_status = #{deleteStatus} " +
        " WHERE item.service_record_id IN " +
        " <foreach collection='mainIdList' item= 'item' index= 'index' open='(' separator=',' close=')' > " +
        "          #{item} " +
        " </foreach>" +
        "</script>")
    void batchUpdateDeleteStatus(@Param("deleteStatus") Integer deleteStatus,
    @Param("mainIdList") List<String> mainIdList);


    @Select( "<script>"
            + " SELECT " +
            " record.service_record_id serviceRecordId, "+
            " record.old_sketch_id oldSketchId, "+
            " record.other_sketch otherSketch, "+
            " record.start_time startTime, "+
            " record.status status, "+
            " record.duration duration, "+
            "FROM " +
            " service_record record " +
            " LEFT JOIN se_template_service temp ON record.temp_id = temp.service_template_id " +
            " left join auth_user user on record.auth_user_id = user.auth_user_id "+
            "WHERE " +
            " AND record.delete_status = #{deleteStatus}  " +
            "</script>"
    )
    @Results(
            {
                    @Result(column = "realName", property = "realName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "authUserId", property = "authUserId", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "roleCode", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            }
    )
    @Options(useCache = true)
    List<UserSketchResult> queryServiceInfo(@Param("deleteStatus") Integer deleteStatus,
                                                 @Param("roleCode") String roleCode);

}
