package com.livvy.FileSort;

import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2016/11/4 0004.
 */
public class FileSortTime {

    public static void main(String[] args) {
        List<SlowActivity> listActivityInfos = new ArrayList<>();
        File inputFile;
        File outPutFile;
        inputFile = new File("C://Users/Administrator/Desktop/uiTime/openSlowActivity.txt");
        outPutFile = new File("C://Users/Administrator/Desktop/uiTime/SortSlowActivity.txt");
        FileSortTime fileSortTime = new FileSortTime();
        fileSortTime.readFile(inputFile, listActivityInfos);
        fileSortTime.write2File(outPutFile, listActivityInfos);
        fileSortTime.AverageInfo(listActivityInfos);


    }

    private void AverageInfo(List<SlowActivity> listActivityInfos) {
        Map<String, List<SlowActivity>> activityInfo = new HashMap();
        Map<String, Integer> averageMap = new HashMap<>();
        for (SlowActivity activity : listActivityInfos) {
            if (activityInfo.containsKey(activity.ActivityName)) {
                List<SlowActivity> data = activityInfo.get(activity.ActivityName);
                data.add(activity);
            } else {
                List<SlowActivity> data = new ArrayList<>();
                data.add(activity);
                activityInfo.put(activity.ActivityName, data);
            }
        }

        Set activitySet = activityInfo.entrySet();
        Iterator iterator = activitySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<SlowActivity>> Entry = (Map.Entry<String, List<SlowActivity>>) iterator.next();
            List<SlowActivity> slowActivityList = Entry.getValue();
            String activityName = Entry.getKey();
            int averTime = 0;
            for (SlowActivity item : slowActivityList) {
                averTime += item.onStartTime;
            }
            averTime = averTime / slowActivityList.size();
            averageMap.put(activityName, averTime);
        }

        for (String name : averageMap.keySet()) {
            int avergTime = averageMap.get(name);
            System.out.println("Activity name: " + name + "---------" + avergTime);
        }
    }


    public List readFile(File inputFile, List<SlowActivity> listActivityInfos) {
        if (inputFile == null) {
            return Collections.emptyList();
        }
        String line;
        String lineData;
        String date;
        int onstartTime;
        String activityName;
        SlowActivity item;

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            while ((line = bf.readLine()) != null) {
                lineData = line.trim();
                if (lineData.length() == 0) {
                    break;
                }
                date = lineData.substring(lineData.indexOf("["), lineData.lastIndexOf("]") + 1);
                onstartTime = Integer.parseInt(lineData.substring(lineData.indexOf("]") + 1, lineData.indexOf("(")).trim());
                activityName = lineData.substring(lineData.indexOf(")") + 1, lineData.length());
                item = new SlowActivity(date, onstartTime, activityName);
                if (item.onStartTime >= 500) {
                    listActivityInfos.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(listActivityInfos);
        System.out.println("detail_start------------------------");
        for (SlowActivity activityInfo : listActivityInfos) {
            System.out.println(activityInfo.toString());
        }

        System.out.println("detail_end------------------------");

        return listActivityInfos;
    }

    public void write2File(File outPutFile, List<SlowActivity> dataList) {
        FileWriter writer = null;
        try {
            if (!outPutFile.exists()) {
                outPutFile.createNewFile();
            }
            if (dataList == null || dataList.isEmpty()) {
                return;
            }
            writer = new FileWriter(outPutFile, true);
            for (SlowActivity activity : dataList) {
                writer.append(activity.toString() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private class SlowActivity implements Comparable<SlowActivity> {
        private String time;
        private int onStartTime;
        private String ActivityName;

        public SlowActivity(String time, int onStartTime, String activityName) {
            this.time = time;
            this.onStartTime = onStartTime;
            ActivityName = activityName;
        }

        @Override
        public int compareTo(SlowActivity o) {
            if (this.onStartTime > o.onStartTime) {
                return -1;
            } else if (this.onStartTime < o.onStartTime) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "SlowActivity{" +
                    "time='" + time + '\'' +
                    ", onStartTime=" + onStartTime +
                    ", ActivityName='" + ActivityName + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            SlowActivity other = (SlowActivity) obj;
            return other.ActivityName.equals(this.ActivityName);
        }
    }
}
