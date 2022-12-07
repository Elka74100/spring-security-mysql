package com.openwt.employee.app.persistence.departement;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class DepartmentPK implements Serializable {
    private Long empNo;
    private String deptNo;
}
