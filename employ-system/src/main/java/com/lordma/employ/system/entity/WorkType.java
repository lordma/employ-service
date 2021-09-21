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
@ApiModel(value="WorkType对象", description="")
public class WorkType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出勤種類ID")
    @TableId(value = "work_type_id", type = IdType.AUTO)
    private Integer workTypeId;

    @ApiModelProperty(value = "出勤種類")
    private String workTypeName;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
