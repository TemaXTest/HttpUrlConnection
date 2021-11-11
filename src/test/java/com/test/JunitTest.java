package com.test;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import org.junit.jupiter.api.Test;

public class JunitTest extends BaseUrl {
    String first = "qwerty";
    String last = "string";
    String three = "gripp";
    String four = "hunter";

    @Test
    public void createUser() throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("firstName",first);
        connection.setRequestProperty("lastName", last);
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);

//        InputStream responseStream = connection.getInputStream();

    }
    @Test
    public void firstCreate() throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("firstName", three);
        connection.setRequestProperty("lastName","-");
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);

    }

    @Test
    public void lastCreate() throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("firstName", "-");
        connection.setRequestProperty("lastName", four);
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);

    }
    @Test
    public void emptyCreate() throws IOException {
        URL url = new URL (baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("firstName", "-");
        connection.setRequestProperty("lastName", "-");
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);

    }

    @Test
    public void delUser() throws IOException {
        URL url = new URL(baseUrl + "/2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);

    }

    @Test
    public void putAll() throws IOException {
        URL url = new URL(baseUrl + "/3?restletMethods=PUT");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("firstName", "PUTTY1" + first);
        connection.setRequestProperty("lastName", "-" + three);
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);
    }

    @Test
    public void putFirst() throws IOException {
        URL url = new URL(baseUrl + "/3?restletMethods=PUT");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("firstName", "PUTTY1" + last);
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);
    }
    @Test
    public void putLast() throws IOException {
        URL url = new URL(baseUrl + "/3?restletMethods=PUT");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("lastName", "PUTTY2" + four);
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);
    }
    @Test
    public void getUsers() throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        Assertions.assertTrue(responseCode <=200);
        InputStream in = connection.getInputStream();
        String encoding = connection.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String body = IOUtils.toString(in, encoding);
        System.out.println(body);
    }
}
