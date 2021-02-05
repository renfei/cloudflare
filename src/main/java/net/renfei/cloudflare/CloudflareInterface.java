package net.renfei.cloudflare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.renfei.sdk.http.HttpEntityType;
import net.renfei.sdk.http.HttpRequest;
import net.renfei.sdk.http.HttpResult;

import java.util.HashMap;
import java.util.List;

/**
 * <p>Title: CloudflareInterface</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public abstract class CloudflareInterface {
    protected final static String ENDPOINTS = "https://api.cloudflare.com/client/v4/";
    protected final static String AUTHORIZATION = "Authorization";
    protected static String API_TOKEN;

    protected HttpRequest getRequest(String api) {
        HttpRequest request = HttpRequest.create().url(ENDPOINTS + api).useSSL();
        request.headers(new HashMap<>(1));
        request.addHeader(AUTHORIZATION, "Bearer " + API_TOKEN);
        request.httpEntityType(HttpEntityType.ENTITY_STRING);
        request.addHeader("Content-Type", "application/json; charset=utf-8");
        request.addHeader("Accept", "application/json");
        return request;
    }

    protected <T> T getResult(HttpResult result, Class<T> clazz) throws CloudflareException {
        JSONObject jsonObject = JSON.parseObject(result.getResponseText());
        if (jsonObject.getBoolean("success")) {
            return jsonObject.getObject("result", clazz);
        } else {
            JSONArray jsonArray = jsonObject.getJSONArray("errors");
            if (jsonArray.size() > 0) {
                throw new CloudflareException(jsonArray.getJSONObject(0).getString("code"), "Error",
                        jsonArray.getJSONObject(0).getString("message"));
            } else {
                throw new CloudflareException("500", "Error", "Unknown unexpected error.");
            }
        }
    }

    protected <T> List<T> getResultList(HttpResult result, Class<T> clazz) throws CloudflareException {
        JSONObject jsonObject = JSON.parseObject(result.getResponseText());
        if (jsonObject.getBoolean("success")) {
            return JSON.parseArray(JSON.toJSONString(jsonObject.getJSONArray("result")), clazz);
        } else {
            JSONArray jsonArray = jsonObject.getJSONArray("errors");
            if (jsonArray.size() > 0) {
                throw new CloudflareException(jsonArray.getJSONObject(0).getString("code"), "Error",
                        jsonArray.getJSONObject(0).getString("message"));
            } else {
                throw new CloudflareException("500", "Error", "Unknown unexpected error.");
            }
        }
    }
}
