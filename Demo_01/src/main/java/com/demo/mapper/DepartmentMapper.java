package com.demo.mapper;

import com.demo.base.BaseMapper;
import com.demo.domain.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}