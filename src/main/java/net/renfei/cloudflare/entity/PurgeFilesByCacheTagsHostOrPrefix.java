package net.renfei.cloudflare.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: PurgeFilesbyCacheTagsHostOrPrefix</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class PurgeFilesByCacheTagsHostOrPrefix {
    private List<String> tags;
    private List<String> hosts;
    private List<String> prefixes;
}
