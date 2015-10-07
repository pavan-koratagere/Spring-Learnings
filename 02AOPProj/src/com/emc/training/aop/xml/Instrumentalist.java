package com.emc.training.aop.xml;

import java.text.MessageFormat;

public class Instrumentalist
{
    public void play()
    {
        System.out.println("Playing the instrument");
    }

    public void play(int time)
    {
        System.out.println(MessageFormat.format("Playing the instrument {0} times", time));
    }

    public void play(String song)
    {
        System.out.println(MessageFormat.format("Playing {0} using the instrument", song));
        throw new RuntimeException("instrument broken");
    }
}
