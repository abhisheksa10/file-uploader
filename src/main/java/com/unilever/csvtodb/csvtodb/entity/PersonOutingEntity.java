package com.unilever.csvtodb.csvtodb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON_OUTING")
public class PersonOutingEntity {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "LAST_NAME", nullable= false)
    private String lastName;

    @Column(name = "LOCATION", nullable= false)
    private String location;

    @Column(name = "OUTLET_NAME", nullable= false)
    private String outletName;

    @Column(name = "OUTLET_TYPE", nullable= false)
    private String outletType;

}
