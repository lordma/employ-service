package com.lordma.employ.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lordma.employ.system.dto.ProjectInfo;
import com.lordma.employ.system.entity.Project;
import com.lordma.employ.system.mapper.ProjectMapper;
import com.lordma.employ.system.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public Page<ProjectInfo> getProjectInfoByStaffId(Page<ProjectInfo> page, Project project) {
        return projectMapper.getProjectInfoByStaffId(page, project);
    }
}
