package com.Butchery.repository;

import com.Butchery.entity.MeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeatRepository extends JpaRepository<MeatEntity, Long> {

}
