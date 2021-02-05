package net.renfei.cloudflare.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: EditZone</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class EditZone {
    private Boolean paused;
    private List<String> vanityNameServers;
    private Plan plan;

    @Data
    public static class Plan {
        private String id;
    }
}
