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
 * ApiToken
 *
 * @author renfei
 */
public class ApiToken {
    private final String token;

    private ApiToken() {
        token = null;
        throw new RuntimeException("Illegal instantiation.");
    }

    /**
     * ApiToken
     *
     * @param token API Token generated from the User Profile 'API Tokens' page
     */
    public ApiToken(String token) {
        if (token == null || "".equals(token)) {
            throw new ErrorTokenException("API-Token cannot be empty.");
        }
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
