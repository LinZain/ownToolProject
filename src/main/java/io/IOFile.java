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
//            int y = 18;
//            str = "INSERT INTO userdb.user_basic (user_name, user_number, id_number, user_type, pinyin, py, post, sex, v_face, phone, mobile, short_number, terminal, password, IMEI, IMEI2, MEID, iccid, enabled, state, create_time, version, party_id, p_org_id, org_id, org_code, c_org_id, l_org_id, expired_date) VALUES \n";
//            fo.write(str.getBytes());
//            for (long j = 1; j < 11; j++) {
//                for (long i = 1; i < 101; i++) {
//                    str = "('民警" + (1100000L + 100000L * y + +(1000L * j) + i) + "', '" + (1100000L + 100000L * y + +(1000L * j) + i )+ "', '" + (1100000000000000l + (100000l * y) + (1000l * j) + i) + "', 1, NULL, NULL, NULL, 1, 0, '" + (13100000000L + (100000L * y) + (1000L * j) + i) + "', NULL, NULL, NULL, '9db06bcff9248837f86d1a6bcf41c9e7', NULL, NULL, NULL, NULL, 0, 1, '2019-04-18 09:28:15.000', 1555550895691, 1, " + (200l + y) + ", " + (210l + (10l * y) + j) + ", '" + "00000" + (1007000l + (1000 * y) + j) + "', " + (210l + (10l * y) + j) + ", " + (210l + (10l * y) + j) + ", NULL),\n";
//                    fo.write(str.getBytes());
//                }
//            }
            int y = 20;
            long count = 0;
            fo.write(str.getBytes());
            for (long j = 1; j < 11; j++) {
                for (long i = 1; i < 101; i++) {
                    count++;
                    str = "update userdb.user_basic set user_number ='" + (21000000L + 100000L * y + +(1000L * j) + i ) + "' where uid = " + (3100000l + count) + ";\n";
//                    str = "('民警" + (1100000L + 100000L * y + +(1000L * j) + i) + "', '" + (1100000L + 100000L * y + +(1000L * j) + i )+ "', '" + (1100000000000000l + (100000l * y) + (1000l * j) + i) + "', 1, NULL, NULL, NULL, 1, 0, '" + (13100000000L + (100000L * y) + (1000L * j) + i) + "', NULL, NULL, NULL, '9db06bcff9248837f86d1a6bcf41c9e7', NULL, NULL, NULL, NULL, 0, 1, '2019-04-18 09:28:15.000', 1555550895691, 1, " + (200l + y) + ", " + (210l + (10l * y) + j) + ", '" + "00000" + (1007000l + (1000 * y) + j) + "', " + (210l + (10l * y) + j) + ", " + (210l + (10l * y) + j) + ", NULL),\n";
                    fo.write(str.getBytes());
                }
            }
//            for(long y=2;y<21;y++) {
//                for (long j = 1; j < 11; j++) {
//                    str = "INSERT INTO userdb.user_basic (user_name, user_number, id_number, user_type, pinyin, py, post, sex, v_face, phone, mobile, short_number, terminal, password, IMEI, IMEI2, MEID, iccid, enabled, state, create_time, version, party_id, p_org_id, org_id, org_code, c_org_id, l_org_id, expired_date) VALUES \n";
//                    fo.write(str.getBytes());
//                    for (long i = 1; i < 401; i++) {
//                        str = "('罪犯" + (2100000L + 100000L * y + +(1000L * j) + i) + "', '" + (2100000L + 100000L * y + +(1000L * j) + i) + "', '" + (2100000000000000l + (100000l * y) + (1000l * j) + i) + "', 1, NULL, NULL, NULL, 1, 0, '" + (13200000000L + (100000L * y) + (1000L * j) + i) + "', NULL, NULL, NULL, '9db06bcff9248837f86d1a6bcf41c9e7', NULL, NULL, NULL, NULL, 0, 1, '2019-04-18 09:28:15.000', 1555550895691, 1, " + (200l + y) + ", " + (210l + (10l * y) + j) + ", '" + "00000" + (1007000l + (1000 * y) + j) + "', " + (210l + (10l * y) + j) + ", " + (210l + (10l * y) + j) + ", NULL)";
//                        if (i != 400) {
//                            str += ",\n";
//                        } else {
//                            str += ";\n";
//                        }
//                        fo.write(str.getBytes());
//                    }
//                }
//            }
//            int count = 0;
//            for(long y=1;y<21;y++) {
//                for (long j = 1; j < 11; j++) {
//                    str = "INSERT INTO userdb.user_criminal (uid, birthday, prison_term, enter_date, score, reason, focus_type, criminal_state, remark, state, create_time, update_time, version, party_id, org_id, org_code, p_org_id) VALUES \n";
//                    fo.write(str.getBytes());
//                    for (long i = 1; i < 401; i++) {
//                        count++;
//                        str = "("+  (3120000L + count) +", '2000-01-01 00:00:00', '10-0', '2000-01-01 00:00:00.000', 0, '原因', 0, 1, NULL, 1, '2019-04-18 09:22:23.000', NULL, 0, 1,  " + (210l + (10l * y) + j) + ", '" + "00000" + (1007000l + (1000 * y) + j) + "', " + (210l + (10l * y) + j) + ")";
//                        if (i != 400) {
//                            str += ",\n";
//                        } else {
//                            str += ";\n";
//                        }
//                        fo.write(str.getBytes());
//                    }
//                }
//            }
            long end = System.currentTimeMillis();
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
            System.out.println("IO ���ļ�,������:" + (end - start) + "����.");
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
            System.out.println("IO �����ļ�,������:" + (end - start) + "����.");
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
        writeFile("/Users/zain/Desktop/batch.sql", 30000);
//        readFile("D:\\testIO.txt");
//        copyFile("D:\\testIO.txt", "D:\\testIONew.txt");
    }
}
