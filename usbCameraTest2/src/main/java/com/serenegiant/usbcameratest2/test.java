package com.serenegiant.usbcameratest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xubingbing on 2018/4/24.
 */

public class test {

    public static void main(String[] args){

        Runtime runtime = Runtime.getRuntime();
        try {
            final Process process = runtime.exec("adb push xxx.apk  /sdcard/");
            new Thread(){

                @Override
                public void run() {
                    super.run();
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    String lastLine = null;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    try {
                        while ((line = bufferedReader.readLine()) != null) {
                            if (line.equals(lastLine)){

                            }else {
                                System.out.println(line);
                                lastLine = line;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
