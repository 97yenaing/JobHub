package cgmgl.springmvc.app.persistence.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant_jobpost")
public class ApplicantJobPost {
    @Id
    @Column(name = "applicantJob_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private ApplicantInfo applicantInfo;

    @ManyToOne
    @JoinColumn(name = "jobPost_id")
    private JobPost jobPost;

    @Column(name = "expected_salary")
    private long expected_salary;

    @Column(name = "apply_date")
    private Date apply_date;

    @Column(name = "apply_reason")
    private String apply_reason;

    @Column(name = "cv_file_name")
    private String cv_file_name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file_data", nullable = false)
    private byte[] file_data;

    @Column(name = "status")
    private String status;

    public ApplicantJobPost(ApplicantJobPostDto applicantJobPostDto) {
        this.id = applicantJobPostDto.getId();
        this.applicantInfo = applicantJobPostDto.getApplicantInfo();
        this.jobPost = applicantJobPostDto.getJobPost();
        this.expected_salary = applicantJobPostDto.getExpected_salary();
        this.apply_date = applicantJobPostDto.getApply_date();
        this.apply_reason = applicantJobPostDto.getApply_reason();
        this.cv_file_name = applicantJobPostDto.getCv_file_name();
        this.status = applicantJobPostDto.getStatus();
    }
}