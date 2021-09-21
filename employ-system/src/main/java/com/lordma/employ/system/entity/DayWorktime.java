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
@ApiModel(value="DayWorktime对象", description="")
public class DayWorktime implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "社員ID")
    @TableId(value = "staff_id", type = IdType.AUTO)
    private Integer staffId;

    @ApiModelProperty(value = "案件ID")
    private Integer projectId;

    @ApiModelProperty(value = "出勤種類")
    private String workTypeId;

    @ApiModelProperty(value = "出勤日付")
    private LocalDate day;

    @ApiModelProperty(value = "出勤時間")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "退勤時間")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "コメント")
    private String comment;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
