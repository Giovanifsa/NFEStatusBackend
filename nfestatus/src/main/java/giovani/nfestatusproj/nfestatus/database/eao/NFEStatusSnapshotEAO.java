package giovani.nfestatusproj.nfestatus.database.eao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

@Component
public interface NFEStatusSnapshotEAO extends JpaRepository<NFEStatusSnapshot, Long> {
	
	@Query("select nfe from NFEStatusSnapshot nfe where nfe.authorizer = ?1")
	List<NFEStatusSnapshot> findByAuthorizer(EnumAuthorizer authorizer);
	
	@Query("select nfe from NFEStatusSnapshot nfe")
	Page<NFEStatusSnapshot> findPaginated(Pageable paging);
}
