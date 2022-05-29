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
package net.renfei.cloudflare.entity.common;

import net.renfei.cloudflare.exception.ErrorTokenException;

/**
 * ApiKey
 *
 * @author renfei
 */
public class ApiKey {
    private final String apiKey;
    private final String email;

    private ApiKey() {
        this.apiKey = null;
        this.email = null;
        throw new RuntimeException("Illegal instantiation.");
    }

    /**
     * ApiKey
     *
     * @param apiKey API key generated on the "My Account" page
     * @param email  Email address associated with your account
     */
    public ApiKey(String apiKey, String email) {
        if (apiKey == null || "".equals(apiKey)) {
            throw new ErrorTokenException("API-Key cannot be empty.");
        }
        if (email == null || "".equals(email)) {
            throw new ErrorTokenException("Email cannot be empty.");
        }
        this.apiKey = apiKey;
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getEmail() {
        return email;
    }
}
