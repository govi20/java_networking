package com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionExample {

    public static void main(String[] args) {
        readFromServer ("http://www.bing.com"); // who else will use bing search ;-)
        readHeaders ("http://www.dnaindia.com");
    }

    public static URLConnection getURLConnection(String host) {
        URLConnection urlConnection = null;
        try {
            URL url = new URL (host);
            urlConnection = url.openConnection ();

        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return urlConnection;
    }

    /*
    * Reads Raw DOM string.
    */
    public static void readFromServer(String host) {
        try {
            URLConnection urlConnection = getURLConnection (host);
            InputStream inputStream = urlConnection.getInputStream ();
            int ch = 0;
            while ((ch = inputStream.read ()) != -1) {
                System.out.print ((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    /*
    * As obvious as it suggests. Read http headers.
    */
    public static void readHeaders(String host) {
        try {
            URLConnection urlConnection = getURLConnection (host);
            long lastModified = urlConnection.getLastModified ();
            Date date = new Date(lastModified);
            String contentType = urlConnection.getHeaderField ("content-type"); // in case custom header need to access
            System.out.println ("last modified => "+ date);
            System.out.println (contentType);
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
}
