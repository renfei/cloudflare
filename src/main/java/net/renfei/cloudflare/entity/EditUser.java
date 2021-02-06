package net.renfei.cloudflare.entity;

import lombok.Data;

/**
 * <p>Title: EditUser</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class EditUser {
    private String firstName;
    private String lastName;
    private String telephone;
    private String country;
    private String zipcode;
}
