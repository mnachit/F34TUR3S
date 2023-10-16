package com.gathergrid.embeddables;

import jakarta.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class AddressEmail {

    @NotEmpty(message = "Please enter your Email")
    @Email(message = "Invalid email format")
    private String addressEmail;

    public AddressEmail() {
    }

    public AddressEmail(String addressEmail) {
        this.addressEmail = addressEmail;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressEmail(String addressEmail) {
        this.addressEmail = addressEmail;
    }
}
