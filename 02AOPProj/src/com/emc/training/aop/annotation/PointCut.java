package com.emc.training.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCut
{
    // target is used to specify the class and used to invoke all the methods
    // target(com.emc.training.aop.xml.Instrumentalist)
    // @Pointcut("execution (* com.emc.training.aop.annotation.Instrumentalist.play(..))")
    @Pointcut("target (com.emc.training.aop.annotation.Instrumentalist)")
    public void instrumentalistPointCut()
    {
    }
}
