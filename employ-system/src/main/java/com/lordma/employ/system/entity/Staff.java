package com.lordma.employ.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Staff对象", description="")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "社員ID")
    @TableId(value = "staff_id", type = IdType.AUTO)
    private Integer staffId;

    @ApiModelProperty(value = "ログインID")
    private String loginName;

    @ApiModelProperty(value = "社員名")
    private String staffName;

    @ApiModelProperty(value = "パスワード")
    private String password;

    @ApiModelProperty(value = "部門ID")
    private Integer departmentId;

    @ApiModelProperty(value = "職位ID")
    private Integer positionId;

    @ApiModelProperty(value = "権限ID")
    private Integer roleId;

    @ApiModelProperty(value = "性別")
    private String sex;

    @ApiModelProperty(value = "出生年月日")
    private LocalDate birthday;

    @ApiModelProperty(value = "連絡携帯電話")
    private String mobile1;

    @ApiModelProperty(value = "連絡携帯電話２")
    private String mobile2;

    @ApiModelProperty(value = "メールアドレス")
    private String email;

    @ApiModelProperty(value = "プロファイル")
    private String profile;

    @ApiModelProperty(value = "在留カード")
    private String residenceCard;

    @ApiModelProperty(value = "ログイン回数")
    private Long loginCount;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
