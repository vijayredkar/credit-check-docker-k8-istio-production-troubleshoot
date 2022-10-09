package com.credit.check.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.credit.check.repo.model.KycRepoData;

public interface KycRepository extends MongoRepository<KycRepoData, String> 
{
    
    @Query("{firstName:'?0'}")
    KycRepoData findByFirstName(String firstName);
    
    /*
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<KycRepoData> findAll(String category);    
    public long count();
    */

}