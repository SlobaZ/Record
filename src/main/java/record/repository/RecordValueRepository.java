package record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import record.model.RecordValue;

@Repository
public interface RecordValueRepository extends JpaRepository<RecordValue, Integer>{
	
	List<RecordValue> findByRecordTypeId(Integer recordTypeId);
	
	List<RecordValue> findByRecordTypeIdAndNameLike(Integer recordTypeId, String name);

}
