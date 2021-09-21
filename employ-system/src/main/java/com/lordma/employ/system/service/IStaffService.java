package com.lordma.employ.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lordma.employ.system.entity.Staff;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 馬　貴成
 * @since 2020-04-25
 */
public interface IStaffService extends IService<Staff> {
    List<Staff> getAllStaff();
    Staff getStaff(Staff staff);
    Staff queryUserByAccount(String loginAccount);
}
