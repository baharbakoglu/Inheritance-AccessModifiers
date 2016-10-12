import java.util.ArrayList;


public class Actress extends Performers{

	public Actress(int id, String name,String surname,String country){
		
		super(id,name,surname,country);
		
	}
	public int find_person(ArrayList<Actress> actresslist, String countryName){//find actress use country name in actress list
		
		for(int i=0;i<actresslist.size();i++){
			if(actresslist.get(i).getCountry().equals(countryName)){
				return 1;
			}
		}
		return -1;
		
	}
	public int find_person(ArrayList<Actress> actresslist, int actressId){//find actress use actress id in actress list
		
		for(int i=0;i<actresslist.size();i++){
			if(actresslist.get(i).getId() == actressId){
				return 1;
			}
		}
		
		return -1;
	}
	public String find_name(ArrayList<Actor> actorlist,ArrayList<Actress> actresslist,int performer_id)// find actor or actress name who has this id
	{
	for(int i=0 ; i<actorlist.size(); i++)
	{
		if(actorlist.get(i).getId() == performer_id)
			return actorlist.get(i).getName().concat(" ").concat(actorlist.get(i).getSurname());
	}
	for(int i=0 ; i<actresslist.size(); i++)
	{
		if(actresslist.get(i).getId() == performer_id)
			return actresslist.get(i).getName().concat(" ").concat(actresslist.get(i).getSurname());
	}
	return null;
}
	
	
}
