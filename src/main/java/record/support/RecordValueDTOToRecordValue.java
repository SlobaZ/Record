package record.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import record.dto.RecordValueDTO;
import record.model.RecordType;
import record.model.RecordValue;
import record.service.RecordTypeService;
import record.service.RecordValueService;

@Component
public class RecordValueDTOToRecordValue implements Converter<RecordValueDTO, RecordValue>{
	
	@Autowired
	private RecordValueService recordValueService;
	
	@Autowired
	private RecordTypeService recordTypeService;

	@Override
	public RecordValue convert(RecordValueDTO dto) {
		
		RecordType recordType = recordTypeService.getById(dto.getRecordTypeId());
		RecordValue recordValue = null;
		if(dto.getId()!=null) {
			
			recordValue = recordValueService.getById(dto.getId());
			
		}
		else {
			recordValue = new RecordValue();
		}
		
		recordValue.setId(dto.getId());
		recordValue.setName(dto.getName());
		
		if(dto.getColumn1()!=null) {
			recordValue.setColumn1(dto.getColumn1());
		}
		if(dto.getColumn2()!=null) {
			recordValue.setColumn2(dto.getColumn2());
		}
		if(dto.getColumn3()!=null) {
			recordValue.setColumn3(dto.getColumn3());
		}
		if(dto.getColumn4()!=null) {
			recordValue.setColumn4(dto.getColumn4());
		}
		if(dto.getColumn5()!=null) {
			recordValue.setColumn5(dto.getColumn5());
		}
		if(dto.getColumn6()!=null) {
			recordValue.setColumn6(dto.getColumn6());
		}
		if(dto.getColumn7()!=null) {
			recordValue.setColumn7(dto.getColumn7());
		}
		if(dto.getColumn8()!=null) {
			recordValue.setColumn8(dto.getColumn8());
		}
		if(dto.getColumn9()!=null) {
			recordValue.setColumn9(dto.getColumn9());
		}
		
		if(recordType!=null) {
		recordValue.setRecordType(recordType);
		}
		return recordValue;
	}
	
	
	public List<RecordValue> convert (List<RecordValueDTO> dtoRecords){
		List<RecordValue> recordValues = new ArrayList<>();
		
		for(RecordValueDTO dto : dtoRecords){
			recordValues.add(convert(dto));
		}
		
		return recordValues;
	}
	

}
