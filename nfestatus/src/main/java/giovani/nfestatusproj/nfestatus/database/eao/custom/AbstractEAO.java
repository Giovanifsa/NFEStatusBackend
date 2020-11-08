package giovani.nfestatusproj.nfestatus.database.eao.custom;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class AbstractEAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	protected <T> TypedQuery<T> createTypedQuery(CharSequence charSequence, Class<T> typeClass) {
		return entityManager.createQuery(charSequence.toString(), typeClass);
	}
	
	protected <T> T getSingleResult(TypedQuery<T> query) {
		try {
			return query.getSingleResult();
		}
		
		catch (NoResultException e) {
			return null;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
