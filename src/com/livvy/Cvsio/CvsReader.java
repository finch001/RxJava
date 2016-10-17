package com.livvy.Cvsio;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class CvsReader {
    private String carBrandsStr = "D://Java_Code/ddpai_car_brand_series/brand_table.csv";
    private static String carSeriesFile = "D://Java_Code/ddpai_car_brand_series/series_table.csv";


    public HashMap<CarBrand, CarSeries> carMap = new HashMap<>();
    public List<CarBrand> carBrands = new ArrayList<>();
    public static List<CarSeries> carSeries = new ArrayList<>();

    public static void main(String[] args) {
        parseCarBrands(carSeriesFile);
        for (int i = 0; i < carSeries.size(); i++) {
            System.out.println(carSeries.get(i));
        }
    }

    private static void parseCarBrands(String fileUri) {
        File file = new File(fileUri);
        if (!file.exists()) {
            return;
        }

        InputStreamReader fr = null;
        String line = null;
        try {
            fr = new InputStreamReader(new FileInputStream(file), "GBK");
            BufferedReader br = new BufferedReader(fr);
            int index = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(",") && index != 0) {
                    String[] sp = line.split(",");
                    CarSeries cs = new CarSeries();
                    cs.id = Long.parseLong(sp[0]);
                    cs.name = sp[1];
                    long brandId = Long.valueOf(sp[2]);
                    carSeries.add(cs);
                }
                index++;
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
