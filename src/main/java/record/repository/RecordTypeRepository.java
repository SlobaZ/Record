package record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import record.model.RecordType;

@Repository
public interface RecordTypeRepository extends JpaRepository<RecordType, Integer>{
	
	List<RecordType> findByNameLike(String name);

}
