package net.renfei.cloudflare.zone;

import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.CloudflareException;
import net.renfei.cloudflare.CloudflareInterface;
import net.renfei.cloudflare.entity.*;
import net.renfei.sdk.http.HttpRequest;
import net.renfei.sdk.utils.HttpUtils;

import java.io.IOException;
import java.util.List;

/**
 * <p>Title: ZoneApi</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class ZoneApi extends CloudflareInterface {
    private ZoneApi() {
    }

    public ZoneApi(String apiToken) {
        API_TOKEN = apiToken;
    }

    public List<Zone> getListZones() throws IOException, CloudflareException {
        return getResultList(HttpUtils.get(getRequest("zones")), Zone.class);
    }

    public Zone createZone(CreateZone createZone) throws IOException, CloudflareException {
        HttpRequest request = getRequest("zones");
        request.json(JSON.toJSONString(createZone));
        return getResult(HttpUtils.post(request), Zone.class);
    }

    public Zone getZoneDetails(String id) throws IOException, CloudflareException {
        return getResult(HttpUtils.get(getRequest("zones/" + id)), Zone.class);
    }

    public Zone editZone(String id, EditZone editZone) throws IOException, CloudflareException {
        HttpRequest request = getRequest("zones/" + id);
        request.json(JSON.toJSONString(editZone));
        return getResult(HttpUtils.patch(request), Zone.class);
    }

    public Id deleteZone(String id) throws IOException, CloudflareException {
        return getResult(HttpUtils.delete(getRequest("zones/" + id)), Id.class);
    }

    public Id zoneActivationCheck(String id) throws IOException, CloudflareException {
        return getResult(HttpUtils.put(getRequest("zones/" + id + "/activation_check")), Id.class);
    }

    public Id purgeAllFiles(String id, PurgeAllFiles purgeAllFiles) throws IOException, CloudflareException {
        HttpRequest request = getRequest("zones/" + id + "/purge_cache");
        request.json(JSON.toJSONString(purgeAllFiles));
        return getResult(HttpUtils.post(request), Id.class);
    }

    public Id purgeFilesByCacheTagsHostOrPrefix(String id, PurgeFilesByCacheTagsHostOrPrefix purgeFilesByCacheTagsHostOrPrefix)
            throws IOException, CloudflareException {
        HttpRequest request = getRequest("zones/" + id + "/purge_cache");
        request.json(JSON.toJSONString(purgeFilesByCacheTagsHostOrPrefix));
        return getResult(HttpUtils.post(request), Id.class);
    }
}
