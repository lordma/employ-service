package com.lordma.employ.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@ApiModel(value="Role对象", description="")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "権限ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    @ApiModelProperty(value = "権限名")
    private String roleName;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
