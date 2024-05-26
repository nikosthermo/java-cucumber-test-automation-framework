package com.saucedemo.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestDataUtil {

    private static Map<String, Map<String, String>> credentialsMap;

    static {
        try {
            InputStream inputStream = TestDataUtil.class.getClassLoader().getResourceAsStream("testData/credentials.json");
            if (inputStream == null) {
                throw new RuntimeException("Cannot find credentials.json");
            }
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject jsonObject = new JSONObject(tokener);
            credentialsMap = new HashMap<>();
            for (String key : jsonObject.keySet()) {
                JSONObject credentials = jsonObject.getJSONObject(key);
                Map<String, String> credentialsInfo = new HashMap<>();
                credentialsInfo.put("username", credentials.getString("username"));
                credentialsInfo.put("password", credentials.getString("password"));
                credentialsMap.put(key, credentialsInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data");
        }
    }

    public static Map<String, String> getCredentials(String userType) {
        return credentialsMap.get(userType);
    }
}
