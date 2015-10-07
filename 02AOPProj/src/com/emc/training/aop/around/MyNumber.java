package com.emc.training.aop.around;

import org.springframework.stereotype.Component;

@Component
/** 
 * pointCuts does not have the knowledge of advices applied on it. This is the only limitation on Spring AOP
 * MyNumber is a PointCut here and AddOnBehavior is the advice applied on it.
 * 
 * @author Hariprasad Manchi
 */
public class MyNumber
{
    public int add(int first, int second)
    {
        return first + second;
    }
}
