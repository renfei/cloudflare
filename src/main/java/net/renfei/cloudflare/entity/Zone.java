package net.renfei.cloudflare.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: Zone</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class Zone {
    private String id;
    private String name;
    private Integer developmentMode;
    private List<String> originalNameServers;
    private String originalRegistrar;
    private String originalDnshost;
    private String createdOn;
    private String modifiedOn;
    private String activatedOn;
    private Owner owner;
    private Account account;
    private List<String> permissions;
    private Plan plan;
    private PlanPending planPending;
    private String status;
    private Boolean paused;
    private String type;
    private List<String> nameServers;

    @Data
    public static class Plan {
        private String id;
        private String name;
        private Integer price;
        private String currency;
        private String frequency;
        private String legacyId;
        private Boolean isSubscribed;
        private Boolean canSubscribe;
    }

    @Data
    public static class Account {
        private String id;
        private String name;
    }

    @Data
    public static class PlanPending {

        private String id;
        private String name;
        private Integer price;
        private String currency;
        private String frequency;
        private String legacyId;
        private Boolean isSubscribed;
        private Boolean canSubscribe;
    }

    @Data
    public static class Owner {
        private String id;
        private String email;
        private String type;
    }
}
