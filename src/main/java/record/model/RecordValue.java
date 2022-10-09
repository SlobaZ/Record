package record.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="recordValue")
public class RecordValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	@NotEmpty(message="*Please provide a name")
	private String name;
	
	@Size(max = 100)
	@Column
	private String column1;
	
	@Size(max = 100)
	@Column
	private String column2;
	
	@Size(max = 100)
	@Column
	private String column3;
	
	@Size(max = 100)
	@Column
	private String column4;
	
	@Size(max = 100)
	@Column
	private String column5;
	
	@Size(max = 100)
	@Column
	private String column6;
	
	@Size(max = 100)
	@Column
	private String column7;
	
	@Size(max = 100)
	@Column
	private String column8;
	
	@Size(max = 100)
	@Column
	private String column9;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="recordType")
	private RecordType recordType;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	public String getColumn6() {
		return column6;
	}

	public void setColumn6(String column6) {
		this.column6 = column6;
	}

	public String getColumn7() {
		return column7;
	}

	public void setColumn7(String column7) {
		this.column7 = column7;
	}

	public String getColumn8() {
		return column8;
	}

	public void setColumn8(String column8) {
		this.column8 = column8;
	}

	public String getColumn9() {
		return column9;
	}

	public void setColumn9(String column9) {
		this.column9 = column9;
	}


	
	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
		if(!recordType.getRecordValues().contains(this)) {
			recordType.getRecordValues().add(this);
		}
	}
	
	
	
	

}
