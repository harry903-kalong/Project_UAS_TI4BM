/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import com.app.commons.Constant;
import com.app.entity.Customers;
import com.app.entity.PageResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class BaseService {

    String baseUrl;

    public JSONObject get(int page, int pageSize) throws MalformedURLException, IOException {
        JSONObject result = null;
        String pathUrl = Constant.BASE_URL + baseUrl + "?page=" + page + "&pageSize=" + pageSize;
        System.out.println("pathUrl" + pathUrl);
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        if (status == 200) {
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            result = new JSONObject(sb.toString());            
            in.close();
            br.close();
        }
        return result;
    }
    
    public JSONObject get(Object id) throws MalformedURLException, IOException {
        JSONObject result = null;
        String pathUrl = Constant.BASE_URL + baseUrl + "/" +id.toString();
        System.out.println("pathUrl: " + pathUrl);
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        if (status == 200) {
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("result " + sb.toString());
            result = new JSONObject(sb.toString());            
            in.close();
            br.close();
        }
        return result;
    }
    
}
