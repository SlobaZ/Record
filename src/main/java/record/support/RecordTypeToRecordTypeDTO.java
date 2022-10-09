package record.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import record.dto.RecordTypeDTO;
import record.model.RecordType;

@Component
public class RecordTypeToRecordTypeDTO implements Converter<RecordType, RecordTypeDTO>{

	@Override
	public RecordTypeDTO convert(RecordType recordType) {
		if(recordType==null) {
			return null;
		}
		RecordTypeDTO dto = new RecordTypeDTO();
		
		dto.setId(recordType.getId());
		dto.setName(recordType.getName());
		
		if(recordType.getColumn1()!=null) {
			dto.setColumn1(recordType.getColumn1());
		}
		if(recordType.getColumn2()!=null) {
			dto.setColumn2(recordType.getColumn2());
		}
		if(recordType.getColumn3()!=null) {
			dto.setColumn3(recordType.getColumn3());
		}
		if(recordType.getColumn4()!=null) {
			dto.setColumn4(recordType.getColumn4());
		}
		if(recordType.getColumn5()!=null) {
			dto.setColumn5(recordType.getColumn5());
		}
		if(recordType.getColumn6()!=null) {
			dto.setColumn6(recordType.getColumn6());
		}
		if(recordType.getColumn7()!=null) {
			dto.setColumn7(recordType.getColumn7());
		}
		if(recordType.getColumn8()!=null) {
			dto.setColumn8(recordType.getColumn8());
		}
		if(recordType.getColumn9()!=null) {
			dto.setColumn9(recordType.getColumn9());
		}
		
		return dto;
	}
	
	
	
	public List<RecordTypeDTO> convert(List<RecordType> recordTypes){
		List<RecordTypeDTO> ret = new ArrayList<>();
		
		for(RecordType r: recordTypes){
			ret.add(convert(r));
		}
		
		return ret;
	}

}
