package record.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import record.dto.RecordValueDTO;
import record.excel.ExcelRecord;
import record.model.RecordType;
import record.model.RecordValue;
import record.service.RecordTypeService;
import record.service.RecordValueService;
import record.support.RecordValueDTOToRecordValue;
import record.support.RecordValueToRecordValueDTO;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/recordtypes/{recordTypeId}/recordvalues")
public class ApiRecordValueController {
	
	@Autowired
	private RecordValueService recordValueService;
	
	@Autowired
	private RecordValueToRecordValueDTO toDTO;
	
	@Autowired
	private RecordValueDTOToRecordValue toRecordValue;
	
	@Autowired
	private RecordTypeService recordTypeService;
	
	
	
	@GetMapping()
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<List<RecordValueDTO>> getAllByRecordTypeId(@PathVariable Integer recordTypeId, @RequestParam(required = false) String name){
		
		if(name=="") {
			name=null;
		}
		
		List<RecordValue> recordValues = null;
		
		if(name!=null) {
			recordValues = recordValueService.findByRecordTypeIdAndNameLike(recordTypeId, name);
		}
		else {
			recordValues = recordValueService.findByRecordTypeId(recordTypeId);
		}
		
		return new ResponseEntity<>(toDTO.convert(recordValues),  HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<RecordValueDTO> getById(@PathVariable Integer id){
		RecordValue recordValue = recordValueService.getById(id);
		if(recordValue==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		return new ResponseEntity<>(toDTO.convert(recordValue), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<RecordValueDTO> delete(@PathVariable Integer id){
		RecordValue deleted = recordValueService.delete(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);	
	}
	
	
	@PostMapping(consumes="application/json")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<RecordValueDTO> addRecordValue(@PathVariable Integer recordTypeId, @Valid @RequestBody RecordValueDTO newRecordDTO){
		if(newRecordDTO==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		newRecordDTO.setRecordTypeId(recordTypeId);
		RecordValue savedRecord = recordValueService.save(toRecordValue.convert(newRecordDTO));
		return new ResponseEntity<>(toDTO.convert(savedRecord), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<RecordValueDTO> editRecordValue(@PathVariable Integer recordTypeId, @PathVariable Integer id, @Valid @RequestBody RecordValueDTO recordValueDTO){
		RecordValue persisted = recordValueService.getById(id);
		if(persisted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		persisted.setId(recordValueDTO.getId());
		persisted.setName(recordValueDTO.getName());
		persisted.setColumn1(recordValueDTO.getColumn1());
		persisted.setColumn2(recordValueDTO.getColumn2());
		persisted.setColumn3(recordValueDTO.getColumn3());
		persisted.setColumn4(recordValueDTO.getColumn4());
		persisted.setColumn5(recordValueDTO.getColumn5());
		persisted.setColumn6(recordValueDTO.getColumn6());
		persisted.setColumn7(recordValueDTO.getColumn7());
		persisted.setColumn8(recordValueDTO.getColumn8());
		persisted.setColumn9(recordValueDTO.getColumn9());
		
		RecordType recordType = recordTypeService.getById(recordTypeId);
		persisted.setRecordType(recordType);
		
		recordValueService.save(persisted);
		
		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}
	
	
	@GetMapping("/excel")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<Void> getAllByRecordTypeIdExcel(@PathVariable Integer recordTypeId) throws IOException{

		List<RecordValue> recordValues = recordValueService.findByRecordTypeId(recordTypeId);
		RecordType rt = recordTypeService.getById(recordTypeId);
		
		ExcelRecord.excelValue(recordValues, rt);
				
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	

	
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
