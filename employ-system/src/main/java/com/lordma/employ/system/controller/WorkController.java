package com.lordma.employ.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lordma.employ.common.annotation.auth.CurrentUser;
import com.lordma.employ.common.base.PageResult;
import com.lordma.employ.common.base.Result;
import com.lordma.employ.system.dto.WorkInfo;
import com.lordma.employ.system.entity.MonthFile;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IMonthFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/7/11 17:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private IMonthFileService monthFileService;

    @GetMapping("getWorkListByStaffId")
    public PageResult<WorkInfo> getWorkListByStaffId(Page<WorkInfo> page, @ApiIgnore @CurrentUser Staff staff){
        MonthFile monthFile = new MonthFile();
        monthFile.setStaffId(staff.getStaffId());
        Page<WorkInfo> workInfoInfoList = monthFileService.getWorkInfoByStaffId(page, monthFile);
        return new PageResult<>(workInfoInfoList.getTotal(), workInfoInfoList.getRecords());
    }
//    @PostMapping(value = "workAdd", consumes = "multipart/form-data;charset=utf-8;")
//    @PostMapping(value="/workAdd", consumes = { "multipart/mixed", "multipart/form-data" } )
    @PostMapping(value="/workAdd")
    public Result<JSONObject> workAdd(@RequestParam String month, @RequestParam(required = false) String totalHours, @RequestParam(required = false) MultipartFile workFile, @RequestParam(required = false) MultipartFile invoiceFile, @RequestParam(required = false) MultipartFile commuteFile, @ApiIgnore @CurrentUser Staff staff) {
//    public Result<JSONObject> workAdd(@RequestBody(required = false) WorkInfo workInfo) {
        // ????????????????????????ID
        String loginName = staff.getLoginName();
        //??????????????????
        String uploadDir =  "E://upload_file/"+loginName+"/"+month+"/";
        JSONObject json = new JSONObject();
        //??????????????????
        try {
            // ?????????
            if (workFile != null && !workFile.isEmpty()){
//                String fileName = workFile.getOriginalFilename();
//                String prefix = fileName.substring(fileName.lastIndexOf(".")+1); // ??????: "xls"
                //?????????????????????????????????????????????
                String workFilePath = uploadDir+"work/";
                File dir = new File(workFilePath);
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                executeUpload(workFilePath, workFile);
                // DB?????????
                MonthFile monthFile = new MonthFile();
                monthFile.setStaffId(staff.getStaffId());
                monthFile.setMonthWorkHours(new BigDecimal(totalHours));
                monthFile.setYmonth(month);
                monthFile.setFileTypeId("1");
                monthFile.setFilePath(dir.getPath());
                monthFile.setFileName(workFile.getOriginalFilename());
                monthFileService.save(monthFile);
            }
            // ?????????
            if (invoiceFile != null && !invoiceFile.isEmpty()){
                //?????????????????????????????????????????????
                String invoiceFilePath = uploadDir+"invoice/";
                File dir = new File(invoiceFilePath);
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                executeUpload(invoiceFilePath, invoiceFile);
                // DB?????????
                MonthFile monthFile = new MonthFile();
                monthFile.setStaffId(staff.getStaffId());
                monthFile.setYmonth(month);
                monthFile.setMonthWorkHours(new BigDecimal(totalHours));
                monthFile.setFileTypeId("2");
                monthFile.setFilePath(dir.getPath());
                monthFile.setFileName(invoiceFile.getOriginalFilename());
                monthFileService.save(monthFile);
            }
            // ?????????
            if (commuteFile != null && !commuteFile.isEmpty()){
                //?????????????????????????????????????????????
                String commuteFilePath = uploadDir+"commute/";
                File dir = new File(commuteFilePath);
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                executeUpload(commuteFilePath, commuteFile);
                // DB?????????
                MonthFile monthFile = new MonthFile();
                monthFile.setStaffId(staff.getStaffId());
                monthFile.setYmonth(month);
                monthFile.setMonthWorkHours(new BigDecimal(totalHours));
                monthFile.setFileTypeId("3");
                monthFile.setFilePath(dir.getPath());
                monthFile.setFileName(commuteFile.getOriginalFilename());
                monthFileService.save(monthFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new Result<JSONObject>().error();
        }
        return new Result<JSONObject>().success();
    }

    /**
     * ?????????????????????????????????
     * @param uploadDir ??????????????????
     * @param file ????????????
     * @throws Exception
     */
    public void executeUpload(String uploadDir, MultipartFile file) throws Exception
    {
        //?????????????????????????????????
        File serverFile = new File(uploadDir + file.getOriginalFilename());
        //????????????????????????????????????????????????
        file.transferTo(serverFile);
    }
}
