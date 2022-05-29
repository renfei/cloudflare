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
package net.renfei.cloudflare.entity.firewall;

import java.util.List;

/**
 * Firewall rule
 *
 * @author renfei
 */
public class FirewallRule {
    private String id;
    private String notes;
    private List<String> allowed_modes;
    private String mode;
    private Configuration configuration;
    private String created_on;
    private String modified_on;
    private Scope scope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getAllowed_modes() {
        return allowed_modes;
    }

    public void setAllowed_modes(List<String> allowed_modes) {
        this.allowed_modes = allowed_modes;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
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

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "AccountLevelFirewallAccessRule{" +
                "id='" + id + '\'' +
                ", notes='" + notes + '\'' +
                ", allowed_modes=" + allowed_modes +
                ", mode='" + mode + '\'' +
                ", configuration=" + configuration +
                ", created_on='" + created_on + '\'' +
                ", modified_on='" + modified_on + '\'' +
                ", scope=" + scope +
                '}';
    }

    public static class Configuration{
        private String target;
        private String value;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Configuration{" +
                    "target='" + target + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class Scope{
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

        @Override
        public String toString() {
            return "Scope{" +
                    "id='" + id + '\'' +
                    ", email='" + email + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
