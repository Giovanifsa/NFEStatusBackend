package giovani.nfestatusproj.nfestatus.database.eao.custom;

import java.util.List;

import javax.persistence.TypedQuery;

import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;
import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public class CustomNFEStatusSnapshotEAOImpl extends AbstractEAO implements CustomNFEStatusSnapshotEAO {
	@Override
	public Long countByAuthorizerAndServiceStatus(EnumAuthorizer authorizer, EnumService service, List<EnumNFEStatus> status) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT COALESCE(COUNT(nfe), 0) ");
		jpql.append(" FROM NFEStatusSnapshot nfe ");
		jpql.append(" WHERE nfe.authorizer = :authorizer ");
		jpql.append(" AND nfe." + service.getEntityField() + " IN :status ");
		
		TypedQuery<Long> query = createTypedQuery(jpql, Long.class);
		query.setParameter("authorizer", authorizer);
		query.setParameter("status", status);
		
		return getSingleResult(query);
	}
	
	@Override
	public NFEStatusSnapshot findLatestByAuthorizerAndServiceStatus(EnumAuthorizer authorizer, EnumService service, List<EnumNFEStatus> status) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT nfe ");
		jpql.append(" FROM NFEStatusSnapshot nfe ");
		jpql.append(" WHERE nfe.authorizer = :authorizer ");
		jpql.append(" AND nfe." + service.getEntityField() + " IN :status ");
		jpql.append(" ORDER BY nfe.captureMoment DESC ");
		
		TypedQuery<NFEStatusSnapshot> query = createTypedQuery(jpql, NFEStatusSnapshot.class);
		query.setParameter("authorizer", authorizer);
		query.setParameter("status", status);
		query.setMaxResults(1);
		
		return getSingleResult(query);
	}
}
