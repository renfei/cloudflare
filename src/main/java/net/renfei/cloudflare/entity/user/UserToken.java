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
package net.renfei.cloudflare.entity.user;

import java.util.List;
import java.util.Map;

/**
 * UserToken
 *
 * @author renfei
 */
public class UserToken {
    private String id;
    private String name;
    private String status;
    private String issued_on;
    private String modified_on;
    private String not_before;
    private String expires_on;
    private List<Policies> policies;
    private Map<String, Map<String, List<String>>> condition;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssued_on() {
        return issued_on;
    }

    public void setIssued_on(String issued_on) {
        this.issued_on = issued_on;
    }

    public String getModified_on() {
        return modified_on;
    }

    public void setModified_on(String modified_on) {
        this.modified_on = modified_on;
    }

    public String getNot_before() {
        return not_before;
    }

    public void setNot_before(String not_before) {
        this.not_before = not_before;
    }

    public String getExpires_on() {
        return expires_on;
    }

    public void setExpires_on(String expires_on) {
        this.expires_on = expires_on;
    }

    public List<Policies> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policies> policies) {
        this.policies = policies;
    }

    public Map<String, Map<String, List<String>>> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Map<String, List<String>>> condition) {
        this.condition = condition;
    }

    public static class Policies {
        private String id;
        private String effect;
        private Map<String, Map<String, String>> resources;
        private List<PermissionGroup> permission_groups;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public Map<String, Map<String, String>> getResources() {
            return resources;
        }

        public void setResources(Map<String, Map<String, String>> resources) {
            this.resources = resources;
        }

        public List<PermissionGroup> getPermission_groups() {
            return permission_groups;
        }

        public void setPermission_groups(List<PermissionGroup> permission_groups) {
            this.permission_groups = permission_groups;
        }

        public static class PermissionGroup {
            private String id;
            private String name;

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
        }
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", issued_on='" + issued_on + '\'' +
                ", modified_on='" + modified_on + '\'' +
                ", not_before='" + not_before + '\'' +
                ", expires_on='" + expires_on + '\'' +
                ", policies=" + policies +
                ", condition=" + condition +
                '}';
    }
}
