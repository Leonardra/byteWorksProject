package com.github.servbytebackend.web.payload;

import com.github.servbytebackend.data.enums.Channel;
import lombok.Data;


@Data
public class InitialiseTransactionRequestDto {

    private String amount;
    private String email;
    private String reference;
    private String callback_url;
    private Integer invoice_limit;
    private Channel[] channels;
    private String subaccount;
    private Integer transaction_charge;
}
