package com.lordma.employ.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lordma.employ.system.dto.WorkInfo;
import com.lordma.employ.system.entity.MonthFile;
import com.lordma.employ.system.mapper.MonthFileMapper;
import com.lordma.employ.system.service.IMonthFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
@Service
public class MonthFileServiceImpl extends ServiceImpl<MonthFileMapper, MonthFile> implements IMonthFileService {
    @Autowired
    private MonthFileMapper monthFileMapper;
    @Override
    public Page<WorkInfo> getWorkInfoByStaffId(Page<WorkInfo> page, MonthFile monthFile) {
        Page<WorkInfo> workInfoPage = monthFileMapper.getWorkInfoByStaffId(page, monthFile);
        workInfoPage.getRecords().forEach(workInfo -> {
            List<String> committedDocument = new ArrayList<String>();
            List<String> unCommittedDocument = new ArrayList<String>();
            // 勤務表
            if (StringUtils.isEmpty(workInfo.getWorkFileType())) {
                unCommittedDocument.add("1");
            } else {
                committedDocument.add(workInfo.getWorkFileType());
            }
            // 請求書
            if (StringUtils.isEmpty(workInfo.getInvoiceFileType())) {
                unCommittedDocument.add("2");
            } else {
                committedDocument.add(workInfo.getInvoiceFileType());
            }
            // 通勤費
            if (StringUtils.isEmpty(workInfo.getCommuteFileType())) {
                unCommittedDocument.add("3");
            } else {
                committedDocument.add(workInfo.getCommuteFileType());
            }
            workInfo.setCommittedDocument(committedDocument);
            workInfo.setUncommittedDocument(unCommittedDocument);
        });
        return workInfoPage;
    }
}
