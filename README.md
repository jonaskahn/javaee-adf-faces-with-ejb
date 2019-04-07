
# A template for Oracle ADF Faces/ EJB

### Getting started
______
- ***New feature  - Dependency Injection***
    - As far as I know, Dependency Injection is a common technique that was supported by lots of Frameworks nowadays. Right? I guess.
Yep, when I started working in the new company, started working with ADF Faces, EJB. I really felt a little bit upset cause ADF Faces doesn't support full injection. It means **you can't inject a SessionBean into a ManagedBean**. Someone will tell that isn't necessary. I also agree, but most the time, you need to declare a remote context or a local context before looking up a SessionBean from Weblogic.
 
   - It's quite backward and I'm too lazy to do that. It's better for me if someone can automatically look up it for me like Spring do with annotation @Autowired. If you also lazy like me, you can use this solution. Even it doesn't work at all, but I think the idea is really good. Read [here](http://codeplay.net/2010/09/14/inject-ejb-to-adf-managed-bean/). I have modified something to make it better.

- ***How can I run project?***
	-	Install [Oracle 11g Express](http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html), then unlock **HR model**
	```
	SQL> ALTER USER hr ACCOUNT UNLOCK;
	SQL> ALTER USER hr IDENTIFIED BY <hr-password>;
	SQL> exit
	```
	-	Configure [JTA Datasource](https://www.appeon.com/support/documents/appeon_online_help/1.5/server_configuration_guide_for_j2ee/ch03s03s01.html) in Weblogic 12 with ***JNDI-name*** - **"HRDS"**
	-	Rebuild project working set (All files)  and run the funtion *Region* and start your work

- ***Project Structure***
	-	I created 5 modules in this project, each project has a special role. I don't add all project in one because it will be hard to understand for newbies. You can see the structure in the picture below
	![alt text](https://preview.ibb.co/bJEVyH/Untitled_1.png)
______
### Support Bootstrap 4 And JQuery
- It's a web project, you can integrate  Bootstrap 4 And JQuery, I tried to integrate  *Region function*, you can take a look and consult. Howerver, I'm not Front-end developer, so I didn't make it beautiful. 
______
### Screenshots
- *Dashboard* 
![alt text](https://i.imgur.com/WRbzsFg.png "My Dashboard")
______
### Quick  Guide
- ***Use injection***	
	-	Inject remote service 
		-	Declare in controller
		```
		@Autoinjector(mappedName = [mapped-name], injectType = InjectorType.REMOTE)
		```
	 -	Inject local service
		 - [Configure](https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/servjndi004.htm) EJB Local in web.xml
		 ```
		 <ejb-local-ref>
			 <ejb-ref-name>myBeans/BeanA</ejb-ref-name>
			 <ejb-ref-type>Session</ejb-ref-type>
			 <local-home>myBeans.BeanAHome</home>
			 <local>myBeans.BeanA</remote>
		</ejb-ref>
		```
		-	Declear in Controller
		```
		@Autoinjector(refName= [ref-name], injectType = InjectorType.LOCAL)
		```
	-	Example
		```
		    // Use remote service
		    @Autoinjector(mappedName = Constant.EJB_MAPPED_NAME.REGIONS_FACADE, injectType = InjectorType.REMOTE) 
		    private RegionsFacadeRemote regionsService;
		    . . .
		    public String doSearch() {
			    try {
				    lstRegions = regionsService.findByCondition(searchDTO);
				    reportSuccess("com.tuyendev.region.label.search.result", lstRegions.size());
				} catch (Exception e) {
					reportError(e);
				}
				return null;
		    }
	
-	***Send notifications***
	-	Support 3 types of notification
		![alt_text](https://preview.ibb.co/je5FXc/Untitled.png)
	-	**Error**
		```
		public void reportError(Exception e)
		....
		public void reportError(Exception e, ADFLogger logger)
		....
		public void reportError(String keyMess, Object... params)
		```
	-	**Success**
		```
		public void reportSuccess(String key, Object... params)
		```
	-	**Warm**
		```
		public void reportWarm(String keyMess, Object... params)
		.....
		private void reportWarm(LogicException e, ADFLogger logger) 
		```
	- **Configure time-out display**
		![alt_text](https://preview.ibb.co/kL6uQx/222.png)
		```
		package com.tuyendev.common;
		
		public class Constant {
			.....
			// millisecond
			public final static class DEFAULT_TIMEOUT_MESSAGE {
		        public final static long ERROR = 50000L;
		        public final static long SUCCESS = 20000L;
		        public final static long WARNING = 25000L;
		        public final static long INFO = 10000L;
		    }
		   ....

	-	**Change server weblogic ip address**
		```
		package com.tuyendev.common;
		
		public class ContextUtil {
			@SuppressWarnings("unchecked")
			public static Context getRemoteContext() throws NamingException {
				Hashtable env = new Hashtable();
			    env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
				env.put(Context.PROVIDER_URL, Constant.PROVIDER_URL);
				return new InitialContext(env);
			}
				....
		}
		```
		```
		package com.tuyendev.common;
		
		public class Constant {
			public final static String PROVIDER_URL = "t3://127.0.0.1:7101";
			....
		}
		```
