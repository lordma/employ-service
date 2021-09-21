package com.lordma.employ.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lordma.employ.system.dto.ProjectInfo;
import com.lordma.employ.system.dto.WorkInfo;
import com.lordma.employ.system.entity.MonthFile;
import com.lordma.employ.system.entity.Project;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
public interface IMonthFileService extends IService<MonthFile> {
    /**
     * 勤務一覧
     * @param page
     * @param monthFile
     * @return
     */
    Page<WorkInfo> getWorkInfoByStaffId(Page<WorkInfo> page, MonthFile monthFile);
}
