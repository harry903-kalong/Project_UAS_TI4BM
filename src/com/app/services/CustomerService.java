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
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class CustomerService extends BaseService {

    public CustomerService() {
        baseUrl = "customers";
    }

    public PageResult<Customers> getPage(int page, int pageSize, String sort, boolean asc) throws MalformedURLException, ProtocolException, IOException {

        PageResult<Customers> result = null;
        List<Customers> list = new ArrayList<>();
        JSONObject obj = get(page, pageSize, sort, asc);
        JSONObject data = obj.optJSONObject("data");
        JSONArray content = data.optJSONArray("content");
        content.forEach(item -> {
            JSONObject cus = (JSONObject) item;
            Customers customers = new Customers(cus);
            list.add(customers);
        });
        int totalElements = data.optInt("totalElements", 0);
        int totalPages = data.optInt("totalPages", 0);
        boolean first = data.optBoolean("first", false);
        boolean last = data.optBoolean("last", false);
        result = new PageResult<>(list, totalElements, totalPages, first, last);
        return result;
    }
    
    public Customers getByID(String id) throws IOException{
        Customers customers = null;
        JSONObject obj = get(id);
        JSONObject cus = obj.optJSONObject("data");
        customers = new Customers(cus);
        return customers;
    }
}
