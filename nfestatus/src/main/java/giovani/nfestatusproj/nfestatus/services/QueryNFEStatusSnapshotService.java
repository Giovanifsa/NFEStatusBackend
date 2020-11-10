package giovani.nfestatusproj.nfestatus.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterCommonBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterMostUnavailableBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterMostUnavailableResultBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterResultBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotMostUnavailableBean;
import giovani.nfestatusproj.nfestatus.database.eao.NFEStatusSnapshotEAO;
import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;
import giovani.nfestatusproj.nfestatus.database.enums.EnumService;
import giovani.nfestatusproj.nfestatus.exceptions.ClientErrorException;
import giovani.nfestatusproj.nfestatus.utils.BooleanUtils;
import giovani.nfestatusproj.nfestatus.utils.ListUtils;
import giovani.nfestatusproj.nfestatus.utils.ObjectCounter;
import giovani.nfestatusproj.nfestatus.utils.ObjectCounting;

@Component
public class QueryNFEStatusSnapshotService {
	@Autowired
	private NFEStatusSnapshotEAO nfeStatusSnapshotEAO;
	
	public NFEStatusSnapshotFilterResultBean queryByAuthorizersAndDatePaginated(NFEStatusSnapshotFilterBean filter) {
		validateNFEStatusSnapshotFilterCommonBean(filter);
		
		Pageable pagination = PageRequest.of(filter.getPage(), filter.getRows());
		
		if (!ListUtils.isEmpty(filter.getAuthorizers())) {
			Page<NFEStatusSnapshot> page;
			
			if (filter.getCaptureMoment() != null) {
				page = nfeStatusSnapshotEAO.findByAuthorizersAndCaptureMomentPaginated(filter.getAuthorizers(), 
																					   filter.getCaptureMoment(),
																					   BooleanUtils.isTrue(filter.getDistinctByAuthorizerLatest()),
																					   pagination);
				
			}
			
			else {
				page = nfeStatusSnapshotEAO.findByAuthorizersPaginated(filter.getAuthorizers(), 
																	   BooleanUtils.isTrue(filter.getDistinctByAuthorizerLatest()), 
																	   pagination);
			}
			
			return NFEStatusSnapshotFilterResultBean.ofPage(page);
		}
		
		return NFEStatusSnapshotFilterResultBean.empty();
	}
	
	public NFEStatusSnapshotFilterMostUnavailableResultBean queryByMostUnavailableServicesPaginated(NFEStatusSnapshotFilterMostUnavailableBean filter) {
		validateNFEStatusSnapshotFilterCommonBean(filter);
		
		List<EnumService> filterServices = filter.getServices();
		
		if (!ListUtils.isEmpty(filterServices)) {
			List<NFEStatusSnapshotMostUnavailableBean> results = new ArrayList<>();
			
			List<EnumNFEStatus> statusToSearchFor = BooleanUtils.isTrue(filter.getTreatUnknownStatusAsOffline()) ?
													Arrays.asList(EnumNFEStatus.OFFLINE, EnumNFEStatus.UNKNOWN) :
													Arrays.asList(EnumNFEStatus.OFFLINE);
			
			for (EnumService service : filterServices) {
				ObjectCounter<EnumAuthorizer> counter = new ObjectCounter<>();
				
				for (EnumAuthorizer authorizer : EnumAuthorizer.values()) {
					Long quantity = nfeStatusSnapshotEAO.countByAuthorizerAndServiceStatus(authorizer, 
																						   service, 
																						   statusToSearchFor);
					
					counter.count(authorizer, quantity);
				}
				
				ObjectCounting<EnumAuthorizer> mostCounted = counter.getMostCounted();
				
				if (mostCounted.getCount() != 0) {
					NFEStatusSnapshot latest = 
							nfeStatusSnapshotEAO.findLatestByAuthorizerAndServiceStatus(mostCounted.getObject(), 
																						service, 
																						statusToSearchFor);
					
					NFEStatusSnapshotMostUnavailableBean resultBean = new NFEStatusSnapshotMostUnavailableBean();
					resultBean.setAuthorizer(mostCounted.getObject());
					resultBean.setLastUnavailableMoment(latest.getCaptureMoment());
					resultBean.setService(service);
					resultBean.setUnavailableCount(mostCounted.getCount());
					
					results.add(resultBean);
				}
			}
			
			NFEStatusSnapshotFilterMostUnavailableResultBean resultReturn = 
						new NFEStatusSnapshotFilterMostUnavailableResultBean();
			
			resultReturn.setResults(ListUtils.paginate(results, filter.getPage(), filter.getRows()));
			resultReturn.setTotalRecords((long) results.size());
			
			return resultReturn;
		}
		
		return NFEStatusSnapshotFilterMostUnavailableResultBean.empty();
	}
	
	private void validateNFEStatusSnapshotFilterCommonBean(NFEStatusSnapshotFilterCommonBean filter) {
		String className = filter.getClass().getSimpleName();
		
		if (filter.getPage() == null || filter.getPage() < 0) {
			raiseInvalidFilterState(className + "[page] must be not null and above or equals to 0.");
		}
		
		if (filter.getRows() == null || filter.getRows() < 1) {
			raiseInvalidFilterState(className + "[rows] must be not null and above or equals to 1.");
		}
	}

	private void raiseInvalidFilterState(String message) {
		throw new ClientErrorException(message);
	}
}
