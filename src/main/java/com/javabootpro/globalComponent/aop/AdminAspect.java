package com.javabootpro.globalComponent.aop;

import com.javabootpro.appComponent.constant.TokenConstant;
import com.javabootpro.utils.MyStrUtils;
import com.javabootpro.utils.SpringBaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 *  admin 注解 切面类
 */
@Slf4j
@Aspect
@Component
public class AdminAspect {

    //注解的 aop 使用
    // springboot中aop(注解切面)应用 https://blog.csdn.net/feicongcong/article/details/77468345
    // Springboot（二十一）@Aspect 切面注解使用 https://blog.csdn.net/u012326462/article/details/82529835
    @Pointcut("@annotation(com.javabootpro.globalComponent.annotation.Admin)")
    private void cut() {
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        log.info("# LoginCheck Aspect before");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String[] params = methodSignature.getParameterNames();  // 获取参数名称
        Object[] args = joinPoint.getArgs();// 获取参数值
        log.info("方法名: {}", method.getName());
        StringBuilder strBu = new StringBuilder();
        // 会引起空指针
//        for (String str : params
//        ) {
//            log.info("参数: {}", str);
//            strBu.append(str);
//        }
//        for (Object o : args
//        ) {
//            if (o instanceof JSONObject) {
//
//            }
//
//            log.info("传来的值:{}", o.toString());
//        }
        log.info(" getReturnType(): {}", methodSignature.getReturnType());
        log.info(" getParameterTypes(): {}", methodSignature.getParameterTypes());
        log.info(" getName(): {}", methodSignature.getName());
        log.info(" getDeclaringType(): {}", methodSignature.getDeclaringType());
        log.info(" getDeclaringTypeName(): {}", methodSignature.getDeclaringTypeName());

        checkAdmin(); //检查是否是管理员
    }

    private void checkAdmin() {
        // 从http的请求头获取 admin_access_token
        HttpServletRequest request = SpringBaseUtils.getHttpServletRequest();
        try{
            String adminToken = request.getHeader(TokenConstant.ADMIN_ACCESS_TOKEN);
            if (MyStrUtils.isNotEmpty(adminToken)){

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
