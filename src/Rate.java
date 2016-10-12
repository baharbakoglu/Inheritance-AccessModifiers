import java.util.ArrayList;


public class Rate {
private int user_id;
private int film_id;
private int rating_point;

public Rate(int user_id, int film_id, int rating_point)
{
setUser_id(user_id);
setFilm_id(film_id);
setRating_point(rating_point);
}
public int find_id(ArrayList<Rate> ratelist, int userId){//find user id in ratelist
	
	for(int i=0; i< ratelist.size();i++){
		if(ratelist.get(i).getUser_id() == userId){
			return 1;
		}
	}
	
	return -1;
}


public int getUser_id() {
return user_id;
}
public void setUser_id(int user_id) {
this.user_id = user_id;
}
public int getFilm_id() {
return film_id;
}
public void setFilm_id(int film_id) {
this.film_id = film_id;
}
public int getRating_point() {
return rating_point;
}
public void setRating_point(int rating_point) {
this.rating_point = rating_point;
}
}
