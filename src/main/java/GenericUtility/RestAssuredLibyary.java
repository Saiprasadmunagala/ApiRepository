package GenericUtility;

import io.restassured.response.Response;


/**
 *  Consist of methods of Rest Assured tool
 * @author SaiPrasad
 *
 */
public class RestAssuredLibyary{
	/**
	 * this method will return json data from the corresponding response body
	 * @author SaiPrasad
	 * @param response
	 * @param path
	 * @return jsonPath
	 */
	
	public String getJsonData(Response response,String path) {
		String JsonData=response.jsonPath().get(path);
		return JsonData;
	}
	
}
