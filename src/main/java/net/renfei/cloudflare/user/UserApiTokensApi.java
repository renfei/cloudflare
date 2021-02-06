package net.renfei.cloudflare.user;

import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.CloudflareException;
import net.renfei.cloudflare.CloudflareInterface;
import net.renfei.cloudflare.entity.*;
import net.renfei.sdk.http.HttpRequest;
import net.renfei.sdk.utils.HttpUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserApiTokensApi</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class UserApiTokensApi extends CloudflareInterface {
    private UserApiTokensApi() {
    }

    public UserApiTokensApi(String apiToken) {
        API_TOKEN = apiToken;
    }

    public List<UserApiTokens> getListTokens(Map<String, Object> paramMap) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens");
        request.pathParam(paramMap);
        return getResultList(HttpUtils.get(request), UserApiTokens.class);
    }

    public UserApiTokens createToken(CreateToken createToken) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens");
        request.json(JSON.toJSONString(createToken));
        return getResult(HttpUtils.post(request), UserApiTokens.class);
    }

    public UserApiTokens getTokenDetails(String tokenId) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens/" + tokenId);
        return getResult(HttpUtils.get(request), UserApiTokens.class);
    }

    public UserApiTokens updateToken(String tokenId, UpdateToken updateToken) throws IOException, CloudflareException {
        updateToken.setId(tokenId);
        HttpRequest request = getRequest("user/tokens/" + tokenId);
        request.json(JSON.toJSONString(updateToken));
        return getResult(HttpUtils.put(request), UserApiTokens.class);
    }

    public Id deleteToken(String tokenId) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens/" + tokenId);
        return getResult(HttpUtils.delete(request), Id.class);
    }

    public String rollToken(String tokenId) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens/" + tokenId + "/value");
        return getResult(HttpUtils.put(request), String.class);
    }

    public VerifyToken verifyToken() throws IOException, CloudflareException {
        HttpRequest request = getRequest("user/tokens/verify");
        return getResult(HttpUtils.get(request), VerifyToken.class);
    }
}
