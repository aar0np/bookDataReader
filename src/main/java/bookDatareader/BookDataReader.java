package bookDatareader;

import com.datastax.oss.driver.api.core.CqlSession;

import bookDatareader.book.BookEntity;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

public class BookDataReader {

	public static void main(String[] args) {
		String secureConnectPath = System.getenv("ASTRA_BUNDLE_PATH");
		String clientID = System.getenv("ASTRA_CLIENT_ID");
		String secret = System.getenv("ASTRA_CLIENT_SECRET");
		
		try (CqlSession session = CqlSession.builder()
			.withCloudSecureConnectBundle(Paths.get(secureConnectPath))
			.withAuthCredentials(clientID,secret)
			.withKeyspace("stackoverflow")
			.build()) {
		
			CassandraOperations template = new CassandraTemplate(session);
	
			BookEntity musicoterapia = template.selectOne(Query.query(Criteria.where("id").is("OL19260825W"))
					, BookEntity.class);
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
			String dateStr = "2022-03-03T09:52:33.235555";
			
			musicoterapia.setPublishedDate2(LocalDate.parse(dateStr,dateFormat).toString());
			musicoterapia.setPublishedDate3(LocalDate.parse(dateStr,dateFormat));
			
			template.insert(musicoterapia);
			
			System.out.println(musicoterapia.getBookName());
			System.out.println(musicoterapia.getPublishedDate());
			System.out.println(musicoterapia.getPublishedDate2());
			System.out.println(musicoterapia.getPublishedDate3());
				
		}
		
		System.exit(0);
	}
}
