package net.ftb.jsonlib.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by progwml6 on 6/1/15.
 */
public class DownloadUtils {

    public static String getStringFromURL(URL u) throws IOException {
        return IOUtils.toString(u);
    }

    public static String getStringFromURL(String url) throws IOException {
        return getStringFromURL(new URL(url));
    }

}
