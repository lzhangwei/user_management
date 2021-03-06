package com.tw.core.util;

import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static boolean isLogin(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if ("isLogin".equals(cookie.getName())
                    && "login".equals(cookie.getValue())) {
                return true;
            }
        }

        return false;
    }

    public static String getCookieUrl(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if ("previous_page".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public static String encryptPassword(String password) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            password = base64en.encode(messageDigest.digest(password.getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static Date parseStringToDate(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
