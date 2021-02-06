package net.renfei.cloudflare.entity;

import lombok.Data;

/**
 * <p>Title: DnsRecords</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class DnsRecords {
    private String id;
    private String type;
    private String name;
    private String content;
    private Boolean proxiable;
    private Boolean proxied;
    private Integer ttl;
    private Boolean locked;
    private String zoneId;
    private String zoneName;
    private String createdOn;
    private String modifiedOn;
    private String data;
    private Meta meta;

    @Data
    public static class Meta{
        private Boolean autoAdded;
        private String source;
    }
}
