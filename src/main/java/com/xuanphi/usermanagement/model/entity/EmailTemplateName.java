package com.xuanphi.usermanagement.model.entity;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("email/activate_account");

    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
