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
 * UserServiceKey
 *
 * @author renfei
 */
public class UserServiceKey {
    private final static String USER_SERVICE_KEY_START = "v1.0-";
    private final String serviceKey;

    private UserServiceKey() {
        this.serviceKey = null;
        throw new RuntimeException("Illegal instantiation.");
    }

    /**
     * UserServiceKey
     *
     * @param userServiceKey A special Cloudflare API key good for a restricted set of endpoints. Always begins with "v1.0-", may vary in length.
     */
    public UserServiceKey(String userServiceKey) {
        if (userServiceKey == null || "".equals(userServiceKey) || !userServiceKey.startsWith(USER_SERVICE_KEY_START)) {
            throw new ErrorTokenException("User-Service-Key Error. Always begins with \"v1.0-\", may vary in length.");
        }
        this.serviceKey = userServiceKey;
    }

    public String getUserServiceKey() {
        return serviceKey;
    }
}
