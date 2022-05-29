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
package net.renfei.cloudflare;

import com.google.gson.Gson;
import net.renfei.cloudflare.entity.common.ApiKey;
import net.renfei.cloudflare.entity.common.ApiToken;
import net.renfei.cloudflare.entity.common.Response;

/**
 * Junit test
 * use mvn test -Dcloudflare_api_key=examplekey
 *
 * @author renfei
 */
public abstract class Tests {
    protected final Cloudflare cloudflare;
    protected final Cloudflare cloudflareByApiToken;
    protected final Gson gson;
    /**
     * cloudflare api key
     * mvn test -Dcloudflare_api_key=examplekey
     */
    private final static String CLOUDFLARE_API_KEY = System.getProperty("cloudflare_api_key");
    private final static String CLOUDFLARE_API_EMAIL = "example@renfei.net";
    private final static String CLOUDFLARE_API_TOKEN = "your_api_token";
    protected final static String CLOUDFLARE_EXAMPLE_DOMAIN = "examples.cf";
    protected final static String CLOUDFLARE_EXAMPLE_ZONE_ID = "021e07bef243ea32a1bb76f8e12d1f27";
    protected final static String CLOUDFLARE_ACCOUNT_ID = "a402a80c632b9189ee0a83cc298bb082";

    protected Tests() {
        ApiKey apiKey = new ApiKey(CLOUDFLARE_API_KEY, CLOUDFLARE_API_EMAIL);
        this.cloudflare = new Cloudflare(apiKey);
        /**
         * +++++++++++++++++++++++++++++++++++++++++++++++++++
         * |    Or use ApiToken  或者使用 ApiToken
         * +++++++++++++++++++++++++++++++++++++++++++++++++++
         */
        ApiToken apiToken = new ApiToken(CLOUDFLARE_API_TOKEN);
        this.cloudflareByApiToken = new Cloudflare(apiToken);
        this.gson = new Gson();
    }

    protected String pauseAndPrint(Object object) {
        String json = gson.toJson(object);
        if (object instanceof Response) {
            Response<?> response = (Response<?>) object;
            if (!response.getSuccess()) {
                System.err.println(json);
            } else {
                System.out.println(json);
            }
        } else {
            System.out.println(json);
        }
        System.out.println();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }
}
