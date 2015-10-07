package com.emc.training.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience
{
    @Before("PointCut.instrumentalistPointCut()")
    public void takeSeats()
    {
        System.out.println("Audience taking seats");
    }

    @Before("PointCut.instrumentalistPointCut()")
    public void switchOffMobilePhones()
    {
        System.out.println("audience switching off mobile phones");
    }

    @AfterReturning("PointCut.instrumentalistPointCut()")
    public void applaud()
    {
        System.out.println("audience clapping");
    }

    @AfterThrowing("PointCut.instrumentalistPointCut()")
    public void demandRefund()
    {
        System.out.println("audience demanding for refund");
    }

    @After("PointCut.instrumentalistPointCut()")
    public void returnHome()
    {
        System.out.println("audience returning home");
        System.out.println("------------------------------");
    }
}
