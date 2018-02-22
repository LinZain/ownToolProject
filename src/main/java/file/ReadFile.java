package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String fileName = "1421_";
        String oldPath = "D:\\zhaos\\test\\";
        String newPath = "D:\\zhaos\\test\\his2\\";
        try {
            System.out.println(getFileList(newPath, fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] getFileList(String url, String filePerfix){
        File file = new File(url);
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] fileList = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(filePerfix);
            }
        });
        return fileList;
    }
    public static void copyFile(String fileName, String oldPath, String newPath) throws IOException {
        FileInputStream fis = new FileInputStream(oldPath+fileName);
        //2������֮��������µ��ļ�
        FileOutputStream fos = new FileOutputStream(newPath+fileName);
        // 3���Զ��建��������
        byte[] buf = new byte[1024];
        int by = 0;
        
        while ((by = fis.read(buf)) != -1) {
            fos.write(buf, 0, by);
        }
        fos.close();
        fis.close();
    }

    public static void delFile(String filePathAndName) throws IOException {
        String filePath = filePathAndName;
        File file = new File(filePath);
        if(file.isFile()){
            System.out.println("1");
        }
        if (file.delete()) {
            System.out.println("ɾ�������ļ�" + filePathAndName + "�ɹ���");
        } else {
            System.out.println("ɾ�������ļ�" + filePathAndName + "ʧ�ܣ�");
        }
    }
}
