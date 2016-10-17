package com.livvy.Cvsio;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class CarSeries {
    public long id;
    public CarBrand carBrand;
    public String name;


    public CarSeries(long id, CarBrand carBrand, String name) {
        this.id = id;
        this.carBrand = carBrand;
        this.name = name;
    }

    public CarSeries() {

    }

    @Override
    public String toString() {
        return "CarSeries{" +
                "id=" + id +
                ", carBrand=" + carBrand +
                ", name='" + name + '\'' +
                '}';
    }
}
