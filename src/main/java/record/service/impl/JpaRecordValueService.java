package record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import record.model.RecordValue;
import record.repository.RecordValueRepository;
import record.service.RecordValueService;

@Service
public class JpaRecordValueService implements RecordValueService{
	
	@Autowired
	private RecordValueRepository recordValueRepository;

	@Override
	public RecordValue getById(Integer id) {
		return recordValueRepository.getById(id);
	}

	@Override
	public List<RecordValue> findAll() {
		return recordValueRepository.findAll();
	}

	@Override
	public Page<RecordValue> findAll(int pageNum) {
		PageRequest pageable = PageRequest.of(pageNum, 20);
		return recordValueRepository.findAll(pageable);
	}

	@Override
	public RecordValue save(RecordValue recordValue) {
		return recordValueRepository.save(recordValue);
	}

	@Override
	public List<RecordValue> saveAll(List<RecordValue> recordValues) {
		return recordValueRepository.saveAll(recordValues);
	}

	@Override
	public RecordValue delete(Integer id) {
		RecordValue recordValue = recordValueRepository.getById(id);
		if(recordValue != null) {
			recordValueRepository.delete(recordValue);
		}
		return recordValue;
	}

	@Override
	public List<RecordValue> findByRecordTypeId(Integer recordTypeId) {
		return recordValueRepository.findByRecordTypeId(recordTypeId);
	}
	
	
	@Override
	public List<RecordValue> findByRecordTypeIdAndNameLike(Integer recordTypeId, String name) {
		if( name != null) {
			name = '%' + name + '%';
		}
		return recordValueRepository.findByRecordTypeIdAndNameLike(recordTypeId, name);
	}
	

}
