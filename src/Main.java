import java.util.ArrayList;
import java.util.Scanner;
		public class Main {
			
		public static int check_directors(ArrayList<Director> directorlist,String director)//check director for add command
		{
			String [] str;
			int count=0;
			str=parse_string(director);
			for(int i=0;i<str.length;i++){
				for(int j=0;j<directorlist.size();j++)
				{
					if(Integer.parseInt(str[i])==directorlist.get(j).getId())
						count++;
				}
			}
			if(count==str.length)
				return 1;
			else
				return 0;
			
		}
		public static int check_writers(ArrayList<Writer> writerlist,String writer)//check writer for add command
		{
			String [] str;
			int count=0;
			str=parse_string(writer);
			for(int i=0;i<str.length;i++){
				for(int j=0;j<writerlist.size();j++)
				{
					if(Integer.parseInt(str[i])==writerlist.get(j).getId())
						count++;
				}
			}
			if(count==str.length)
				return 1;
			else
				return 0;
			
		}
		public static int check_performers(ArrayList<Actor> actorlist,ArrayList<Actress> actresslist,String performer)//check performers for add command
		{
			String [] str;
			int count=0;
			str=parse_string(performer);
			for(int i=0;i<str.length;i++){
				for(int j=0;j<actorlist.size();j++)
				{
					if(Integer.parseInt(str[i])==actorlist.get(j).getId())
						count++;
				}
				for(int j=0;j<actresslist.size();j++)
				{
					if(Integer.parseInt(str[i])==actresslist.get(j).getId())
						count++;
				}
			}
			if(count==str.length)
				return 1;
			else
				return 0;
			
		}
		
		public static String find_performer_name(ArrayList<Actor> actorlist,ArrayList<Actress> actresslist,int performer_id)//find performer name for view film command
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
		public static float find_rating_score(ArrayList<Rate> ratelist,int film_id)//for calculate average rating points 
		{
			float sum=0,a=0;
			for(int i=0 ; i<ratelist.size(); i++)
			{
				if(ratelist.get(i).getFilm_id() == film_id)
				{
					sum=sum+ratelist.get(i).getRating_point();
					a++;
				}
			}
			if(sum==0)
				return  0;
			else
				return sum/a;
				
		}
		public static int find_user_number(ArrayList<Rate> ratelist,int film_id)//find user number who rates film for view film command and list by rate degree command 
		{
			int a=0;
			for(int i=0 ; i<ratelist.size(); i++)
			{
				if(ratelist.get(i).getFilm_id() == film_id)
					a++;
			}
			return a;
			
		}
		public static String parse_float(String str)//find number which is after comma for view film command and list by rate degree command 
		{
			String[] array;
			array=str.split(",");
			return array[1];
		}
		public static String find_year(String date)//find year in date 
		{
			String[] array;
			array=date.split("\\.");
			return array[2];
				
		}
		public static String[] parse_string(String str)//parse directors' id,performers' id and writers' id in order to find their names
		{
			String[] array;
			array=str.split(",");
			return array;
		}
			
		public static int check_rate(ArrayList<Rate> ratelist,int user_id,int film_id)//understand if rate is exist for rate,edit and remove command
		{
			for(int i=0 ; i<ratelist.size(); i++)
			{
				if(ratelist.get(i).getUser_id() == user_id)
				{
					if(ratelist.get(i).getFilm_id()==film_id)
						
						return i;
				}	
			}
			return -1;
		}
		public static int check_user_id(ArrayList<User> userlist,int user_id)// check user id for rate and list commands
		{
			for(int i=0 ; i<userlist.size(); i++)
			{
				if(userlist.get(i).getId() == user_id)
					
					return i;
			}
			return -1;
		}
		public static int check_film_id(ArrayList<FeatureFilm> featureflist,ArrayList<ShortFilm> shortflist,ArrayList<Documentary> documentarylist,ArrayList<TVSeries> tvserieslist,int film_id)//check whether film is exist.if film is exist return index 
		{
			for(int i=0 ; i<featureflist.size(); i++)
			{
				if(featureflist.get(i).getFilmId() == film_id)
		
					return i;
			}
			for(int i=0 ; i<shortflist.size(); i++)
			{
				if(shortflist.get(i).getFilmId() == film_id)
					
					return i;
			}
			for(int i=0 ; i<documentarylist.size(); i++)
			{
				if(documentarylist.get(i).getFilmId() == film_id)
					
					return i;
			}
			for(int i=0 ; i<tvserieslist.size(); i++)
			{
				if(tvserieslist.get(i).getFilmId() == film_id)
					
					return i;
			}
		
			return -1;	
		}
		
		public static String find_film_type(ArrayList<FeatureFilm> featureflist,ArrayList<ShortFilm> shortflist,ArrayList<Documentary> documentarylist,ArrayList<TVSeries> tvserieslist,int film_id)//find film type for rate ,view film, edit rate, remove rate commands
		{
			for(int i=0 ; i<featureflist.size(); i++)
			{
				if(featureflist.get(i).getFilmId() == film_id)
		
					return "FeatureFilm";
			}
			for(int i=0 ; i<shortflist.size(); i++)
			{
				if(shortflist.get(i).getFilmId() == film_id)
					
					return "ShortFilm";
			}
			for(int i=0 ; i<documentarylist.size(); i++)
			{
				if(documentarylist.get(i).getFilmId() == film_id)
					
					return "Documentary";
			}
			for(int i=0 ; i<tvserieslist.size(); i++)
			{
				if(tvserieslist.get(i).getFilmId() == film_id)
					
					return "TVSeries";
			}
		
			return null;	
		}
		
		public static String find_film_title (ArrayList<FeatureFilm> featureflist,ArrayList<ShortFilm> shortflist,ArrayList<Documentary> documentarylist,ArrayList<TVSeries> tvserieslist, int film_id ){//find film title for list user by rate command
			
			for(int i=0 ; i<featureflist.size(); i++)
			{
				if(featureflist.get(i).getFilmId() == film_id){
		
					return featureflist.get(i).getFilmTitle();
				}
			}
			for(int i=0 ; i<shortflist.size(); i++)
			{
				if(shortflist.get(i).getFilmId() == film_id){
					
					return shortflist.get(i).getFilmTitle();
				}
			}
			for(int i=0 ; i<documentarylist.size(); i++)
			{
				if(documentarylist.get(i).getFilmId() == film_id){
					
					return documentarylist.get(i).getFilmTitle();
				}
			}
			for(int i=0 ; i<tvserieslist.size(); i++)
			{
				if(tvserieslist.get(i).getFilmId() == film_id){
					
					return tvserieslist.get(i).getFilmTitle();
				}
			}
			return null;
			
		}
		public static int find_film_title (ArrayList<Films> filmlist, String countryName ){//find film title for list films by country command
			
			for(int i=0 ; i< filmlist.size() ; i++){
				if(filmlist.get(i).getCountry().equals(countryName)){
					return i;
				}
			}
			return -1;
			
		}
		public static int find_before_films(ArrayList<FeatureFilm> featureflist, String array ){//for list feature film before taken year
			for(int i =0 ; i<featureflist.size() ;i++){
				if(Integer.parseInt(array) > Integer.parseInt(find_year(featureflist.get(i).getReleaseDate()))){
					return 1;
				}
			}
			return -1;
		}
		public static int find_after_films(ArrayList<FeatureFilm> featureflist, String array ){//for list feature film after taken year
			for(int i =0 ; i<featureflist.size() ;i++){
				if(Integer.parseInt(array) <= Integer.parseInt(find_year(featureflist.get(i).getReleaseDate()))){
					return 1;
				}
			}
			return -1;
		}
		
		public static void main(String[] args) 
		{
		ArrayList<Director> directorlist = new ArrayList<Director>();
		ArrayList<Writer> writerlist = new ArrayList<Writer>();
		ArrayList<Actor> actorlist = new ArrayList<Actor>();
		ArrayList<Actress> actresslist = new ArrayList<Actress>();
		ArrayList<User> userlist = new ArrayList<User>();
		ArrayList<FeatureFilm> featureflist = new ArrayList<FeatureFilm>();
		ArrayList<ShortFilm> shortflist = new ArrayList<ShortFilm>();
		ArrayList<Documentary> documentarylist = new ArrayList<Documentary>();
		ArrayList<TVSeries> tvserieslist = new ArrayList<TVSeries>();
		ArrayList<Rate> ratelist = new ArrayList<Rate>();
		ArrayList<Films> filmlist = new ArrayList<Films>();
		FileRead fr = new FileRead();
		WriteFile wf = new WriteFile();
		Scanner input=null;
		String tempstring;//for nextLine function
		String[] array;//for split function
		String str=null;
		
		input = fr.openFile("people.txt");//open file
		System.out.println();
		while(input.hasNext()){
		
			tempstring = input.nextLine();//read line
			array = tempstring.split("	");//part according to space
			
			if(array[0].equals("Director:"))
			{
				Director director= new Director(Integer.parseInt(array[1]),array[2],array[3],array[4],array[5]);
				directorlist.add(director);
			}
			
			if(array[0].equals("Writer:"))
			{
				Writer writer= new Writer(Integer.parseInt(array[1]),array[2],array[3],array[4],array[5]);
				writerlist.add(writer);
			}
			
			if(array[0].equals("Actor:"))
			{
				Actor actor= new Actor(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]));
				actorlist.add(actor);
			}
			
			if(array[0].equals("Actress:"))
			{
				Actress actress= new Actress(Integer.parseInt(array[1]),array[2],array[3],array[4]);
				actresslist.add(actress);
			}
		
			if(array[0].equals("User:"))
			{
				User user= new User(Integer.parseInt(array[1]),array[2],array[3],array[4]);
				userlist.add(user);
			}
		
		
		}
		fr.closeFile(input);//close file
		
		Writer w = new Writer(writerlist.get(0).getId(),writerlist.get(0).getName(),writerlist.get(0).getSurname(),writerlist.get(0).getCountry(),writerlist.get(0).getStyle());
		Actor a=new Actor(actorlist.get(0).getId(), actorlist.get(0).getName(), actorlist.get(0).getSurname(), actorlist.get(0).getCountry(), actorlist.get(0).getHeight());
		Actress ac = new Actress(actresslist.get(0).getId(), actresslist.get(0).getName(), actresslist.get(0).getSurname(), actresslist.get(0).getCountry());
		Director d = new Director(directorlist.get(0).getId(),directorlist.get(0).getName(), directorlist.get(0).getSurname(),directorlist.get(0).getCountry(),directorlist.get(0).getAgent());
		
		input = fr.openFile("films.txt");//open file
		System.out.println();
		
		while(input.hasNext()){
		
			tempstring = input.nextLine();//read line
			array = tempstring.split("	");//part according to space
			
			if(array[0].equals("FeatureFilm:"))
			{
				FeatureFilm featurefilm = new FeatureFilm(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7],array[8],array[9],array[10],array[11]);
				featureflist.add(featurefilm);
				Films film = new Films(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7]);
				filmlist.add(film);
			}
			
			if(array[0].equals("ShortFilm:"))
			{
				ShortFilm shortfilm = new ShortFilm(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7],array[8],array[9],array[10]);
				shortflist.add(shortfilm);
				Films film = new Films(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7]);
				filmlist.add(film);
			}
			
			if(array[0].equals("Documentary:"))
			{
				Documentary documentary = new Documentary(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7],array[8]);
				documentarylist.add(documentary);
				Films film = new Films(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7]);
				filmlist.add(film);
			}
			
			if(array[0].equals("TVSeries:"))
			{
				TVSeries tvseries= new TVSeries(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7],array[8],array[9],array[10],array[11],Integer.parseInt(array[12]),Integer.parseInt(array[13]));
				tvserieslist.add(tvseries);
				Films film = new Films(Integer.parseInt(array[1]),array[2],array[3],array[4],Integer.parseInt(array[5]),array[6],array[7]);
				filmlist.add(film);
			}
		
		}
		
		fr.closeFile(input);//close file
		
		input = fr.openFile("commands.txt");//open file
		System.out.println();
		wf.openWFile("output.txt");//open write file
		while(input.hasNext()){
		
			tempstring = input.nextLine();//read line
			array = tempstring.split("	");//part according to tab
			
			if(array[0].equals("RATE")){
				wf.writeln("RATE\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
				wf.writeln("");
				if(Integer.parseInt(array[3])<1 || Integer.parseInt(array[3])>10){
					wf.writeln("Rating score must be between 1 and 10.");
					wf.writeln("");
			}
				else if(check_rate(ratelist,Integer.parseInt(array[1]),Integer.parseInt(array[2]))!=-1)
				{
					wf.writeln("This film was earlier rated");
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
				}
				else if(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]))==-1 || check_user_id(userlist,Integer.parseInt(array[1]))==-1)
				{
					wf.writeln("Command Failed");
					wf.writeln("User ID: "+Integer.parseInt(array[1]));
					wf.writeln("Film ID: "+Integer.parseInt(array[2]));
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
				}
				else
				{
					Rate rate=new Rate(Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]));
					ratelist.add(rate);
					str=find_film_type(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]));
					if(str.equalsIgnoreCase("FeatureFilm")){
						wf.writeln("Film rated successfully");
					    wf.writeln("Film type: "+str);
					    wf.writeln("Film title: "+featureflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]))).getFilmTitle());
					    wf.writeln("");
					}
					if(str.equalsIgnoreCase("ShortFilm")){
						wf.writeln("Film rated successfully");
						wf.writeln("Film type: "+str);
						wf.writeln("Film title: "+shortflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]))).getFilmTitle());
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("Documentary")){
						wf.writeln("Film rated successfully");
						wf.writeln("Film type: "+str);
						wf.writeln("Film title: "+documentarylist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]))).getFilmTitle());
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("TVSeries")){
						wf.writeln("Film rated successfully");
						wf.writeln("Film type: "+str);
						wf.writeln("Film title: "+tvserieslist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[2]))).getFilmTitle());
						wf.writeln("");
					}
					wf.writeln("-----------------------------------------------------------------------------------------------------");
				}
			}
			Rate r = new Rate(ratelist.get(0).getUser_id(),ratelist.get(0).getFilm_id(),ratelist.get(0).getRating_point());
			if(array[0].equals("ADD")){
							
				
				if(array[1].equals("FEATUREFILM"))
				{
					wf.writeln("ADD\t"+ array[1]+"\t"+Integer.parseInt(array[2])+"\t"+array[3]+"\t"+array[4]+"\t"+array[5]+"\t"+Integer.parseInt(array[6])+"\t"+array[7]+"\t"+array[8]+"\t"+array[9]+"\t"+array[10]+"\t"+array[11]+"\t"+array[12]);
					wf.writeln("");
					if((check_film_id(featureflist, shortflist, documentarylist, tvserieslist,Integer.parseInt(array[2])) == -1) && (check_directors(directorlist,array[5])==1) && (check_performers(actorlist,actresslist,array[8])==1) &&(check_writers(writerlist, array[11])==1)){
												
						FeatureFilm featurefilm = new FeatureFilm(Integer.parseInt(array[2]),array[3],array[4],array[5],Integer.parseInt(array[6]),array[7],array[8],array[9],array[10],array[11],array[12]);
						featureflist.add(featurefilm);
						Films film = new Films(Integer.parseInt(array[2]),array[3],array[4],array[5],Integer.parseInt(array[6]),array[7],array[8]);
						filmlist.add(film);
					
						wf.writeln("FeatureFilm added successfully");
					}
					else{
						
						wf.writeln("Command Failed");
					
					}
					wf.writeln("Film ID: " + array[2]);
					wf.writeln("Film title: " + array[3]);
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
				}				
			}
			if(array[0].equals("VIEWFILM")){
				wf.writeln("VIEWFILM	"+array[1]);
				wf.writeln("");
				String []str2;
				int index;
				str=find_film_type(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]));
				if(str.equalsIgnoreCase("FeatureFilm")){
					index=check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]));
					wf.writeln(featureflist.get(index).getFilmTitle()+" ("+find_year(featureflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]))).getReleaseDate())+")");
					str2=parse_string(featureflist.get(index).getGenre());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(str2[i]);
						else
							wf.write(str2[i]+", ");
					}
					wf.write("Writers: ");
					str2=parse_string(featureflist.get(index).getWriter());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(w.find_name(writerlist,Integer.parseInt(str2[i])));
						else
							wf.write(w.find_name(writerlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Directors: ");
					str2=parse_string(featureflist.get(index).getDirector());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(d.find_name(directorlist,Integer.parseInt(str2[i])));
						else
							wf.write(d.find_name(directorlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Stars: ");
					str2=parse_string(featureflist.get(index).getPerformers());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i])));
						else
							wf.write(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i]))+", ");
					}
					if(find_rating_score(ratelist,featureflist.get(index).getFilmId()) == 0)
						wf.writeln("Awaiting for votes");
					else{
						if(parse_float(String.format("%.1f",find_rating_score(ratelist,featureflist.get(index).getFilmId()))).equals("0")){
							wf.writeln("Ratings: "+String.format("%.0f",find_rating_score(ratelist,featureflist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,featureflist.get(index).getFilmId())+" users");
						}
						else
						wf.writeln("Ratings: "+String.format("%.1f",find_rating_score(ratelist,featureflist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,featureflist.get(index).getFilmId())+" users");
					}
					wf.writeln("");
				}
				if(str.equalsIgnoreCase("ShortFilm")){
					index=check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]));
					wf.writeln(shortflist.get(index).getFilmTitle()+" ("+find_year(shortflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]))).getReleaseDate())+")");
					str2=parse_string(shortflist.get(index).getGenre());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(str2[i]);
						else
							wf.write(str2[i]+", ");
					}
					wf.write("Writers: ");
					str2=parse_string(shortflist.get(index).getWriter());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(w.find_name(writerlist,Integer.parseInt(str2[i])));
						else
							wf.write(w.find_name(writerlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Directors: ");
					str2=parse_string(shortflist.get(index).getDirector());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(d.find_name(directorlist,Integer.parseInt(str2[i])));
						else
							wf.write(d.find_name(directorlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Stars: ");
					str2=parse_string(shortflist.get(index).getPerformers());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i])));
						else
							wf.write(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i]))+", ");
					}
					if(find_rating_score(ratelist,shortflist.get(index).getFilmId()) == 0)
						wf.writeln("Awaiting for votes");
					else{
						if((parse_float(String.format("%.1f", find_rating_score(ratelist,shortflist.get(index).getFilmId()))).equals("0"))){
							wf.writeln("Ratings: "+String.format("%.0f", find_rating_score(ratelist,shortflist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,shortflist.get(index).getFilmId())+" users");
						}
						else
							wf.writeln("Ratings: "+String.format("%.1f", find_rating_score(ratelist,shortflist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,shortflist.get(index).getFilmId())+" users");
					}
					wf.writeln("");
				}
				if(str.equalsIgnoreCase("Documentary")){
					index=check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]));
					wf.writeln(documentarylist.get(index).getFilmTitle()+" ("+find_year(documentarylist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]))).getReleaseDate())+")");
					wf.writeln("");
					wf.write("Directors: ");
					str2=parse_string(documentarylist.get(index).getDirector());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(d.find_name(directorlist,Integer.parseInt(str2[i])));
						else
							wf.write(d.find_name(directorlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Stars: ");
					str2=parse_string(documentarylist.get(index).getPerformers());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i])));
						else
							wf.write(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i]))+", ");
					}
					if(find_rating_score(ratelist,documentarylist.get(index).getFilmId()) == 0)
						wf.writeln("Awaiting for votes");
					else{
						if((parse_float(String.format("%.1f",find_rating_score(ratelist,documentarylist.get(index).getFilmId()))).equals("0")))
							wf.writeln("Ratings: "+String.format("%.0f",find_rating_score(ratelist,documentarylist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,documentarylist.get(index).getFilmId())+" users");
						else
							wf.writeln("Ratings: "+String.format("%.1f",find_rating_score(ratelist,documentarylist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,documentarylist.get(index).getFilmId())+" users");
					}
					wf.writeln("");
				}
				if(str.equalsIgnoreCase("TVSeries")){
					index=check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]));
					wf.writeln(tvserieslist.get(index).getFilmTitle()+" ("+find_year(tvserieslist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]))).getStartDate())+"-"+find_year(tvserieslist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[1]))).getEndDate())+")");
					wf.writeln(tvserieslist.get(index).getSeasonNumber()+" seasons, "+tvserieslist.get(index).getEpisodeNumber()+" episodes");
					str2=parse_string(tvserieslist.get(index).getGenre());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(str2[i]);
						else
							wf.write(str2[i]+", ");
					}
					wf.write("Writers: ");
					str2=parse_string(tvserieslist.get(index).getWriter());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(w.find_name(writerlist,Integer.parseInt(str2[i])));
						else
							wf.write(w.find_name(writerlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Directors: ");
					str2=parse_string(tvserieslist.get(index).getDirector());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(d.find_name(directorlist,Integer.parseInt(str2[i])));
						else
							wf.write(d.find_name(directorlist,Integer.parseInt(str2[i]))+", ");
					}
					wf.write("Stars: ");
					str2=parse_string(tvserieslist.get(index).getPerformers());
					for(int i=0;i<str2.length;i++){
						if(i==str2.length-1)
							wf.writeln(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i])));
						else
							wf.write(find_performer_name(actorlist,actresslist,Integer.parseInt(str2[i]))+", ");
					}
					if(find_rating_score(ratelist,tvserieslist.get(index).getFilmId()) == 0)
						wf.writeln("Awaiting for votes");
					else{
						if((parse_float(String.format("%.1f",find_rating_score(ratelist,tvserieslist.get(index).getFilmId()))).equals("0")))
							wf.writeln("Ratings: "+String.format("%.0f", find_rating_score(ratelist,tvserieslist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,tvserieslist.get(index).getFilmId())+" users");
						else
							wf.writeln("Ratings: "+String.format("%.1f", find_rating_score(ratelist,tvserieslist.get(index).getFilmId()))+"/10 from "+find_user_number(ratelist,tvserieslist.get(index).getFilmId())+" users");
					}
						wf.writeln("");
				}
				if(str.equalsIgnoreCase(null)){
					wf.writeln("Command Failed");
					wf.writeln("Film ID: "+array[1]);
					wf.writeln("");
				}
				wf.writeln("-----------------------------------------------------------------------------------------------------");
			}
			if(array[0].equals("EDIT")){
				wf.writeln("EDIT\tRATE\t"+array[2]+"\t"+array[3]+"\t"+array[4]);
				wf.writeln("");
				if(check_rate(ratelist,Integer.parseInt(array[2]),Integer.parseInt(array[3]))!=-1)
				{
					ratelist.get(check_rate(ratelist,Integer.parseInt(array[2]),Integer.parseInt(array[3]))).setRating_point(Integer.parseInt(array[4]));
					str=find_film_type(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]));
					if(str.equalsIgnoreCase("FeatureFilm")){
						wf.writeln("New ratings done successfully");
						wf.writeln("Film title: "+featureflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("Your rating: "+array[4]);
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("ShortFilm")){
						wf.writeln("New ratings done successfully");
						wf.writeln("Film title: "+shortflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("Your rating: "+array[4]);
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("Documentary")){
						wf.writeln("New ratings done successfully");
						wf.writeln("Film title: "+documentarylist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("Your rating: "+array[4]);
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("TVSeries")){
						wf.writeln("New ratings done successfully");
						wf.writeln("Film title: "+tvserieslist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("Your rating: "+array[4]);
						wf.writeln("");
					}
				}
				else
				{
					wf.writeln("Command Failed");
					wf.writeln("User ID: "+array[2]);
					wf.writeln("Film ID: "+array[3]);
					wf.writeln("");
				}
				wf.writeln("-----------------------------------------------------------------------------------------------------");
			}
			if(array[0].equals("REMOVE")){
				wf.writeln("REMOVE\tRATE\t"+array[2]+"\t"+array[3]);
				wf.writeln("");
				if(check_rate(ratelist,Integer.parseInt(array[2]),Integer.parseInt(array[3]))!=-1)
				{
					ratelist.remove(check_rate(ratelist,Integer.parseInt(array[2]),Integer.parseInt(array[3])));
					str=find_film_type(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]));
					if(str.equalsIgnoreCase("FeatureFilm")){
						wf.writeln("Your film rating was removed successfully");
						wf.writeln("Film title: "+featureflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("ShortFilm")){
						wf.writeln("Your film rating was removed successfully");
						wf.writeln("Film title: "+shortflist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("Documentary")){
						wf.writeln("Your film rating was removed successfully");
						wf.writeln("Film title: "+documentarylist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("");
					}
					if(str.equalsIgnoreCase("TVSeries")){
						wf.writeln("Your film rating was removed successfully");
						wf.writeln("Film title: "+tvserieslist.get(check_film_id(featureflist,shortflist,documentarylist,tvserieslist,Integer.parseInt(array[3]))).getFilmTitle());
						wf.writeln("");
					}
				}
				else
				{
					wf.writeln("Command Failed");
					wf.writeln("User ID: "+array[2]);
					wf.writeln("Film ID: "+array[3]);
					wf.writeln("");
				}
				wf.writeln("-----------------------------------------------------------------------------------------------------");
			}
			
			if(array[0].equals("LIST")){
				
				if((array[1].equals("USER")) && (array[3].equals("RATES"))){
					
					wf.writeln("LIST\tUSER\t"+array[2]+"\t"+"RATES" );
					wf.writeln("");
					if(check_user_id(userlist, Integer.parseInt(array[2])) != -1){
						if(r.find_id(ratelist, Integer.parseInt(array[2])) == -1){
							wf.writeln("There is not any ratings so far");
					}
					}
					if(check_user_id(userlist, Integer.parseInt(array[2])) == -1){
						
						wf.writeln("Command Failed");
						wf.writeln("User ID: "+ array[2]);
					}
					
					for(int j=0 ; j < ratelist.size() ; j++){
						
						if(Integer.parseInt(array[2]) == ratelist.get(j).getUser_id()){
							
							wf.writeln(find_film_title(featureflist, shortflist, documentarylist, tvserieslist, ratelist.get(j).getFilm_id() ) + ": " + ratelist.get(j).getRating_point());
						}
					}			
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
					
				}
				
				if(array[1].equals("FILM") && array[2].equals("SERIES")){
					
					wf.writeln("LIST\tFILM\tSERIES");
					wf.writeln("");
					if(tvserieslist.size()==0){
						wf.writeln("No result");
					}
					
					for(int j=0 ; j < tvserieslist.size() ; j++){
						
						wf.writeln(tvserieslist.get(j).getFilmTitle()+ " (" + find_year(tvserieslist.get(j).getStartDate()) + "-" + find_year(tvserieslist.get(j).getEndDate())+ ")");
						wf.writeln(tvserieslist.get(j).getSeasonNumber() + " seasons and " + tvserieslist.get(j).getEpisodeNumber()+ " episodes");
						wf.writeln("");
					}
					wf.writeln("-----------------------------------------------------------------------------------------------------");
					
				}
				
				if(array[1].equals("FILMS") && array[2].equals("BY") && array[3].equals("COUNTRY")){
					wf.writeln("LIST\tFILMS\tBY\tCOUNTRY\t"+ array[4]);
					wf.writeln("");
					if(find_film_title(filmlist, array[4]) == -1){
						wf.writeln("No result");
						wf.writeln("");
					}
					for(int i=0 ; i< filmlist.size() ; i++){						
						if(filmlist.get(i).getCountry().equals(array[4])){
							wf.writeln("Film title: " + filmlist.get(i).getFilmTitle());
							wf.writeln(filmlist.get(i).getDurationLength() + " min");
							wf.writeln("Language: " + filmlist.get(i).getLanguage());
							wf.writeln("");
						}
						
					}					
					
					wf.writeln("-----------------------------------------------------------------------------------------------------");					
				}
				if(array[1].equals("FEATUREFILMS")){
					
					if(array[2].equals("AFTER")){
						wf.writeln("LIST\tFEATUREFILMS\tAFTER\t"+ array[3]);
						wf.writeln("");
						for(int j=0 ; j<featureflist.size() ; j++){
							
							if(Integer.parseInt(array[3]) <= Integer.parseInt(find_year(featureflist.get(j).getReleaseDate()))){
								
								wf.writeln("Film title: "+ featureflist.get(j).getFilmTitle()+ " (" + find_year(featureflist.get(j).getReleaseDate())+ ")");
								wf.writeln(featureflist.get(j).getDurationLength() +" min");
								wf.writeln("Language: " + featureflist.get(j).getLanguage());
								wf.writeln("");
								
							}
						}
						if(find_after_films(featureflist, array[3]) == -1){
							wf.writeln("No result");
							wf.writeln("");
						}
						wf.writeln("-----------------------------------------------------------------------------------------------------");
					}
					if(array[2].equals("BEFORE")){
						wf.writeln("LIST\tFEATUREFILMS\tBEFORE\t"+ array[3] );
						wf.writeln("");
						for(int j=0 ; j<featureflist.size() ; j++){
							
							if(Integer.parseInt(array[3]) > Integer.parseInt(find_year(featureflist.get(j).getReleaseDate()))){
								
								wf.writeln("Film title: "+ featureflist.get(j).getFilmTitle()+ " (" + find_year(featureflist.get(j).getReleaseDate())+ ")");
								wf.writeln(featureflist.get(j).getDurationLength() +" min");
								wf.writeln("Language: " + featureflist.get(j).getLanguage());
								wf.writeln("");
								
							}
						}
						if(find_before_films(featureflist, array[3]) == -1){
							
							wf.writeln("No result");
							wf.writeln("");
						}
						
						wf.writeln("-----------------------------------------------------------------------------------------------------");
					}
					
				}
				if(array[1].equals("ARTISTS") && (array[2].equals("FROM"))){
					wf.writeln("LIST\tARTISTS\tFROM\t" + array[3]);
					wf.writeln("");
					wf.writeln("Directors:");
					if(d.find_person(directorlist, array[3]) == -1){
						wf.writeln("No result");
					}
					for(int i=0; i<directorlist.size(); i++){
						
						if(directorlist.get(i).getCountry().equals(array[3])){
							wf.writeln(directorlist.get(i).getName()+" " +directorlist.get(i).getSurname()+" "+directorlist.get(i).getAgent());				
						}
					}
					wf.writeln("");
					wf.writeln("Writers:");
					if(w.find_person(writerlist, array[3]) == -1){
						wf.writeln("No result");
					}
					for(int i=0; i<writerlist.size();i++){
						if(writerlist.get(i).getCountry().equals(array[3])){
							wf.writeln(writerlist.get(i).getName()+" "+writerlist.get(i).getSurname()+" "+writerlist.get(i).getStyle());
						}
					}
					wf.writeln("");
					wf.writeln("Actors:");
					if(a.find_person(actorlist, array[3]) == -1){
						wf.writeln("No result");
					}
					for(int i=0; i<actorlist.size();i++){
						if(actorlist.get(i).getCountry().equals(array[3])){
							wf.writeln(actorlist.get(i).getName()+" "+actorlist.get(i).getSurname()+" "+actorlist.get(i).getHeight()+" cm");
						}
					}
					wf.writeln("");
					wf.writeln("Actresses:");
					if(ac.find_person(actresslist, array[3]) == -1){
						wf.writeln("No result");
					}
					for(int i=0;i<actresslist.size();i++){
						if(actresslist.get(i).getCountry().equals(array[3])){
							wf.writeln(actresslist.get(i).getName()+" "+actresslist.get(i).getSurname());
						}
					}
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
					
				}
				if((array[1].equals("FILMS"))&&(array[2].equals("BY"))&&(array[3].equals("RATE"))&&(array[4].equals("DEGREE"))){
					wf.writeln("LIST\tFILMS\tBY\tRATE\tDEGREE");
					wf.writeln("");
					wf.writeln("FeatureFilm:");
					ArrayList<FeatureFilm> featurefilmlist =new ArrayList<FeatureFilm>();
					ArrayList<ShortFilm> shortfilmlist = new ArrayList<ShortFilm>();
					ArrayList<Documentary> documentaryflist = new ArrayList<Documentary>();
					ArrayList<TVSeries> tvserylist = new ArrayList<TVSeries>();
					FeatureFilm f = new FeatureFilm(featureflist.get(0).getFilmId(),featureflist.get(0).getFilmTitle(),featureflist.get(0).getLanguage(),featureflist.get(0).getDirector(),featureflist.get(0).getDurationLength(),featureflist.get(0).getCountry(),featureflist.get(0).getPerformers(),featureflist.get(0).getGenre(),featureflist.get(0).getReleaseDate(),featureflist.get(0).getWriter(),featureflist.get(0).getBudget(),find_rating_score(ratelist, featureflist.get(0).getFilmId()),find_user_number(ratelist, featureflist.get(0).getFilmId()));
					for(int i=0;i<featureflist.size();i++){
						FeatureFilm ffilm = new FeatureFilm(featureflist.get(i).getFilmId(),featureflist.get(i).getFilmTitle(),featureflist.get(i).getLanguage(),featureflist.get(i).getDirector(),featureflist.get(i).getDurationLength(),featureflist.get(i).getCountry(),featureflist.get(i).getPerformers(),featureflist.get(i).getGenre(),featureflist.get(i).getReleaseDate(),featureflist.get(i).getWriter(),featureflist.get(i).getBudget(),find_rating_score(ratelist, featureflist.get(i).getFilmId()),find_user_number(ratelist, featureflist.get(i).getFilmId()));
						featurefilmlist.add(ffilm);
					}
					f.orderbyrate(featurefilmlist);
					for(int i=0; i < featurefilmlist.size(); i++)
					{
						if(parse_float(String.format("%.1f", featurefilmlist.get(i).getRatingScore())).equals("0"))
							wf.writeln(featurefilmlist.get(i).getFilmTitle()+" ("+find_year(featurefilmlist.get(i).getReleaseDate())+") Ratings: "+String.format("%.0f", featurefilmlist.get(i).getRatingScore())+"/10 from "+featurefilmlist.get(i).getVoteCount()+" users");
						else
							wf.writeln(featurefilmlist.get(i).getFilmTitle()+" ("+find_year(featurefilmlist.get(i).getReleaseDate())+") Ratings: "+String.format("%.1f", featurefilmlist.get(i).getRatingScore())+"/10 from "+featurefilmlist.get(i).getVoteCount()+" users");
					}
					wf.writeln("");
					wf.writeln("ShortFilm:");
					ShortFilm s= new ShortFilm(shortflist.get(0).getFilmId(),shortflist.get(0).getFilmTitle(),shortflist.get(0).getLanguage(),shortflist.get(0).getDirector(),shortflist.get(0).getDurationLength(),shortflist.get(0).getCountry(),shortflist.get(0).getPerformers(),shortflist.get(0).getGenre(),shortflist.get(0).getReleaseDate(),shortflist.get(0).getWriter(),find_rating_score(ratelist, shortflist.get(0).getFilmId()),find_user_number(ratelist, shortflist.get(0).getFilmId()));
					for(int i=0;i<shortflist.size();i++){						
						ShortFilm sfilm= new ShortFilm(shortflist.get(i).getFilmId(),shortflist.get(i).getFilmTitle(),shortflist.get(i).getLanguage(),shortflist.get(i).getDirector(),shortflist.get(i).getDurationLength(),shortflist.get(i).getCountry(),shortflist.get(i).getPerformers(),shortflist.get(i).getGenre(),shortflist.get(i).getReleaseDate(),shortflist.get(i).getWriter(),find_rating_score(ratelist, shortflist.get(i).getFilmId()),find_user_number(ratelist, shortflist.get(i).getFilmId()));
						shortfilmlist.add(sfilm);	
					}
					s.orderbyrate(shortfilmlist);
					for(int i=0; i < shortfilmlist.size(); i++)
					{
						if(parse_float(String.format("%.1f", shortfilmlist.get(i).getRatingScore())).equals("0"))
							wf.writeln(shortfilmlist.get(i).getFilmTitle()+" ("+find_year(shortfilmlist.get(i).getReleaseDate())+") Ratings: "+String.format("%.0f", shortfilmlist.get(i).getRatingScore())+"/10 from "+shortfilmlist.get(i).getVoteCount()+" users");
						else
							wf.writeln(shortfilmlist.get(i).getFilmTitle()+" ("+find_year(shortfilmlist.get(i).getReleaseDate())+") Ratings: "+String.format("%.1f", shortfilmlist.get(i).getRatingScore())+"/10 from "+shortfilmlist.get(i).getVoteCount()+" users");
					}
					wf.writeln("");
					wf.writeln("Documentary:");
					Documentary docum= new Documentary(documentarylist.get(0).getFilmId(),documentarylist.get(0).getFilmTitle(),documentarylist.get(0).getLanguage(),documentarylist.get(0).getDirector(),documentarylist.get(0).getDurationLength(),documentarylist.get(0).getCountry(),documentarylist.get(0).getPerformers(),documentarylist.get(0).getReleaseDate(),find_rating_score(ratelist, documentarylist.get(0).getFilmId()),find_user_number(ratelist, documentarylist.get(0).getFilmId()));
					for(int i=0;i<documentarylist.size();i++){
						Documentary doc= new Documentary(documentarylist.get(i).getFilmId(),documentarylist.get(i).getFilmTitle(),documentarylist.get(i).getLanguage(),documentarylist.get(i).getDirector(),documentarylist.get(i).getDurationLength(),documentarylist.get(i).getCountry(),documentarylist.get(i).getPerformers(),documentarylist.get(i).getReleaseDate(),find_rating_score(ratelist, documentarylist.get(i).getFilmId()),find_user_number(ratelist, documentarylist.get(i).getFilmId()));
						documentaryflist.add(doc);	
						
					}
					docum.orderbyrate(documentaryflist);
					for(int i=0; i< documentaryflist.size();i++){
						if(parse_float(String.format("%.1f",documentaryflist.get(i).getRatingScore())).equals("0"))
							wf.writeln(documentaryflist.get(i).getFilmTitle()+" ("+find_year(documentaryflist.get(i).getReleaseDate())+") Ratings: "+String.format("%.0f",documentaryflist.get(i).getRatingScore())+"/10 from "+documentaryflist.get(i).getVoteCount()+" users");
						else
							wf.writeln(documentaryflist.get(i).getFilmTitle()+" ("+find_year(documentaryflist.get(i).getReleaseDate())+") Ratings: "+String.format("%.1f",documentaryflist.get(i).getRatingScore())+"/10 from "+documentaryflist.get(i).getVoteCount()+" users");
					}
					wf.writeln("");
					wf.writeln("TVSeries:");
					TVSeries tv= new TVSeries(tvserieslist.get(0).getFilmId(),tvserieslist.get(0).getFilmTitle(),tvserieslist.get(0).getLanguage(),tvserieslist.get(0).getDirector(),tvserieslist.get(0).getDurationLength(),tvserieslist.get(0).getCountry(),tvserieslist.get(0).getPerformers(),tvserieslist.get(0).getGenre(),tvserieslist.get(0).getWriter(),tvserieslist.get(0).getStartDate(),tvserieslist.get(0).getEndDate(),tvserieslist.get(0).getSeasonNumber(),tvserieslist.get(0).getEpisodeNumber(),find_rating_score(ratelist, tvserieslist.get(0).getFilmId()),find_user_number(ratelist, tvserieslist.get(0).getFilmId()));
					for(int i=0;i<tvserieslist.size();i++){					
						TVSeries tvs= new TVSeries(tvserieslist.get(i).getFilmId(),tvserieslist.get(i).getFilmTitle(),tvserieslist.get(i).getLanguage(),tvserieslist.get(i).getDirector(),tvserieslist.get(i).getDurationLength(),tvserieslist.get(i).getCountry(),tvserieslist.get(i).getPerformers(),tvserieslist.get(i).getGenre(),tvserieslist.get(i).getWriter(),tvserieslist.get(i).getStartDate(),tvserieslist.get(i).getEndDate(),tvserieslist.get(i).getSeasonNumber(),tvserieslist.get(i).getEpisodeNumber(),find_rating_score(ratelist, tvserieslist.get(i).getFilmId()),find_user_number(ratelist, tvserieslist.get(i).getFilmId()));
						tvserylist.add(tvs);						
					}	
					tv.orderbyrate(tvserylist);
					for(int i=0; i< tvserylist.size();i++){
						if(parse_float(String.format("%.1f", tvserylist.get(i).getRatingScore())).equals("0"))
							wf.writeln(tvserylist.get(i).getFilmTitle()+" ("+find_year(tvserylist.get(i).getStartDate())+"-"+find_year(tvserylist.get(i).getEndDate())+") Ratings: "+String.format("%.0f",tvserylist.get(i).getRatingScore())+"/10 from "+tvserylist.get(i).getVoteCount()+" users");
						else
							wf.writeln(tvserylist.get(i).getFilmTitle()+" ("+find_year(tvserylist.get(i).getStartDate())+"-"+find_year(tvserylist.get(i).getEndDate())+") Ratings: "+String.format("%.1f",tvserylist.get(i).getRatingScore())+"/10 from "+tvserylist.get(i).getVoteCount()+" users");
					}
					wf.writeln("");
					wf.writeln("-----------------------------------------------------------------------------------------------------");
				}
			}
		}
	}
}

