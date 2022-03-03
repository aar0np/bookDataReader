package bookDatareader.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("book_by_id")
public class BookEntity {
	@PrimaryKey private String id;

	@Column("author_id")
    private List<String> authorId;
    
	@Column("author_names")
    private List<String> authorNames;
	
    @Column("book_description")
    private String bookDescription;
    
    @Column("book_name")
    private String bookName;
    
    @Column("cover_ids")
    private List<String> coverIds;
    
    @Column("published_date")
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate publishedDate;

    @Column("pubdate2")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String publishedDate2;

    @Column("pubdate3")
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate publishedDate3;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getAuthorId() {
		return authorId;
	}

	public void setAuthorId(List<String> authorId) {
		this.authorId = authorId;
	}

	public List<String> getAuthorNames() {
		return authorNames;
	}

	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<String> getCoverIds() {
		return coverIds;
	}

	public void setCoverIds(List<String> coverIds) {
		this.coverIds = coverIds;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public String getPublishedDate2() {
		return publishedDate2;
	}

	public void setPublishedDate2(String publishedDate2) {
		this.publishedDate2 = publishedDate2;
	}

	public LocalDate getPublishedDate3() {
		return publishedDate3;
	}

	public void setPublishedDate3(LocalDate publishedDate3) {
		this.publishedDate3 = publishedDate3;
	}
}
