package com.lordma.employ.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lordma.employ.system.dto.ProjectInfo;
import com.lordma.employ.system.dto.WorkInfo;
import com.lordma.employ.system.entity.MonthFile;
import com.lordma.employ.system.entity.Project;
import com.lordma.employ.system.entity.WorkType;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
public interface MonthFileMapper extends BaseMapper<MonthFile> {
    /**
     * 勤務一覧
     * @param page
     * @param monthFile
     * @return
     */
    Page<WorkInfo> getWorkInfoByStaffId(Page<WorkInfo> page, MonthFile monthFile);
}
