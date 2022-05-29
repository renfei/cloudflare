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
package net.renfei.cloudflare.entity.zone;

import net.renfei.cloudflare.entity.account.Account;

import java.util.List;
import java.util.Map;

/**
 * @author renfei
 */
public class Zone {
    private String id;
    private String name;
    private Integer development_mode;
    private List<String> original_name_servers;
    private String original_registrar;
    private String original_dnshost;
    private String created_on;
    private String modified_on;
    private String activated_on;
    private Owner owner;
    private Account account;
    private List<String> permissions;
    private Plan plan;
    private Plan plan_pending;
    private String status;
    private Boolean paused;
    private String type;
    private List<String> name_servers;

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

    public Integer getDevelopment_mode() {
        return development_mode;
    }

    public void setDevelopment_mode(Integer development_mode) {
        this.development_mode = development_mode;
    }

    public List<String> getOriginal_name_servers() {
        return original_name_servers;
    }

    public void setOriginal_name_servers(List<String> original_name_servers) {
        this.original_name_servers = original_name_servers;
    }

    public String getOriginal_registrar() {
        return original_registrar;
    }

    public void setOriginal_registrar(String original_registrar) {
        this.original_registrar = original_registrar;
    }

    public String getOriginal_dnshost() {
        return original_dnshost;
    }

    public void setOriginal_dnshost(String original_dnshost) {
        this.original_dnshost = original_dnshost;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getModified_on() {
        return modified_on;
    }

    public void setModified_on(String modified_on) {
        this.modified_on = modified_on;
    }

    public String getActivated_on() {
        return activated_on;
    }

    public void setActivated_on(String activated_on) {
        this.activated_on = activated_on;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan_pending() {
        return plan_pending;
    }

    public void setPlan_pending(Plan plan_pending) {
        this.plan_pending = plan_pending;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getName_servers() {
        return name_servers;
    }

    public void setName_servers(List<String> name_servers) {
        this.name_servers = name_servers;
    }

    public static class Owner {
        private String id;
        private String email;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Plan {
        private String id;
        private String name;
        private Integer price;
        private String currency;
        private String frequency;
        private String legacy_id;
        private Boolean is_subscribed;
        private Boolean can_subscribe;

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

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getFrequency() {
            return frequency;
        }

        public void setFrequency(String frequency) {
            this.frequency = frequency;
        }

        public String getLegacy_id() {
            return legacy_id;
        }

        public void setLegacy_id(String legacy_id) {
            this.legacy_id = legacy_id;
        }

        public Boolean getIs_subscribed() {
            return is_subscribed;
        }

        public void setIs_subscribed(Boolean is_subscribed) {
            this.is_subscribed = is_subscribed;
        }

        public Boolean getCan_subscribe() {
            return can_subscribe;
        }

        public void setCan_subscribe(Boolean can_subscribe) {
            this.can_subscribe = can_subscribe;
        }
    }
}
