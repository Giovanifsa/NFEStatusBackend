package giovani.nfestatusproj.nfestatus.database.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;

@Entity
public class NFEStatusSnapshot extends AbstractEntity {
	private static final long serialVersionUID = 1046397698105724556L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNFEStatusSnapshot;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date captureMoment;
	
	@Enumerated
	private EnumAuthorizer authorizer;
	
	@Enumerated
	private EnumNFEStatus nfeStatusAuthorization4;
	
	@Enumerated
	private EnumNFEStatus nfeStatusAuthorization4Return;
	
	@Enumerated
	private EnumNFEStatus nfeStatusInutilisation4;
	
	@Enumerated
	private EnumNFEStatus nfeStatusProtocol4Query;
	
	@Enumerated
	private EnumNFEStatus nfeStatusService4Status;
	
	private Long averageTimeMilis;
	
	@Enumerated
	private EnumNFEStatus nfeStatusRegister4Query;
	
	@Enumerated
	private EnumNFEStatus nfeStatusEvent4Reception;

	public Long getIdNFEStatusSnapshot() {
		return idNFEStatusSnapshot;
	}

	public void setIdNFEStatusSnapshot(Long idNFEStatusSnapshot) {
		this.idNFEStatusSnapshot = idNFEStatusSnapshot;
	}

	public Date getCaptureMoment() {
		return captureMoment;
	}

	public void setCaptureMoment(Date captureMoment) {
		this.captureMoment = captureMoment;
	}
	
	public void setCaptureMomentIfUnset(Date captureMoment) {
		if (this.captureMoment == null) {
			this.setCaptureMoment(captureMoment);
		}
	}

	public EnumAuthorizer getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(EnumAuthorizer authorizer) {
		this.authorizer = authorizer;
	}

	public EnumNFEStatus getNfeStatusAuthorization4() {
		return nfeStatusAuthorization4;
	}

	public void setNfeStatusAuthorization4(EnumNFEStatus nfeStatusAuthorization4) {
		this.nfeStatusAuthorization4 = nfeStatusAuthorization4;
	}

	public EnumNFEStatus getNfeStatusAuthorization4Return() {
		return nfeStatusAuthorization4Return;
	}

	public void setNfeStatusAuthorization4Return(EnumNFEStatus nfeStatusAuthorization4Return) {
		this.nfeStatusAuthorization4Return = nfeStatusAuthorization4Return;
	}

	public EnumNFEStatus getNfeStatusInutilisation4() {
		return nfeStatusInutilisation4;
	}

	public void setNfeStatusInutilisation4(EnumNFEStatus nfeStatusInutilisation4) {
		this.nfeStatusInutilisation4 = nfeStatusInutilisation4;
	}

	public EnumNFEStatus getNfeStatusProtocol4Query() {
		return nfeStatusProtocol4Query;
	}

	public void setNfeStatusProtocol4Query(EnumNFEStatus nfeStatusProtocol4Query) {
		this.nfeStatusProtocol4Query = nfeStatusProtocol4Query;
	}

	public EnumNFEStatus getNfeStatusService4Status() {
		return nfeStatusService4Status;
	}

	public void setNfeStatusService4Status(EnumNFEStatus nfeStatusService4Status) {
		this.nfeStatusService4Status = nfeStatusService4Status;
	}

	public Long getAverageTimeMilis() {
		return averageTimeMilis;
	}

	public void setAverageTimeMilis(Long averageTimeMilis) {
		this.averageTimeMilis = averageTimeMilis;
	}

	public EnumNFEStatus getNfeStatusRegister4Query() {
		return nfeStatusRegister4Query;
	}

	public void setNfeStatusRegister4Query(EnumNFEStatus nfeStatusRegister4Query) {
		this.nfeStatusRegister4Query = nfeStatusRegister4Query;
	}

	public EnumNFEStatus getNfeStatusEvent4Reception() {
		return nfeStatusEvent4Reception;
	}

	public void setNfeStatusEvent4Reception(EnumNFEStatus nfeStatusEvent4Reception) {
		this.nfeStatusEvent4Reception = nfeStatusEvent4Reception;
	}

	@Override
	public Long getId() {
		return getIdNFEStatusSnapshot();
	}
}
