import java.util.ArrayList;


public class ShortFilm extends Films {
	
	private String releaseDate;
	private String writer;
	private String genre;
	
	public ShortFilm(int filmId, String filmTitle, String language,String directors, int durationLength, String country,String performers,String genre,String releaseDate, String writer){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setReleaseDate(releaseDate);
		setWriter(writer);	
		
	}
	public ShortFilm(int filmId, String filmTitle, String language,String directors, int durationLength, String country,String performers,String genre,String releaseDate, String writer, float ratingScore, int voteCount){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setReleaseDate(releaseDate);
		setWriter(writer);	
		setRatingScore(ratingScore);
		setVoteCount(voteCount);
	}
	public void orderbyrate(ArrayList<ShortFilm> shortfilmlist)//descending sort by rating point
	{
		for(int i=0; i < shortfilmlist.size(); i++)
	    {
	        for(int j=i+1;j<shortfilmlist.size();j++)
	        {
	            if((shortfilmlist.get(i).getRatingScore())-(shortfilmlist.get(j).getRatingScore()) < 0)
	            {
	            	ShortFilm first= shortfilmlist.get(i);
	            	ShortFilm second=shortfilmlist.get(j);
	            	shortfilmlist.set(i,second);
	            	shortfilmlist.set(j,first);
	                
	            }
	        }
	    }
	}
	

	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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
