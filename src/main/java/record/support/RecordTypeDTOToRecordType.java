package record.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import record.dto.RecordTypeDTO;
import record.model.RecordType;
import record.service.RecordTypeService;

@Component
public class RecordTypeDTOToRecordType implements Converter<RecordTypeDTO, RecordType> {
	
	@Autowired
	private RecordTypeService recordTypeService;

	@Override
	public RecordType convert(RecordTypeDTO dto) {
		RecordType recordType = null;
		if(dto.getId()!=null) {
			recordType=recordTypeService.getById(dto.getId());
			if(recordType==null) {
				throw new IllegalStateException("Tried to modify a non-existant Record");
			}
		}
		else {
			recordType = new RecordType();
		}
		
		recordType.setId(dto.getId());
		recordType.setName(dto.getName());
		
		if(dto.getColumn1()!=null) {
			recordType.setColumn1(dto.getColumn1());
		}
		if(dto.getColumn2()!=null) {
			recordType.setColumn2(dto.getColumn2());
		}
		if(dto.getColumn3()!=null) {
			recordType.setColumn3(dto.getColumn3());
		}
		if(dto.getColumn4()!=null) {
			recordType.setColumn4(dto.getColumn4());
		}
		if(dto.getColumn5()!=null) {
			recordType.setColumn5(dto.getColumn5());
		}
		if(dto.getColumn6()!=null) {
			recordType.setColumn6(dto.getColumn6());
		}
		if(dto.getColumn7()!=null) {
			recordType.setColumn7(dto.getColumn7());
		}
		if(dto.getColumn8()!=null) {
			recordType.setColumn8(dto.getColumn8());
		}
		if(dto.getColumn9()!=null) {
			recordType.setColumn9(dto.getColumn9());
		}
	
		return recordType;
	}
	
	
	
	public List<RecordType> convert (List<RecordTypeDTO> dtoRecords){
		List<RecordType> recordTypes = new ArrayList<>();
		
		for(RecordTypeDTO dto : dtoRecords){
			recordTypes.add(convert(dto));
		}
		
		return recordTypes;
	}

}
