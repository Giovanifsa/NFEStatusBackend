package giovani.nfestatusproj.nfestatus.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import giovani.nfestatusproj.nfestatus.database.eao.NFEStatusSnapshotEAO;
import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;
import giovani.nfestatusproj.nfestatus.exceptions.InternalErrorException;

@Component
public class DownloadNFEStatusSnapshotService {
	private static final String URL_NFE_FAZENDA_DISPONIBILIDADE = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
	
	private static final String NFESTATUS_ONLINE_IMG = "<img src=\"imagens/bola_verde_P.png\">";
	private static final String NFESTATUS_FAILING_IMG = "<img src=\"imagens/bola_amarela_P.png\">";
	private static final String NFESTATUS_OFFLINE_IMG = "<img src=\"imagens/bola_vermelho_P.png\">";
	
	private static final int COLUMN_EVENT4_RECEPTION = 8;
	private static final int COLUMN_REGISTER4_QUERY = 7;
	private static final int COLUMN_AVERAGETIME = 6;
	private static final int COLUMN_SERVICE4_STATUS = 5;
	private static final int COLUMN_PROTOCOL4_QUERY = 4;
	private static final int COLUMN_INUTILISATION4 = 3;
	private static final int COLUMN_AUTHORIZATION4_RETURN = 2;
	private static final int COLUMN_AUTHORIZATION4 = 1;
	private static final int COLUMN_AUTHORIZER = 0;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NFEStatusSnapshotEAO nfeStatusSnapshotEAO;
	
	public void downloadNFEStatus() {
		Collection<NFEStatusSnapshot> snapshots = parseStatusTableNFEFazendaDisnponibilidade();
		persistSnapshots(snapshots);
	}

	private void persistSnapshots(Collection<NFEStatusSnapshot> snapshots) {
		for (NFEStatusSnapshot snapshot : snapshots) {
			nfeStatusSnapshotEAO.save(snapshot);
		}
	}

	private Collection<NFEStatusSnapshot> parseStatusTableNFEFazendaDisnponibilidade() {
		try {
			logger.info("Connecting to the NFE Status endpoint...");
			
			Document doc = Jsoup.connect(URL_NFE_FAZENDA_DISPONIBILIDADE).get();
			
			logger.info("Connected. Parsing status table content...");
			
			Element divTableParent = doc.getElementById("conteudoDinamico");
			
			Element tableElements = divTableParent.selectFirst("table");
			Elements tableRows = tableElements.select("tr");
			
			Element tableHeader = tableRows.get(0);
			Elements tableHeaderColumns = tableHeader.select("th");
			
			HashMap<Integer, NFEStatusSnapshot> rowsSnapshots = new HashMap<>();
			
			for (int idxColumn = 0; idxColumn < tableHeaderColumns.size(); idxColumn++) {
				for (int idxRow = 1; idxRow < tableRows.size(); idxRow++) {
					NFEStatusSnapshot snapshot = rowsSnapshots.getOrDefault(idxRow, new NFEStatusSnapshot());
					snapshot.setCaptureMomentIfUnset(new Date());
					
					Element tableRow = tableRows.get(idxRow);
					Elements tableRowColumns = tableRow.select("td");
					
					String columnContent = tableRowColumns.get(idxColumn).html();
					
					switch (idxColumn) {
						case COLUMN_AUTHORIZER: {
							EnumAuthorizer authorizer = EnumAuthorizer.parseInitials(columnContent);
							snapshot.setAuthorizer(authorizer);
							
							break;
						}
						
						case COLUMN_AUTHORIZATION4: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusAuthorization4(nfeStatus);
							
							break;
						}
						
						case COLUMN_AUTHORIZATION4_RETURN: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusAuthorization4Return(nfeStatus);
							
							break;
						}
						
						case COLUMN_INUTILISATION4: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusInutilisation4(nfeStatus);
							
							break;
						}
						
						case COLUMN_PROTOCOL4_QUERY: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusProtocol4Query(nfeStatus);
							
							break;
						}
						
						case COLUMN_SERVICE4_STATUS: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusService4Status(nfeStatus);
							
							break;
						}
						
						case COLUMN_AVERAGETIME: {
							//Not implementated - Unknown data type
							break;
						}
						
						case COLUMN_REGISTER4_QUERY: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusRegister4Query(nfeStatus);
							
							break;
						}
						
						case COLUMN_EVENT4_RECEPTION: {
							EnumNFEStatus nfeStatus = parseNFEStatus(columnContent);
							snapshot.setNfeStatusEvent4Reception(nfeStatus);
							
							break;
						}
					}
					
					rowsSnapshots.put(idxRow, snapshot);
				}
			}
			
			Collection<NFEStatusSnapshot> values = rowsSnapshots.values();
			
			logger.info("Parsed {} snapshots.", values.size());
			
			return values;
		}

		catch (Throwable th) {
			throw new InternalErrorException(th);
		}
	}
	
	private EnumNFEStatus parseNFEStatus(String htmlContent) {
		switch (htmlContent) {
			case NFESTATUS_ONLINE_IMG: return EnumNFEStatus.ONLINE;
			case NFESTATUS_FAILING_IMG: return EnumNFEStatus.FAILING;
			case NFESTATUS_OFFLINE_IMG: return EnumNFEStatus.OFFLINE;
			default: return EnumNFEStatus.UNKNOWN;
		}
	}
}
