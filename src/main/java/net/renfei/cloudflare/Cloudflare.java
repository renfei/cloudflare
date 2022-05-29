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

import net.renfei.cloudflare.api.Account;
import net.renfei.cloudflare.api.Firewall;
import net.renfei.cloudflare.api.User;
import net.renfei.cloudflare.api.Zone;
import net.renfei.cloudflare.entity.common.ApiKey;
import net.renfei.cloudflare.entity.common.ApiToken;
import net.renfei.cloudflare.entity.common.AuthTypeEnum;
import net.renfei.cloudflare.entity.common.UserServiceKey;
import net.renfei.cloudflare.service.AccountImpl;
import net.renfei.cloudflare.service.FirewallImpl;
import net.renfei.cloudflare.service.UserImpl;
import net.renfei.cloudflare.service.ZoneImpl;

/**
 * Cloudflare
 *
 * @author renfei
 */
public class Cloudflare {
    private final ApiKey API_KEY;
    private final ApiToken API_TOKEN;
    private final UserServiceKey USER_SERVICE_KEY;
    private final AuthTypeEnum AUTH_TYPE_ENUM;

    private Cloudflare() {
        this.API_KEY = null;
        this.API_TOKEN = null;
        this.USER_SERVICE_KEY = null;
        this.AUTH_TYPE_ENUM = null;
        throw new RuntimeException("Illegal instantiation.");
    }

    public Cloudflare(ApiKey apiKey) {
        this.API_KEY = apiKey;
        this.API_TOKEN = null;
        this.USER_SERVICE_KEY = null;
        this.AUTH_TYPE_ENUM = AuthTypeEnum.API_KEY;
    }

    public Cloudflare(ApiToken apiToken) {
        this.API_KEY = null;
        this.API_TOKEN = apiToken;
        this.USER_SERVICE_KEY = null;
        this.AUTH_TYPE_ENUM = AuthTypeEnum.API_TOKEN;
    }

    public Cloudflare(UserServiceKey userServiceKey) {
        this.API_KEY = null;
        this.API_TOKEN = null;
        this.USER_SERVICE_KEY = userServiceKey;
        this.AUTH_TYPE_ENUM = AuthTypeEnum.USER_SERVICE_KEY;
    }

    public Account account() {
        return new AccountImpl(this);
    }

    public Firewall firewall() {
        return new FirewallImpl(this);
    }

    public User user() {
        return new UserImpl(this);
    }

    public Zone zone() {
        return new ZoneImpl(this);
    }

    public ApiKey getAPI_KEY() {
        return API_KEY;
    }

    public ApiToken getAPI_TOKEN() {
        return API_TOKEN;
    }

    public UserServiceKey getUSER_SERVICE_KEY() {
        return USER_SERVICE_KEY;
    }

    public AuthTypeEnum getAUTH_TYPE_ENUM() {
        return AUTH_TYPE_ENUM;
    }
}
