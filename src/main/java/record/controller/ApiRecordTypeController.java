package record.controller;

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

import record.dto.RecordTypeDTO;
import record.excel.ExcelRecord;
import record.model.RecordType;
import record.service.RecordTypeService;
import record.support.RecordTypeDTOToRecordType;
import record.support.RecordTypeToRecordTypeDTO;

import java.io.IOException;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/recordtypes")
public class ApiRecordTypeController {
	
	@Autowired
	private RecordTypeService recordTypeService;
	
	@Autowired
	private RecordTypeToRecordTypeDTO toDTO;
	
	@Autowired
	private RecordTypeDTOToRecordType toRecordType;
	
	
	@GetMapping()
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<List<RecordTypeDTO>> getAll(@RequestParam(required = false) String name){
		
		if(name=="") {
			name=null;
		}
		
		List<RecordType> recordTypes =null;
		if(name!=null) {
			recordTypes = recordTypeService.findByNameLike(name);
		}
		else {
			recordTypes = recordTypeService.findAll();
		}
		return new ResponseEntity<>(toDTO.convert(recordTypes), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<RecordTypeDTO> getById(@PathVariable Integer id){
		RecordType recordType = recordTypeService.getById(id);
		if(recordType==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		return new ResponseEntity<>(toDTO.convert(recordType), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RecordTypeDTO> delete(@PathVariable Integer id){
		RecordType deleted = recordTypeService.delete(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);	
	}
	
	
	@PostMapping(consumes="application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RecordTypeDTO> addRecord(@Valid @RequestBody RecordTypeDTO newRecordDTO){
		if(newRecordDTO==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		RecordType savedRecord = recordTypeService.save(toRecordType.convert(newRecordDTO));
		return new ResponseEntity<>(toDTO.convert(savedRecord), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RecordTypeDTO> editRecord(@PathVariable Integer id, @Valid @RequestBody RecordTypeDTO recordTypeDTO){
		RecordType persisted = recordTypeService.getById(id);
		if(persisted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		persisted.setId(recordTypeDTO.getId());
		persisted.setName(recordTypeDTO.getName());
		persisted.setColumn1(recordTypeDTO.getColumn1());
		persisted.setColumn2(recordTypeDTO.getColumn2());
		persisted.setColumn3(recordTypeDTO.getColumn3());
		persisted.setColumn4(recordTypeDTO.getColumn4());
		persisted.setColumn5(recordTypeDTO.getColumn5());
		persisted.setColumn6(recordTypeDTO.getColumn6());
		persisted.setColumn7(recordTypeDTO.getColumn7());
		persisted.setColumn8(recordTypeDTO.getColumn8());
		persisted.setColumn9(recordTypeDTO.getColumn9());
		recordTypeService.save(persisted);
		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}
	
	
	@GetMapping("/excel")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<Void> getAllExcel() throws IOException{
		
		List<RecordType> recordTypes = recordTypeService.findAll();
		
		ExcelRecord.excelType(recordTypes);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
