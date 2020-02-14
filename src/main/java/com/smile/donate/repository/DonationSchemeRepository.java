package com.smile.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smile.donate.entity.Donation;

@Repository
public interface DonationSchemeRepository extends JpaRepository<Donation, Long>{

}
