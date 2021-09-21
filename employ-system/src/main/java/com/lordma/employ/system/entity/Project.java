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
@ApiModel(value="Project对象", description="")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "現場ID")
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    @ApiModelProperty(value = "社員ID")
    @TableId(value = "staff_id")
    private Integer staffId;

    @ApiModelProperty(value = "案件の上位会社ID")
    private String pcompanyId;

    @ApiModelProperty(value = "最終顧客会社ID")
    private Integer endcompanyId;

    @ApiModelProperty(value = "業務種類")
    private Integer jobTypeId;

    @ApiModelProperty(value = "現場名称")
    private String projectName;

    @ApiModelProperty(value = "現場場所")
    private String address;

    @ApiModelProperty(value = "コメント")
    private String comment;

    @ApiModelProperty(value = "案件開始日付")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "案件終了日付")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
