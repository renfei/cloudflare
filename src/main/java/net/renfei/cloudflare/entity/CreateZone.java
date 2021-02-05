package net.renfei.cloudflare.entity;

import lombok.Data;

/**
 * <p>Title: CreateZone</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class CreateZone {
    private String name;
    private String type;
    private Account account;
    private Boolean jumpStart;

    @Data
    public static class Account {
        private String id;
    }
}
