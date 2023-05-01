package cn.age.service.impl;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.common.constants.BaseConstant;
import cn.age.common.redis.RedisRepository;
import cn.age.common.utils.common.CheckParam;
import cn.age.repository.result.BusinessDictResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.service.impl
 * @Description: excel数据导入处理实现类
 * @date 2021-04-22
 */
@Service("excelDictHandler")
@Slf4j
public class ExcelDictHandlerImpl implements IExcelDictHandler {


    @Resource
    private BaseConstant baseConstant;

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private RedisRepository redisRepository;

    /**
      * 数据字典值为key的Map
      */
    ConcurrentHashMap<String, BusinessDictResult> dictValueKeyMap = new ConcurrentHashMap<>();

    /**
     * 数据字典键为key的Map
     */
    ConcurrentHashMap<String,BusinessDictResult> dictKeyMap = new ConcurrentHashMap<>();

    /**
     * 拿到数据字典集合
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/4/22
     * @param dict 字典
     * @return List<Map>
     */
    @Override
    public List<Map> getList(String dict) {
        return null;
    }


    /**
      * 初始化数据字典
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/4/23
      */
    public void initAllDict() {


    }

    /**
      * 字典值转换为名字
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/4/22
      * @param dict 字典值
      * @param obj obj
      * @param name name名称
      * @param value 值
      * @return
      */
    @Override
    public String toName(String dict, Object obj, String name, Object value) {
        initAllDict();
        if("regionId".equals(dict)){
            log.info("regionId");
        }
        if("nationalIndustryType".equals(dict)){
            log.info("nationalIndustryType");
        }
        if("regionId".equals(dict)){
            log.info("regionId");
        }
        BusinessDictResult businessDictResult = dictKeyMap.get(value);

        if(!CheckParam.isNull(businessDictResult)){
            log.info(">>>>>>>>>>>>>>>>>>>>导入数据的时候定位出来的数据字典: {} <<<<<<<<<<<<<<<<<<<<",JSON.toJSONString(businessDictResult));
            return businessDictResult.getDictValue();
        }else{
            return "无";
        }
    }


    /**
      * 名字转换为字典值
      * @author: create by singer - Singer email:singer-coder@qq.com
      * @date 2021/4/22
      * @param dict 字典值 此处是导入的值
      * @param obj obj
      * @param name name名称
      * @param value 值
      * @return
      */
    @Override
    public String toValue(String dict, Object obj, String name, Object value) {
        initAllDict();
        log.info(dict);
        if("regionId".equals(dict)){
            log.info("regionId");
        }
        if("nationalIndustryType".equals(dict)){
            log.info("nationalIndustryType");
        }
        if("regionId".equals(dict)){
            log.info("regionId");
        }

        if(CheckParam.isNull(value)){
            return null;
        }

        BusinessDictResult businessDictResult = dictValueKeyMap.get(value);

        if(!CheckParam.isNull(businessDictResult)){
            log.info(">>>>>>>>>>>>>>>>>>>>导入数据的时候定位出来的数据字典: {} <<<<<<<<<<<<<<<<<<<<",JSON.toJSONString(businessDictResult));
            return businessDictResult.getBusinessDictionaryId();
        }else{
            return "无";
        }
    }
}
