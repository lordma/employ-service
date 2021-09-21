package com.lordma.employ.system.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/7/11 18:19
 * @Version 1.0
 */
@Data
public class WorkInfo {
    // 勤務月
    private String ymonth;
    // 勤務時間
    private String totalHours;
    // 提出資料
    private List<String> committedDocument;
    // 未提出資料
    private List<String> uncommittedDocument;
    // 勤務表
    private String workFileType;
    // 請求書
    private String invoiceFileType;
    // 通勤費
    private String commuteFileType;

}
