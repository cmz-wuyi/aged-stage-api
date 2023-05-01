package cn.age.api;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;
import cn.age.AgeWebApplication;
import cn.age.common.config.message.MsgCodeConstants;
import cn.age.common.constants.BaseConstant;
import cn.age.common.constants.PlatformConstant;
import cn.age.common.redis.RedisRepository;
import cn.age.common.utils.alibaba.AliMessageSendComponent;
import cn.age.repository.repository.AuthUserRepository;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Singer create by singer email:singer-coder@qq.com
 * @projectName aged-stage-api
 * @Description:
 * @date 2020-06-11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AgeWebApplication.class)
@ActiveProfiles("dev")
@Slf4j
//@Ignore
public class ApiTests {

    @Resource
    private RedisRepository redisRepository;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private BaseConstant baseConstant;

    @Resource
    private AuthUserRepository authUserRepository;

    @Resource
    private AliMessageSendComponent aliMessageSendComponent;

    @Resource
    private PlatformConstant platformConstant;

    @Resource
    private MsgCodeConstants msgCodeConstants;

    @Resource
    private IExcelDictHandler excelDictHandler;

    @Resource
    private MapperFacade mapperFacade;

    public static void main(String[] args) {
        System.out.println(814 + 314.08 + 18.10 + 120);
    }
}
