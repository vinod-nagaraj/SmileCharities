package com.smile.donate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smile.donate.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

	List<Donation> findBySchemeId(Long schemeId);

	

}
