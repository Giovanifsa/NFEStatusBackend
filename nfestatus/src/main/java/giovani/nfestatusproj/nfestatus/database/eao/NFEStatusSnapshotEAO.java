package giovani.nfestatusproj.nfestatus.database.eao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import giovani.nfestatusproj.nfestatus.database.eao.custom.CustomNFEStatusSnapshotEAO;
import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

@Component
public interface NFEStatusSnapshotEAO extends JpaRepository<NFEStatusSnapshot, Long>, CustomNFEStatusSnapshotEAO {
	@Query(" SELECT nfe "
			+ "FROM NFEStatusSnapshot nfe "
			+ "WHERE nfe.authorizer IN ?1 "
			+ "AND nfe.captureMoment >= ?2 "
			+ "AND ( "
			+ "		?3 = FALSE "
			+ "		OR nfe.captureMoment = ( "
			+ "			SELECT MAX(sub_nfe.captureMoment) "	
			+ "			FROM NFEStatusSnapshot sub_nfe "
			+ "			WHERE sub_nfe.authorizer = nfe.authorizer "
			+ "		) "
			+ ") "
			+ "ORDER BY nfe.captureMoment DESC ")
	Page<NFEStatusSnapshot> findByAuthorizersAndCaptureMomentPaginated(List<EnumAuthorizer> authorizers, 
																	   Date captureMoment, 
																	   Boolean distinctByAuthorizerLatest, 
																	   Pageable paging);
	
	@Query(" SELECT nfe "
			+ "FROM NFEStatusSnapshot nfe "
			+ "WHERE nfe.authorizer IN ?1 "
			+ "AND ( "
			+ "		?2 = FALSE "
			+ "		OR nfe.captureMoment = ( "
			+ "			SELECT MAX(sub_nfe.captureMoment) "	
			+ "			FROM NFEStatusSnapshot sub_nfe "
			+ "			WHERE sub_nfe.authorizer = nfe.authorizer "
			+ "		) "
			+ ") "
			+ "ORDER BY nfe.captureMoment DESC ")
	Page<NFEStatusSnapshot> findByAuthorizersPaginated(List<EnumAuthorizer> authorizers, 
													   Boolean distinctByAuthorizerLatest, 
													   Pageable paging);
}
