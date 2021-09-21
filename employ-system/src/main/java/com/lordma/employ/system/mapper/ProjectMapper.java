package com.lordma.employ.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lordma.employ.system.dto.ProjectInfo;
import com.lordma.employ.system.entity.Project;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
public interface ProjectMapper extends BaseMapper<Project> {
    /**
     * プロジェクト一覧
     * @param page
     * @param project
     * @return
     */
    Page<ProjectInfo> getProjectInfoByStaffId(Page<ProjectInfo> page, Project project);
}
