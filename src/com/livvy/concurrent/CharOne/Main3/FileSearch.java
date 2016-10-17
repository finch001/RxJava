package com.livvy.concurrent.CharOne.Main3;

import java.io.File;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class FileSearch implements Runnable {
    private String initFile;
    private String targetFile;

    public FileSearch(String initFile, String targetFile) {
        this.initFile = initFile;
        this.targetFile = targetFile;
    }

    @Override
    public void run() {
        File file = new File(initFile);
        if (file.isDirectory()) {
            try {
                processDirectory(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The Search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    private void processDirectory(File file) throws InterruptedException {
        File[] files = file.listFiles();
        System.out.println("Directory: " + file.getName());
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    processDirectory(files[i]);
                } else {
                    processFile(files[i]);
                }

            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void processFile(File file) throws InterruptedException {
        System.out.println("file :  " + file.getName());
        if (file.getName().equals(targetFile)) {
            System.out.println("-----------------------------------------");
            System.out.printf("%s : %s \n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
