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

import com.google.gson.reflect.TypeToken;
import net.renfei.cloudflare.Cloudflare;
import net.renfei.cloudflare.api.Zone;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;
import net.renfei.cloudflare.entity.zone.CreateZoneAo;
import net.renfei.cloudflare.entity.zone.DnsRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Zone is a domain name along with its subdomains and other identities
 *
 * @author renfei
 */
public class ZoneImpl extends BaseService implements Zone {

    public ZoneImpl(Cloudflare cloudflare) {
        super(cloudflare);
    }

    @Override
    public Response<List<net.renfei.cloudflare.entity.zone.Zone>> findZoneList(String match, String name,
                                                                               String accountName, String accountId,
                                                                               String order, String status,
                                                                               Pagination pagination) {
        String endpoint = "zones?";
        if (match != null) {
            endpoint += "match=" + match + "&";
        }
        if (name != null) {
            endpoint += "name=" + name + "&";
        }
        if (accountName != null) {
            endpoint += "account.name=" + accountName + "&";
        }
        if (accountId != null) {
            endpoint += "account.id=" + accountId + "&";
        }
        if (order != null) {
            endpoint += "order=" + order + "&";
        }
        if (status != null) {
            endpoint += "status=" + status + "&";
        }
        if (pagination != null) {
            if (pagination.getPage() != null) {
                endpoint += "page=" + pagination.getPage() + "&";
            }
            if (pagination.getPerPage() != null) {
                endpoint += "per_page=" + pagination.getPerPage() + "&";
            }
            if (pagination.getDirection() != null) {
                endpoint += "direction=" + pagination.getDirection().toString().toLowerCase() + "&";
            }
        }
        Response<List<net.renfei.cloudflare.entity.zone.Zone>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<net.renfei.cloudflare.entity.zone.Zone>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<net.renfei.cloudflare.entity.zone.Zone> createZone(CreateZoneAo createZoneAo) {
        String endpoint = "zones";
        Response<net.renfei.cloudflare.entity.zone.Zone> response;
        try {
            response = client.request(endpoint, "POST", createZoneAo,
                    new TypeToken<Response<net.renfei.cloudflare.entity.zone.Zone>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<net.renfei.cloudflare.entity.zone.Zone> findZone(String zoneId) {
        String endpoint = "zones/" + zoneId;
        Response<net.renfei.cloudflare.entity.zone.Zone> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<net.renfei.cloudflare.entity.zone.Zone>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<net.renfei.cloudflare.entity.zone.Zone> editZone(String zoneId, net.renfei.cloudflare.entity.zone.Zone zone) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId;
        Response<net.renfei.cloudflare.entity.zone.Zone> response;
        try {
            response = client.request(endpoint, "PATCH", zone,
                    new TypeToken<Response<net.renfei.cloudflare.entity.zone.Zone>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> deleteZone(String zoneId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId;
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "DELETE", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> checkZoneActivation(String zoneId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/activation_check";
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "PUT", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> purgeAllFiles(String zoneId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/purge_cache";
        Response<Map<String, String>> response;
        Map<String, Boolean> data = new HashMap<>();
        data.put("purge_everything", true);
        try {
            response = client.request(endpoint, "POST", data,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<List<DnsRecord>> findDnsRecordList(String zoneId, String match, String name, String order,
                                                       String content, String type, Boolean proxied, Pagination pagination) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/dns_records?";
        if (match != null) {
            endpoint += "match=" + match + "&";
        }
        if (name != null) {
            endpoint += "name=" + name + "&";
        }
        if (order != null) {
            endpoint += "order=" + order + "&";
        }
        if (content != null) {
            endpoint += "content=" + content + "&";
        }
        if (order != null) {
            endpoint += "order=" + order + "&";
        }
        if (type != null) {
            endpoint += "type=" + type + "&";
        }
        if (proxied != null) {
            endpoint += "proxied=" + proxied + "&";
        }
        if (pagination != null) {
            if (pagination.getPage() != null) {
                endpoint += "page=" + pagination.getPage() + "&";
            }
            if (pagination.getPerPage() != null) {
                endpoint += "per_page=" + pagination.getPerPage() + "&";
            }
            if (pagination.getDirection() != null) {
                endpoint += "direction=" + pagination.getDirection().toString().toLowerCase() + "&";
            }
        }
        Response<List<DnsRecord>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<DnsRecord>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<DnsRecord> createDnsRecord(String zoneId, DnsRecord dnsRecord) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        dnsRecord.setZone_id(zoneId);
        String endpoint = "zones/" + zoneId + "/dns_records";
        Response<DnsRecord> response;
        try {
            response = client.request(endpoint, "POST", dnsRecord,
                    new TypeToken<Response<DnsRecord>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<DnsRecord> findDnsRecord(String zoneId, String dnsRecordId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/dns_records/" + dnsRecordId;
        Response<DnsRecord> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<DnsRecord>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<DnsRecord> updateDnsRecord(String zoneId, String dnsRecordId, DnsRecord dnsRecord) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        if (dnsRecordId == null || "".equals(dnsRecordId)) {
            throw new RuntimeException("dnsRecordId cannot be empty.");
        }
        dnsRecord.setZone_id(zoneId);
        dnsRecord.setId(dnsRecordId);
        String endpoint = "zones/" + zoneId + "/dns_records/" + dnsRecordId;
        Response<DnsRecord> response;
        try {
            response = client.request(endpoint, "PUT", dnsRecord,
                    new TypeToken<Response<DnsRecord>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<DnsRecord> patchDnsRecord(String zoneId, String dnsRecordId, DnsRecord dnsRecord) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        if (dnsRecordId == null || "".equals(dnsRecordId)) {
            throw new RuntimeException("dnsRecordId cannot be empty.");
        }
        dnsRecord.setZone_id(zoneId);
        dnsRecord.setId(dnsRecordId);
        String endpoint = "zones/" + zoneId + "/dns_records/" + dnsRecordId;
        Response<DnsRecord> response;
        try {
            response = client.request(endpoint, "PATCH", dnsRecord,
                    new TypeToken<Response<DnsRecord>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> deleteDnsRecord(String zoneId, String dnsRecordId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        if (dnsRecordId == null || "".equals(dnsRecordId)) {
            throw new RuntimeException("dnsRecordId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/dns_records/" + dnsRecordId;
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "DELETE", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, Integer>> scanDnsRecord(String zoneId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/dns_records/scan";
        Response<Map<String, Integer>> response;
        try {
            response = client.request(endpoint, "POST", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
