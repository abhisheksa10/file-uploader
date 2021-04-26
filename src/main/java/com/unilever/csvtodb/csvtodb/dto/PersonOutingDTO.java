package com.unilever.csvtodb.csvtodb.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Person Outing")
@Data
public class PersonOutingDTO implements Serializable {
    private static final long serialVersionUID = 123897834986398469L;

    private long id;

    private String lastName;

    private String location;

    private String outletName;

    private String outletType;
}
