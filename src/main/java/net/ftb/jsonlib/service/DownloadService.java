package net.ftb.jsonlib.service;

import net.ftb.jsonlib.utils.DownloadUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by progwml6 on 5/30/15.
 */
//TODO move this to use the repo once we start pushing pack jsons there
public class DownloadService {
    private static String APIJSON = "http://api.feed-the-beast.com/ss/api/JSON/";
    private static String APIPACK = "pack/";
    private static String APITP = "tp/";
    private static String APIMAP = "map/";

    public static String getPackJson(String code) throws MalformedURLException, IOException{
        return DownloadUtils.getStringFromURL(APIJSON + APIPACK + code);
    }
    public static String getMapJson(String code) throws MalformedURLException, IOException{
        return DownloadUtils.getStringFromURL(APIJSON + APITP + code);
    }
    public static String getTpJson(String code) throws MalformedURLException, IOException{
        return DownloadUtils.getStringFromURL(APIJSON + APIMAP + code);
    }

}
