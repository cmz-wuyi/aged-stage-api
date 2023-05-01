package cn.age.repository.entity;

import cn.age.common.entity.BaseEntity;
import cn.age.common.utils.spring.SnowflakeIdWorker;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.*;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @packageName cn.singer.repository.entity
 * @Description: 系统用户简略信息实体
 * @date 2019-08-12
 */
@Table(name = "auth_user_sketch")
@Entity
@Data
public class AuthUserSketch extends BaseEntity implements Serializable  {

	private static final long serialVersionUID = 8029128115213306675L;

	/**
	 * 业务主键ID
 	 */
	@Column(name = "auth_user_sketch_id")
	private String  authUserSketchId = SnowflakeIdWorker.uniqueSequenceStr();

	/**
	 * 用户业务主键ID
 	 */
	@Column(name = "auth_user_id")
	private String  authUserId;

	/**
	 * 性别，跟随枚举
	 */
	@Column(name = "gender")
	private String gender;

	/**
	 * 年龄
	 */
	@Column(name = "age")
	private Integer age;

	/**
	 * 联系地址
	 */
	@Column(name = "address")
	private String address;

}
