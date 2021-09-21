package com.lordma.employ.system.controller;


import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @GetMapping("getAllStaff")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @PutMapping("login")
    public Staff login(@RequestBody Staff staff) {
        return staffService.getStaff(staff);
    }
}
