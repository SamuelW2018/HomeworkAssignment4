import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a web spider application. It visits 100 websites using a hash map. It adds new sites to the map as it goes.
 * @author swynsma18
 *
 */
public class WebSpiderDisplay {
	private static Map<String, Boolean> ourMap = new HashMap<String, Boolean>();
	/**
	 * Main function for web spider display. This function adds a website to our hash map,
	 * then it initializes the current run. It runs through 100 different websites. Each time,
	 * it makes a new URL and checks for any possible links on that page. It adds those links
	 * to the hash map. Once it runs out of links to add, it searches the next non-visited url.
	 * When it has finished searching all possible urls, or it has run 100 times, it ends.
	 * @param args
	 */
	public static void main(String[] args)
	{		
		ourMap.put("http://espn.com", false);
		URL url;
		int currentRun = 1;		
		try{
			while(currentRun <= 100)
			{
				url = getNxtEntry();
				if (url != null)
				{
					System.out.printf("Current URL on test %d: %s\n", currentRun, url);
					BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
					String line = rdr.readLine();
					while (line != null)
					{
						Pattern urls = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
						Matcher matcher = urls.matcher(line);
						if (matcher.find() && !ourMap.containsKey(matcher.group(1)))
						{
							//System.out.printf("URL: %s\n", matcher.group(1));
							ourMap.put(matcher.group(1), false);

						}

						line = rdr.readLine();
					}
					currentRun++;
				}
				else
				{
					break;
				}

			}

		}
		catch(Exception ex)
		{
			System.out.printf("Oops: %s\n", ex.getMessage());
		}
	}
	
	/**
	 * This function gets the next url entry in the hash map. First, it checks to make sure
	 * if the hash map has elements. Then it runs through the hash map, looking for websites.
	 * It will only return a url on websites that have not been visited yet (the boolean value for that key/value pair of ourMap is false).
	 * Then, it will return the url of that non-visited website and change the boolean value to true.
	 * @return a url for the main function to deal with.
	 */
	public static URL getNxtEntry()
	{
		try
		{
		if(ourMap.entrySet() != null)
		{
			for (Entry<String, Boolean> e: ourMap.entrySet())
			{
				String k = e.getKey();
				Boolean b = e.getValue();
				if(!b)
				{
					ourMap.put(k, true); //e.setValue(true);
					URL url = new URL(k);
					return url;
				}
			}
		}
		}
		catch(Exception ex)
		{System.out.printf("Its breaking");}
		
		return null;
		
	}
}
