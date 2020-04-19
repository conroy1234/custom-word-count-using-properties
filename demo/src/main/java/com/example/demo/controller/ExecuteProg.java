package com.example.demo.controller;
import java.io.*;
public class ExecuteProg {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c",
                    "E:/Softwares/kafka_2.11-2.0.0/bin/windows/zookeeper-server-start.bat",
                    "E:/Softwares/kafka_2.11-2.0.0/config/zookeeper.properties"});
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(" the lines = "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}