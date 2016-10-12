import java.util.ArrayList;


public class TVSeries extends Films {

	private String startDate;
	private String endDate;
	private int seasonNumber;
	private int episodeNumber;
	private String writer;
	private String genre;
	
	public TVSeries(int filmId, String filmTitle, String language,String directors, int durationLength, String country,String performers,String genre,String writer,String startDate,String endDate, int seasonNumber,int episodeNumber){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setWriter(writer);
		setStartDate(startDate);
		setEndDate(endDate);
		setSeasonNumber(seasonNumber);
		setEpisodeNumber(episodeNumber);
		
	}
	public TVSeries(int filmId, String filmTitle, String language,String directors, int durationLength, String country,String performers,String genre,String writer,String startDate,String endDate, int seasonNumber,int episodeNumber,float ratingScore, int voteCount){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setWriter(writer);
		setStartDate(startDate);
		setEndDate(endDate);
		setSeasonNumber(seasonNumber);
		setEpisodeNumber(episodeNumber);
		setRatingScore(ratingScore);
		setVoteCount(voteCount);
		
	}
	public void orderbyrate(ArrayList<TVSeries> tvserylist)//descending sort by rating point
	{
		for(int i=0; i < tvserylist.size(); i++)
	    {
	        for(int j=i+1;j<tvserylist.size();j++)
	        {
	            if((tvserylist.get(i).getRatingScore())-(tvserylist.get(j).getRatingScore()) < 0)
	            {
	            	TVSeries first= tvserylist.get(i);
	            	TVSeries second=tvserylist.get(j);
	            	tvserylist.set(i,second);
	            	tvserylist.set(j,first);
	                
	            }
	        }
	    }
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getSeasonNumber() {
		return seasonNumber;
	}
	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	public int getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
}
