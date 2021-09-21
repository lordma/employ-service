package com.lordma.employ.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lordma.employ.common.annotation.auth.CurrentUser;
import com.lordma.employ.common.base.PageResult;
import com.lordma.employ.system.dto.ProjectInfo;
import com.lordma.employ.system.entity.Project;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IProjectService projectService;

    @GetMapping("getProjectListByStaffId")
    public PageResult<ProjectInfo> getProjectListByStaffId(Page<ProjectInfo> page, @ApiIgnore @CurrentUser Staff staff){
        Project project = new Project();
        project.setStaffId(staff.getStaffId());
        Page<ProjectInfo> projectInfoList = projectService.getProjectInfoByStaffId(page, project);
        return new PageResult<>(projectInfoList.getTotal(), projectInfoList.getRecords());
    }
}
