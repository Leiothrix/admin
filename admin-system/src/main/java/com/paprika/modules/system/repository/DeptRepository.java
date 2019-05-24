package com.paprika.modules.system.repository;

import com.paprika.modules.system.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * @author adam
 * @date 2019/5/13
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor{

    List<Dept> findByPid(Long id);

    Set<Dept> findByRoles_Id(Long id);
}
