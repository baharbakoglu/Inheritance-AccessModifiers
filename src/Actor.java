import java.util.ArrayList;

public class Actor extends Performers{

	private int height;
	
	public Actor(int id, String name,String surname,String country,int height){
		
		super(id,name,surname,country);
		setHeight(height);
		
	}
	public int find_person(ArrayList<Actor> actorlist, String countryName){//find actor use country name in actor list
		
		for(int i=0;i<actorlist.size();i++){
			if(actorlist.get(i).getCountry().equals(countryName)){
				return 1;
			}
		}
		return -1;
		
	}
	public int find_person(ArrayList<Actor> actorlist, int actorId){//find actor use actor id in actor list 
		
		for(int i=0;i<actorlist.size();i++){
			if(actorlist.get(i).getId() == actorId){
				return 1;
			}
		}
		
		return -1;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
