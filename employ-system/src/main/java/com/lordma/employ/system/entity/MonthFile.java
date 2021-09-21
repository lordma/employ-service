package com.lordma.employ.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value="MonthFile对象", description="")
public class MonthFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "年月")
    @TableId(value = "ymonth")
    private String ymonth;

    @ApiModelProperty(value = "社員ID")
    @TableId(value = "staff_id")
    private Integer staffId;

    @ApiModelProperty(value = "ファイル種類ID")
    @TableId(value = "file_type_id")
    private String fileTypeId;

    @ApiModelProperty(value = "ファイルパス")
    private String filePath;

    @ApiModelProperty(value = "ファイル名")
    private String fileName;

    @ApiModelProperty(value = "コメント")
    private String comment;

    @ApiModelProperty(value = "月別勤務時間")
    private BigDecimal monthWorkHours;

    @ApiModelProperty(value = "作成者")
    private Integer createUserId;

    @ApiModelProperty(value = "更新者")
    private Integer updateUserId;

    @ApiModelProperty(value = "作成時間")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新時間")
    private LocalDateTime updateDate;


}
