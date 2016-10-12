import java.util.ArrayList;


public class Writer extends Artist {

	private String style;
	
	public Writer(int id, String name,String surname,String country, String style){
		
		super(id,name,surname,country);
		setStyle(style);
		
	}
	public int find_person(ArrayList<Writer> writerlist, String countryName){ // find writer use country name in writerlist
		
		for(int i=0;i<writerlist.size();i++){
			if(writerlist.get(i).getCountry().equals(countryName)){
				return 1;
			}
		}
		return -1;
		
	}
public int find_person(ArrayList<Writer> writerlist, int writerId){// find writer use writer id in writerlist
		
		for(int i=0;i<writerlist.size();i++){
			if(writerlist.get(i).getId() == writerId){
				return 1;
			}
		}
		
		return -1;
	}
	public String find_name(ArrayList<Writer> writerlist,int writer_id)// find writer name with writer id
	{
		for(int i=0 ; i<writerlist.size(); i++)
		{
			if(writerlist.get(i).getId()==writer_id)
				return writerlist.get(i).getName().concat(" ").concat(writerlist.get(i).getSurname());;
		}
			
		return null;
	}
	

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
