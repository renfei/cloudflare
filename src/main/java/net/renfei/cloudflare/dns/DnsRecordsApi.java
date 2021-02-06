package net.renfei.cloudflare.dns;

import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.CloudflareInterface;
import net.renfei.cloudflare.entity.CreateDnsRecord;
import net.renfei.cloudflare.entity.DnsRecords;
import net.renfei.cloudflare.entity.Id;
import net.renfei.sdk.http.HttpEntityType;
import net.renfei.sdk.http.HttpRequest;
import net.renfei.sdk.utils.HttpUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: DnsRecordsApi</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class DnsRecordsApi extends CloudflareInterface {
    DnsRecordsApi() {

    }

    public DnsRecordsApi(String apiToken) {
        API_TOKEN = apiToken;
    }

    public List<DnsRecords> getListDnsRecord(String zoneId, Map<String, Object> paramMap) throws IOException {
        HttpRequest request = getRequest("zones/" + zoneId + "/dns_records");
        request.pathParam(paramMap);
        return getResultList(HttpUtils.get(request), DnsRecords.class);
    }

    public DnsRecords createDnsRecord(String zoneId, CreateDnsRecord createDnsRecord) throws IOException {
        HttpRequest request = getRequest("zones/" + zoneId + "/dns_records");
        request.json(JSON.toJSONString(createDnsRecord));
        return getResult(HttpUtils.post(request), DnsRecords.class);
    }

    public DnsRecords getDnsRecordDetails(String zoneId, String id) throws IOException {
        return getResult(HttpUtils.get(getRequest("zones/" + zoneId + "/dns_records/" + id)), DnsRecords.class);
    }

    public DnsRecords updateDnsRecord(String zoneId, String id, CreateDnsRecord createDnsRecord) throws IOException {
        HttpRequest request = getRequest("zones/" + zoneId + "/dns_records/" + id);
        request.json(JSON.toJSONString(createDnsRecord));
        return getResult(HttpUtils.put(request), DnsRecords.class);
    }

    public DnsRecords patchDnsRecord(String zoneId, String id, CreateDnsRecord createDnsRecord) throws IOException {
        HttpRequest request = getRequest("zones/" + zoneId + "/dns_records/" + id);
        request.json(JSON.toJSONString(createDnsRecord));
        return getResult(HttpUtils.patch(request), DnsRecords.class);
    }

    public Id deleteDnsRecord(String zoneId, String id) throws IOException {
        return getResult(HttpUtils.delete(getRequest("zones/" + zoneId + "/dns_records/" + id)), Id.class);
    }
}
