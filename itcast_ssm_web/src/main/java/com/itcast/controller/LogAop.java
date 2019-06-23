package com.itcast.controller;

import com.itcast.domain.SysLog;
import com.itcast.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private  SysLogService sysLogService;

    @Around("execution(* com.itcast.controller.*.*(..))")
    public Object recodLog(ProceedingJoinPoint pjp ) throws Throwable {
        SysLog sysLog = new SysLog();
        //访问时间
        long visitTime = System.currentTimeMillis();
        sysLog.setVisitTime(new Date(visitTime));
        //操作用户
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLog.setUsername(user.getUsername());
       //访问ip
       sysLog.setIp(request.getRemoteAddr());
        //url
        sysLog.setUrl(request.getRequestURI());
        //方法执行时长
        Object result = pjp.proceed();
        sysLog.setExecutionTime(System.currentTimeMillis()-visitTime);
        //访问类名+方法名
        String className=pjp.getTarget().getClass().getName();
        String methodName=pjp.getSignature().getName();
        sysLog.setMethod("【类名】"+className+"【方法名】"+methodName);
        //保存日志
        sysLogService.save(sysLog);
        return result;
    }
}
