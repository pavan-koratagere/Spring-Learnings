package com.emc.training.aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Hariprasad Manchi
 */
@Component
@Aspect
public class AddOnBehavior
{
    @Around("execution (* com.emc.training.aop.around.MyNumber.add(int, int))")
    public Object additionalBehavior(ProceedingJoinPoint joinPoint)
    {
        Object returnValue = null;
        System.out.println("invoking the proxy");
        Object[] args = joinPoint.getArgs();

        int first = (Integer) args[0];
        int second = (Integer) args[1];

        try
        {
            returnValue = joinPoint.proceed(new Object[] { first * first, second * second });
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
}
