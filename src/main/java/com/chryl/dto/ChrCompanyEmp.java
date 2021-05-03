package com.chryl.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chr.yl on 2021/4/8.
 *
 * @author Chr.yl
 */
@Data
@ToString
public class ChrCompanyEmp implements Serializable {

    private static final long serialVersionUID = 7083418848729758708L;

    private Long companyId;

    private String companyName;

    private Integer companyCode;
    private String companyDescription;

    private String companyChinese;

    private List<ChrEmp> chrEmpList;

}
