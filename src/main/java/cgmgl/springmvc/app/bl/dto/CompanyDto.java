package cgmgl.springmvc.app.bl.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {
	@NotEmpty
	private int company_id;

	@NotEmpty
	private String company_name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String address;
	
	private String Web_link;
	
	
	@NotEmpty
	private Date created_at;
	
	private Date updated_at;
	
	private Date deleted_at;
	
	public CompanyDto(Company Company) {
		super();
		this.company_id=Company.getCompany_id();
		this.company_name=Company.getCompany_name();
		this.email=Company.getEmail();
		this.address=Company.getAddress();
		this.created_at=Company.getCreated_at();
		this.updated_at=Company.getCreated_at();
		this.deleted_at=Company.getCreated_at();
		this.Web_link=Company.getWeb_link();
	}

}
