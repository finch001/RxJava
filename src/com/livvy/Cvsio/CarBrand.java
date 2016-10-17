package com.livvy.Cvsio;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class CarBrand {
    public long id;
    public String name;// 品牌名称
    public String coverPath;// 品牌logo图标
    public int hot;// 热度
    public String preName;// 名称首字母

    public CarBrand(long id, String name, String coverPath, int hot, String preName) {
        this.id = id;
        this.name = name;
        this.coverPath = coverPath;
        this.hot = hot;
        this.preName = preName;
    }
}
