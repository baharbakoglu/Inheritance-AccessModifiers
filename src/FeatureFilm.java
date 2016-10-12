import java.util.ArrayList;


public class FeatureFilm extends Films{

	private String releaseDate;
	private String budget;
	private String writer;
	private String genre;
	
	public FeatureFilm(int filmId, String filmTitle, String language, String directors,int durationLength, String country, String performers,String genre,String releaseDate,String writer,String budget){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setReleaseDate(releaseDate);
		setWriter(writer);
		setBudget(budget);
		
	}
	
	public FeatureFilm(int filmId, String filmTitle, String language, String directors,int durationLength, String country, String performers,String genre,String releaseDate,String writer,String budget,float ratingScore, int voteCount){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setGenre(genre);
		setReleaseDate(releaseDate);
		setWriter(writer);
		setBudget(budget);
		setRatingScore(ratingScore);
		setVoteCount(voteCount);
	}
	public void orderbyrate(ArrayList<FeatureFilm> featurefilmlist)//descending sort by rating point
	{
		for(int i=0; i < featurefilmlist.size(); i++)
	    {
	        for(int j=i+1;j<featurefilmlist.size();j++)
	        {
	            if((featurefilmlist.get(i).getRatingScore())-featurefilmlist.get(j).getRatingScore() < 0)
	            {
	            	FeatureFilm first= featurefilmlist.get(i);
	            	FeatureFilm second=featurefilmlist.get(j);
	            	featurefilmlist.set(i,second);
	            	featurefilmlist.set(j,first);
	                
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

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
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
