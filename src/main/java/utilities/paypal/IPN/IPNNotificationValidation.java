/*
* Copyright 2010 Peter Backx, streamhead.com
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package utilities.paypal.IPN;

import java.net.MalformedURLException;

import utilities.paypal.core.HttpPost;
import utilities.paypal.core.Transport;

public class IPNNotificationValidation {

	private static final long serialVersionUID = 2L;

	private final String cmd = "_notify-validate";
	private final String verified = "VERIFIED";

	private final Transport transport = new HttpPost();
	
	private final IPNMessage message;
	
	public IPNNotificationValidation(IPNMessage message) {
		this.message = message;
	}

	public String getCommand() {
		return cmd;
	}
	
	public String getUrl(PayPalEnvironment environment) {
		return "https://www." + environment.getUrlModifier() + "paypal.com/cgi-bin/webscr";
	}
	
	public boolean validate(final PayPalEnvironment environment) {
		StringBuffer nvpString = new StringBuffer("cmd=" + getCommand() + "&");

		final String fullMessage = message.getFullMessage().getValue();
		nvpString.append(fullMessage.replace("\n", "&"));
		System.out.println(nvpString);
		String response = null;
		try {
				
			response = transport.getResponse(getUrl(environment),
					nvpString.toString());
			System.out.println(response);
		} catch (MalformedURLException ex) {
		
		}

		if (response != null) {
		
			System.out.println("La respuesta es : " + response.equals(verified));
			return response.equals(verified);
		}

		return false;
	}
}
