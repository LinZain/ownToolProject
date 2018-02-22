package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFile {
    public static void writeFile(String fileName, int length) {
        FileOutputStream fo = null;
        FileChannel channel = null;
        String s;
        File file = null;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fo = new FileOutputStream(file);
            channel = fo.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            long start = System.currentTimeMillis();
            for (int i = 0; i < length; i++) {
                byteBuffer.clear();
                s = "Create a String,The number is " + (i + 1) + "\n";
                byteBuffer.put(s.getBytes());
                byteBuffer.flip();
                channel.write(byteBuffer);
            }
            long end = System.currentTimeMillis();
            System.out.println("NIO 写文件" + length + "行,共消耗:" + (end - start) + "毫秒.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        FileInputStream fi = null;
        FileChannel channel = null;
        File file = null;
        String str = "";
        long length = 0;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                return;
            }
            fi = new FileInputStream(file);
            channel = fi.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            long start = System.currentTimeMillis();
            while (channel.read(byteBuffer) != -1) {
                byteBuffer.clear();
                str = new String(byteBuffer.array());
                if (length % 1000000 == 0) {
                    System.out.println(str);
                }
                length++;
            }
            long end = System.currentTimeMillis();
            System.out.println("NIO 读文件,共消耗:" + (end - start) + "毫秒.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        FileChannel outChannel = null;
        FileChannel inChannel = null;
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

            inChannel = fi.getChannel();
            outChannel = fo.getChannel();

            ByteBuffer bf = ByteBuffer.allocate(1024);
            long start = System.currentTimeMillis();
            while (inChannel.read(bf) != -1) {
                bf.flip();
                outChannel.write(bf);
                bf.clear();
            }
            long end = System.currentTimeMillis();
            System.out.println("NIO 拷贝文件,共消耗:" + (end - start) + "毫秒.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outChannel != null) {
                    outChannel.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
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
        writeFile("D:\\testNIO.txt", 30000);
        //        readFile("D:\\testNIO.txt");
//        copyFile("D:\\testNIO.txt", "D:\\testNIONew.txt");
    }
}
