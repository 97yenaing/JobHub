package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant_info")
public class ApplicantInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	private long id;

	private String profile;

	private String phone;

	private String job_exp_year;

	private String job_history;

	private String edu_bg;

	private String gender;

	private String address;

	private String certificates;
	
	public ApplicantInfo(ApplicantDto applicantDto)
	{
		this.id = applicantDto.getApplicantId();
		this.profile = applicantDto.getProfile();
		this.phone = applicantDto.getPhone();
		this.job_exp_year = applicantDto.getJob_exp_year();
		this.job_history = applicantDto.getJob_history();
		this.edu_bg = applicantDto.getEdu_bg();
		this.gender = applicantDto.getGender();
		this.address = applicantDto.getAddress();
		this.certificates = applicantDto.getCertificates();
	}
}