
public class Films {

	private int filmId;
	private String filmTitle;
	private String language;
	private int durationLength;
	private String country;
	private String directors;
	private String performers;
	private float ratingScore;
	private int voteCount;

	public Films(int filmId, String filmTitle, String language,String directors, int durationLength, String country,String performers){
		
		setFilmId(filmId);
		setFilmTitle(filmTitle);
		setLanguage(language);
		setDirectors(directors);
		setDurationLength(durationLength);
		setCountry(country);		
		setPerformer(performers);
		
	}
	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public float getRatingScore() {
		return ratingScore;
	}
	public void setRatingScore(float ratingScore) {
		this.ratingScore = ratingScore;
	}
	public String getDirector() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getDurationLength() {
		return durationLength;
	}
	public void setDurationLength(int durationLength) {
		this.durationLength = durationLength;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPerformers() {
		return performers;
	}
	public void setPerformer(String performers) {
		this.performers = performers;
	}

	
	
}
