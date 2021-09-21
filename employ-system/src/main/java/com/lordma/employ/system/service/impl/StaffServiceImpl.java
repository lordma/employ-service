package com.lordma.employ.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.mapper.StaffMapper;
import com.lordma.employ.system.service.IStaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {
    @Autowired
    private StaffMapper staffMapper;

    public List<Staff> getAllStaff(){
        return staffMapper.selectByMap(null);
    }

    public  Staff getStaff(Staff staff){
        Wrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.equals(staff);
        return staffMapper.selectOne(queryWrapper);
    }

    @Override
    @Cacheable(value="users", key = "'account_'.concat(#loginAccount)")
    public Staff queryUserByAccount(String loginAccount){
        QueryWrapper<Staff> ew = new QueryWrapper<Staff>();
        ew.eq("login_name", loginAccount);
        return getOne(ew);
    }
}
