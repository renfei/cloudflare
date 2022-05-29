/*
 *   Copyright 2022 RenFei(i@renfei.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.renfei.cloudflare.service;

import com.google.gson.Gson;
import net.renfei.cloudflare.api.Common;
import net.renfei.cloudflare.entity.common.ApiKey;
import net.renfei.cloudflare.entity.common.ApiToken;
import net.renfei.cloudflare.entity.common.AuthTypeEnum;
import net.renfei.cloudflare.entity.common.UserServiceKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestFulClient
 *
 * @author renfei
 */
public class RestFulClient {
    private final ApiKey apiKey;
    private final ApiToken apiToken;
    private final UserServiceKey userServiceKey;
    private final AuthTypeEnum authTypeEnum;

    private RestFulClient() {
        this.apiKey = null;
        this.apiToken = null;
        this.userServiceKey = null;
        this.authTypeEnum = null;
        throw new RuntimeException("Illegal instantiation.");
    }

    public RestFulClient(ApiKey apiKey) {
        this.apiKey = apiKey;
        this.apiToken = null;
        this.userServiceKey = null;
        this.authTypeEnum = AuthTypeEnum.API_KEY;
    }

    public RestFulClient(ApiToken apiToken) {
        this.apiKey = null;
        this.apiToken = apiToken;
        this.userServiceKey = null;
        this.authTypeEnum = AuthTypeEnum.API_TOKEN;
    }

    public RestFulClient(UserServiceKey userServiceKey) {
        this.apiKey = null;
        this.apiToken = null;
        this.userServiceKey = userServiceKey;
        this.authTypeEnum = AuthTypeEnum.USER_SERVICE_KEY;
    }

    public <T> T request(String endpoint, String method, Object data, Type type) throws IOException {
        allowMethods("PATCH");
        URL url = new URL(Common.ENDPOINT + endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod(method);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json");
        switch (Objects.requireNonNull(authTypeEnum)) {
            case API_TOKEN:
                assert apiToken != null;
                conn.setRequestProperty("Authorization", "Bearer " + apiToken.getToken());
                break;
            case API_KEY:
                assert apiKey != null;
                conn.setRequestProperty("X-Auth-Key", apiKey.getApiKey());
                conn.setRequestProperty("X-Auth-Email", apiKey.getEmail());
                break;
            case USER_SERVICE_KEY:
                assert userServiceKey != null;
                conn.setRequestProperty("X-Auth-User-Service-Key", userServiceKey.getUserServiceKey());
                break;
            default:
                throw new RuntimeException("Auth Type Error.");
        }
        if (data != null) {
            String json = new Gson().toJson(data);
            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = conn.getOutputStream();
            stream.write(out);
        }
        StringBuilder stringBuilder;
        if (conn.getResponseCode() != 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getErrorStream())));
            stringBuilder = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                stringBuilder.append(output);
            }
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            stringBuilder = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                stringBuilder.append(output);
            }
        }
        conn.disconnect();
        return new Gson().fromJson(stringBuilder.toString(), type);
    }

    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/*static field*/, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
