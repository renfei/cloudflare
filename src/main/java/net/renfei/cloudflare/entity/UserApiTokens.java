package net.renfei.cloudflare.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserApiTokens</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class UserApiTokens {
    private String id;
    private String name;
    private String status;
    private String issuedOn;
    private String modifiedOn;
    private String notBefore;
    private String expiresOn;
    private List<Policy> policies;
    private Condition condition;

    @Data
    public static class Condition {
        @JSONField(name = "request.ip")
        private RequestIp requestIp;
    }

    @Data
    public static class PermissionGroup {
        private String id;
        private String name;
    }

    @Data
    public static class Policy {
        private String id;
        private String effect;
        private Map<String, String> resources;
        private List<PermissionGroup> permissionGroups;
    }

    @Data
    public static class RequestIp {
        private List<String> in;
        private List<String> notIn;
    }
}
