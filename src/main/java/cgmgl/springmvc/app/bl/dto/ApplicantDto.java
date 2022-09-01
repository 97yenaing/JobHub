package cgmgl.springmvc.app.bl.dto;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDto {
	private User user;
	
	private long applicantId;
	
	private String profile;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String job_exp_year;
	
	@NotEmpty
	private String job_history;
	
	@NotEmpty
	private String edu_bg;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String address;

	private String certificates;
	
	public ApplicantDto(ApplicantInfo applicantInfo) {
		this.applicantId = applicantInfo.getId();
		this.profile = applicantInfo.getProfile();
		this.phone = applicantInfo.getPhone();
		this.job_exp_year = applicantInfo.getJob_exp_year();
		this.job_history = applicantInfo.getJob_history();
		this.gender = applicantInfo.getGender();
		this.edu_bg = applicantInfo.getEdu_bg();
		this.address = applicantInfo.getAddress();
		this.certificates = applicantInfo.getCertificates();
		}
}