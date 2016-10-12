import java.util.ArrayList;


public class Director extends Artist {

	private String agent;
	
	public Director(int id, String name,String surname,String country, String agent){
		
		super(id,name,surname,country);
		setAgent(agent);	
		
	}
	public int find_person(ArrayList<Director> directorlist, String countryName){
		
		for(int i=0;i<directorlist.size();i++){
			if(directorlist.get(i).getCountry().equals(countryName)){
				return 1;
			}
		}
		return -1;		
	}
	public int find_person(ArrayList<Director> directorlist, int directorId){// find director in directorlist
		
		for(int i=0;i<directorlist.size();i++){
			if(directorlist.get(i).getId() == directorId){
				return 1;
			}
		}
		
		return -1;
	}
	public String find_name(ArrayList<Director> directorlist,int director_id)//find directors name
	{
		for(int i=0 ; i<directorlist.size(); i++)
		{
			if(directorlist.get(i).getId()==director_id)
				return directorlist.get(i).getName().concat(" ").concat(directorlist.get(i).getSurname());
		}
			
		return null;
	}

	
	
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	
}
