package cn.age.common.config;

import tk.mybatis.mapper.common.*;

/**
 * 继承通用的mapper，关键点就是这个接口不能被扫描到，不能跟dao这个存放mapper文件放在一起。

 * @description
 */
public interface BaseRepository <T> extends Mapper<T>, BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>,ExampleMapper<T> {












}
