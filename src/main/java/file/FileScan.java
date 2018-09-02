package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FileScan {

    private static ArrayList<Object> scanFiles = new ArrayList<Object>();

    private static long lineCount = 0L;

    public static void main(String args[]) {
        String folderPath = "D:\\work\\edpos\\amap";
        String suffix = "js";

        System.out.println("fileCount:" + scanFilesWithRecursion(folderPath, suffix).size());
        System.out.println("lineCount:" + lineCount);
        System.exit(0);
    }

    public static ArrayList<Object> scanFilesWithRecursion(String folderPath, String suffix) {
        ArrayList<String> dirctorys = new ArrayList<String>();
        File directory = new File(folderPath);
        if (directory.isDirectory()) {
            File[] filelist = directory.listFiles();
            for (int i = 0; i < filelist.length; i++) {
                String fileName = filelist[i].getName();

                if (filelist[i].isDirectory()) {
                    dirctorys.add(filelist[i].getAbsolutePath());
                    /**递归扫描下面的文件夹**/
                    scanFilesWithRecursion(filelist[i].getAbsolutePath(), suffix);
                }
                /**非文件夹**/
                else {
                    if (null != suffix) {
                        if (fileName.endsWith(suffix)) {
                            scanFiles.add(filelist[i].getAbsolutePath());
                            lineCount += getLineCount(filelist[i].getAbsolutePath());
                        }
                    } else {
                        scanFiles.add(filelist[i].getAbsolutePath());
                        lineCount += getLineCount(filelist[i].getAbsolutePath());
                    }
                }
            }
        }
        return scanFiles;
    }

    public static long getLineCount(String path) {
        int cnt = 0;
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(path));
            byte[] c = new byte[1024];
            int readChars = 0;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++cnt;
                    }
                }
            }
        } catch (Exception ex) {
            cnt = -1;
            ex.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    }

    public static long getLineCountWithoutNull(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        int count = 0;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String value = br.readLine();
            while (value != null) {
                if (!"".equals(value)) {
                    count++;
                }
                value = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
