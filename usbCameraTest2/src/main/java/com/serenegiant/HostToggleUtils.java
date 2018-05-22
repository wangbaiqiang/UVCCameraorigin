package com.serenegiant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xubingbing on 2018/3/9.
 */

public class HostToggleUtils {

    private static String DEVICE_NODE1 = "/sys/class/leds/usb,load-switch-en2-gpio/brightness";
    private static String DEVICE_NODE2 = "/sys/class/leds/usb,swap-gpio/brightness";

    private static final byte[] HOST = {'1'};
    private static final byte[] DEVICE = {'0'};

    private final byte[] ON = {'2', '5', '5'};
    private final byte[] OFF = {'0'};


    public static void toggle(boolean host) {
        try {
            enableDevice(host, DEVICE_NODE1);
            enableDevice(host, DEVICE_NODE2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isHost() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(DEVICE_NODE1);
            int read = fileInputStream.read();
            if (read == '1') {
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static void enableDevice(boolean enable, String node) throws IOException {
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(node);
        if (enable) {
            fileOutputStream.write(HOST);
        } else {
            fileOutputStream.write(DEVICE);
        }
        fileOutputStream.close();
    }
}
