package com.jcart.modules.tracker.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private String accountName;
    private String accountNo;
    private String clientCode;
    private String accountType;
}
