import java.util.ArrayList;


public class Documentary extends Films {

	private String releaseDate;
		
	public Documentary(int filmId, String filmTitle, String language,  String directors,int durationLength, String country, String performers,String releaseDate){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setReleaseDate(releaseDate);
		
	}
	public Documentary(int filmId, String filmTitle, String language,  String directors,int durationLength, String country, String performers,String releaseDate, float ratingScore, int voteCount){
		
		super(filmId,filmTitle,language,directors,durationLength,country, performers);
		setReleaseDate(releaseDate);
		setRatingScore(ratingScore);
		setVoteCount(voteCount);
	}
	public void orderbyrate(ArrayList<Documentary> documentaryflist)//descending sort by rating point
	{
		for(int i=0; i < documentaryflist.size(); i++)
	    {
	        for(int j=i+1;j<documentaryflist.size();j++)
	        {
	            if((documentaryflist.get(i).getRatingScore())-(documentaryflist.get(j).getRatingScore()) < 0)
	            {
	            	Documentary first= documentaryflist.get(i);
	            	Documentary second=documentaryflist.get(j);
	            	documentaryflist.set(i,second);
	            	documentaryflist.set(j,first);
	                
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
	
}
