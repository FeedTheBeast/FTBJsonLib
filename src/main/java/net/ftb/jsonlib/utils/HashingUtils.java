package net.ftb.jsonlib.utils;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by progwml6 on 6/1/15.
 */
public class HashingUtils {

    /**
     * Gets the md5 of the downloaded file
     * pulled from FTB Launcher
     * @param file - File to check
     * @return - string of file's md5
     * @throws IOException if io error occurs
     */
    public static String fileMD5 (File file) throws IOException {
        if (file.exists()) {
            return Files.hash(file, Hashing.md5()).toString();
        } else {
            return "";
        }
    }

    /**
     * Gets the sha1 of the downloaded file
     * pulled from FTB Launcher
     * @param file - File to check
     * @return - string of file's sha1
     * @throws IOException if io error occurs
     */
    public static String fileSHA (File file) throws IOException {
        if (file.exists()) {
            return Files.hash(file, Hashing.sha1()).toString();
        } else {
            return "";
        }
    }

}
