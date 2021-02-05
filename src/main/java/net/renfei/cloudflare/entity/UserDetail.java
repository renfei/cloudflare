package net.renfei.cloudflare.entity;

import lombok.Data;

/**
 * <p>Title: UserDetail</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class UserDetail {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String telephone;
    private String country;
    private String zipcode;
    private String createdOn;
    private String modifiedOn;
    private Boolean twoFactorAuthenticationEnabled;
    private Boolean suspended;
}
