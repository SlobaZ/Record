package record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import record.model.RecordType;
import record.repository.RecordTypeRepository;
import record.service.RecordTypeService;

@Service
public class JpaRecordTypeService implements RecordTypeService{
	
	@Autowired
	private RecordTypeRepository recordTypeRepository;

	@Override
	public RecordType getById(Integer id) {
		return recordTypeRepository.getById(id);
	}

	@Override
	public List<RecordType> findAll() {
		return recordTypeRepository.findAll();
	}

	@Override
	public Page<RecordType> findAll(int pageNum) {
		PageRequest pageable = PageRequest.of(pageNum, 20);
		return recordTypeRepository.findAll(pageable);
	}

	@Override
	public RecordType save(RecordType recordType) {
		return recordTypeRepository.save(recordType);
	}

	@Override
	public List<RecordType> saveAll(List<RecordType> recordTypes) {
		return recordTypeRepository.saveAll(recordTypes);
	}

	@Override
	public RecordType delete(Integer id) {
		RecordType recordType = recordTypeRepository.getById(id);
		if(recordType != null) {
			recordTypeRepository.delete(recordType);
		}
		return recordType;
	}

	@Override
	public List<RecordType> findByNameLike(String name) {
		if( name != null) {
			name = '%' + name + '%';
		}
		return recordTypeRepository.findByNameLike(name);
	}
	

}
