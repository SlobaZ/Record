package record.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import record.dto.RecordValueDTO;
import record.model.RecordValue;

@Component
public class RecordValueToRecordValueDTO implements Converter<RecordValue, RecordValueDTO>{

	@Override
	public RecordValueDTO convert(RecordValue recordValue) {
		
		if(recordValue==null) {
			return null;
		}
		RecordValueDTO dto = new RecordValueDTO();
		
		dto.setId(recordValue.getId());
		dto.setName(recordValue.getName()); 
		
		if(recordValue.getColumn1()!=null) {
			dto.setColumn1(recordValue.getColumn1());
		}
		if(recordValue.getColumn2()!=null) {
			dto.setColumn2(recordValue.getColumn2());
		}
		if(recordValue.getColumn3()!=null) {
			dto.setColumn3(recordValue.getColumn3());
		}
		if(recordValue.getColumn4()!=null) {
			dto.setColumn4(recordValue.getColumn4());
		}
		if(recordValue.getColumn5()!=null) {
			dto.setColumn5(recordValue.getColumn5());
		}
		if(recordValue.getColumn6()!=null) {
			dto.setColumn6(recordValue.getColumn6());
		}
		if(recordValue.getColumn7()!=null) {
			dto.setColumn7(recordValue.getColumn7());
		}
		if(recordValue.getColumn8()!=null) {
			dto.setColumn8(recordValue.getColumn8());
		}
		if(recordValue.getColumn9()!=null) {
			dto.setColumn9(recordValue.getColumn9());
		}
		
		dto.setRecordTypeId(recordValue.getRecordType().getId());
		dto.setRecordTypeName(recordValue.getRecordType().getName());
		
		return dto;
	}
	
	
	
	
	public List<RecordValueDTO> convert(List<RecordValue> recordValues){
		List<RecordValueDTO> ret = new ArrayList<>();
		
		for(RecordValue r: recordValues){
			ret.add(convert(r));
		}
		
		return ret;
	}
	
	
	
	
	

}
