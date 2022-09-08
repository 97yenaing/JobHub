package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    private Date deleted_at;

    /*
     * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     * 
     * @JoinTable(name = "applicant_jobPost", joinColumns = @JoinColumn(name =
     * "info_id"), inverseJoinColumns = @JoinColumn(name = "post_id")) private
     * List<JobPost> jobPosts = new ArrayList<JobPost>();
     */

    public ApplicantInfo(ApplicantDto applicantDto) {
        this.id = applicantDto.getApplicantId();
        this.profile = applicantDto.getProfile();
        this.phone = applicantDto.getPhone();
        this.job_exp_year = applicantDto.getJob_exp_year();
        this.job_history = applicantDto.getJob_history();
        this.edu_bg = applicantDto.getEdu_bg();
        this.gender = applicantDto.getGender();
        this.address = applicantDto.getAddress();
        this.certificates = applicantDto.getCertificates();
        this.deleted_at = applicantDto.getDeleted_at();
        //this.jobPosts = applicantDto.getJobPosts();
    }
}