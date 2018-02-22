package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOFile {
    public static void writeFile(String fileName, int length) {
        File file = null;
        FileOutputStream fo = null;
        String str = "";
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fo = new FileOutputStream(file);
            long start = System.currentTimeMillis();
            for (int i = 0; i < length; i++) {
                str = "Create a String,The number is " + (i + 1) + "\n";
                fo.write(str.getBytes());
            }
            long end = System.currentTimeMillis();
            System.out.println("IO 写文件" + length + "行,共消耗:" + (end - start) + "毫秒.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFile(String fileName) {
        File file = null;
        FileInputStream fi = null;
        InputStreamReader inputReader = null;
        BufferedReader bufferReader = null;
        String str = "";
        long length = 0;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                return;
            }
            fi = new FileInputStream(file);
            inputReader = new InputStreamReader(fi);
            bufferReader = new BufferedReader(inputReader);

            long start = System.currentTimeMillis();

            while ((str = bufferReader.readLine()) != null) {
                length++;
                if (length % 1000000 == 0) {
                    System.out.println(str);
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("IO 读文件,共消耗:" + (end - start) + "毫秒.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFile(String currFileName, String newFileName) {
        FileOutputStream fo = null;
        FileInputStream fi = null;
        File currFile = null;
        File newFile = null;
        try {
            currFile = new File(currFileName);
            newFile = new File(newFileName);
            if (!currFile.exists()) {
                return;
            }
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            fi = new FileInputStream(currFile);
            fo = new FileOutputStream(newFile);
            
            int temp = -1;
            
            long start = System.currentTimeMillis();
            while ((temp = fi.read()) != -1) {
                fo.write(temp);
            }

            long end = System.currentTimeMillis();
            System.out.println("IO 拷贝文件,共消耗:" + (end - start) + "毫秒.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fo != null) {
                    fo.close();
                }
                if (fi != null) {
                    fi.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        writeFile("D:\\testIO.txt", 30000);
//        readFile("D:\\testIO.txt");
//        copyFile("D:\\testIO.txt", "D:\\testIONew.txt");
    }
}
