package com.jcart.modules.tracker.batch;

import com.jcart.modules.security.users.User;
import com.jcart.modules.security.users.UserResponse;
import com.jcart.modules.tracker.account.AccountDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {

    public static BatchResponse mapBatchToBatchResponse(Batch batch,  User creator) {

        BatchResponse batchResponse = new BatchResponse();

        batchResponse.setId(batch.getId());
        batchResponse.setName(batch.getName());
        batchResponse.setDescription(batch.getDescription());
        batchResponse.setCreationDate(batch.getCreatedOn());

        batchResponse.setBranch(batch.getBranch());

        List<AccountDTO> accountResponses = batch.getAccounts().stream().map(account -> {
            AccountDTO accountResponse = new AccountDTO();
            accountResponse.setAccountName(account.getAccountName());
            accountResponse.setAccountNo(account.getAccountNo());
            accountResponse.setClientCode(account.getClientCode());
            accountResponse.setAccountType(account.getAccountType());

            return accountResponse;
        }).collect(Collectors.toList());

        batchResponse.setAccounts(accountResponses);

        UserResponse userResponse = new UserResponse(creator.getId(), creator.getUsername(), creator.getFirstName(),creator.getLastName());
        batchResponse.setCreatedBy(userResponse);

        return batchResponse;
    }
}
