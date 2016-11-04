package com.livvy.Rxjava.RxAndroid;

/**
 * Created by Finch on 2016/10/25 0025.
 */
public class AppInfo implements Comparable<Object>
{
    long lastUpdateTime;
    String name;
    String icon;


    public AppInfo(long lastUpdateTime, String name, String icon)
    {
        this.lastUpdateTime = lastUpdateTime;
        this.name = name;
        this.icon = icon;
    }


    @Override
    public int compareTo(Object o)
    {
        AppInfo info = (AppInfo)o;
        return info.name.compareTo(name);
    }
}
