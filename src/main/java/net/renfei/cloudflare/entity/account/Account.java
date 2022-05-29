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
package net.renfei.cloudflare.entity.account;

/**
 * Account
 *
 * @author renfei
 */
public class Account {
    private String id;
    private String name;
    private Settings settings;
    private String created_on;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", settings=" + settings +
                ", created_on='" + created_on + '\'' +
                '}';
    }

    public static class Settings {
        private Boolean enforce_twofactor;
        private Boolean use_account_custom_ns_by_default;

        public Boolean getEnforce_twofactor() {
            return enforce_twofactor;
        }

        public void setEnforce_twofactor(Boolean enforce_twofactor) {
            this.enforce_twofactor = enforce_twofactor;
        }

        public Boolean getUse_account_custom_ns_by_default() {
            return use_account_custom_ns_by_default;
        }

        public void setUse_account_custom_ns_by_default(Boolean use_account_custom_ns_by_default) {
            this.use_account_custom_ns_by_default = use_account_custom_ns_by_default;
        }

        @Override
        public String toString() {
            return "Settings{" +
                    "enforce_twofactor=" + enforce_twofactor +
                    ", use_account_custom_ns_by_default=" + use_account_custom_ns_by_default +
                    '}';
        }
    }
}
