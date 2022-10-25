package com.ims.model.PolicyHoldRecord;

import com.ims.model.PolicyHoldRecord.PolicyHolderRecord;
import com.ims.model.PolicyHoldRecord.PolicyHolderRecordRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PolicyHolderRecordRepository extends JpaRepository<PolicyHolderRecord, Long> {

    @Query(value = "SELECT phr FROM PolicyHolderRecord phr WHERE " +
            "lower(phr.policyNumber) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.customerId) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.appliedDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.status) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.startDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.endDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.premium) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.otherDetails) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(phr.agent) LIKE lower(CONCAT('%', :keyword, '%')) ")
    List<PolicyHolderRecord> searchPolicyHolderRecord(@Param("keyword") String keyword);

    @Query(value = "select policyHolderRecord from User user,PolicyHolderRecord policyHolderRecord where user.id = policyHolderRecord.customerId")
    List<Object> queryAllRecord();
}
