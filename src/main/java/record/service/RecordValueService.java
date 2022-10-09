package record.service;

import java.util.List;

import org.springframework.data.domain.Page;

import record.model.RecordValue;

public interface RecordValueService {
	
	RecordValue getById(Integer id);
	List<RecordValue> findAll();
	Page<RecordValue> findAll(int pageNum);
	RecordValue save(RecordValue recordValue);
	List<RecordValue> saveAll(List<RecordValue> recordValues);
	RecordValue delete(Integer id);
	
	List<RecordValue> findByRecordTypeId(Integer recordTypeId);
	
	List<RecordValue> findByRecordTypeIdAndNameLike(Integer recordTypeId, String name);

}
