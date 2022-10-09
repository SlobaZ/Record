package record.service;

import java.util.List;

import org.springframework.data.domain.Page;

import record.model.RecordType;

public interface RecordTypeService {
	
	RecordType getById(Integer id);
	List<RecordType> findAll();
	Page<RecordType> findAll(int pageNum);
	RecordType save(RecordType recordType);
	List<RecordType> saveAll(List<RecordType> recordTypes);
	RecordType delete(Integer id);
	
	List<RecordType> findByNameLike(String name);

}
