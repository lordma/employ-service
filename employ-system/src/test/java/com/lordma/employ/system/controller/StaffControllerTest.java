package com.lordma.employ.system.controller;

import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IStaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StaffControllerTest {

    @Autowired
    private IStaffService staffService;

    @Test
    public void login() {
        Staff staff = new Staff();
        staff.setLoginName("admin");
        staff.setPassword("1111");
        Staff staffN = staffService.getStaff(staff);
        System.out.println(staffN);
    }
}

