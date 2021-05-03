package com.chryl.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Chr.yl on 2021/4/8.
 *
 * @author Chr.yl
 */
@Data
@ToString
public class ChrEmp implements Serializable {

    private static final long serialVersionUID = -7333445576083396574L;

    private Long empId;

    private String empName;


    private BigDecimal empSal;

    private Long companyId;

    private Long empIdcard;

    private Integer empCode;

    private String empStrDate;

    private String empRealName;

    private String empStrId;
}
