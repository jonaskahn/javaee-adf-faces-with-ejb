# What will I do ?

As far as I know, Dependency Injection is a common technique that was supported by lots of Frameworks nowadays. Right? I guess.
Yep, when I started working in new company, started working with ADF Faces, EJB. I really feel a little bit upset cause ADF Faces doesn't support Injection :(. It means **you can't inject a SessionBean into a ManagedBean**. Someone will tell that isn't necessary. I also agree, but if you want to manual lookup a SessionBean from Weblogic. Like that

````
// It isn't my code. 
public class Client {

     public static void main(String[] args) {

          Context ctx = null;

          Hashtable ht = new Hashtable();

          ht.put(Context.INITIAL_CONTEXT_FACTORY,

                    "weblogic.jndi.WLInitialContextFactory");

          ht.put(Context.PROVIDER_URL, "t3://192.9.200.222:7001");

          try {

               ctx = new InitialContext(ht);

               InsertSubscriber usagefasade = (InsertSubscriber) ctx

                         .lookup("ejb.InsertSubscriberBean");               

          } catch (NamingException e) {

               e.printStackTrace();

          } finally {

               try {

                    ctx.close();

               } catch (Exception e) {

                    e.printStackTrace();

               }

          }

     }

}

````

I'm too lazy to do that. It's better for me if someone can automatic lookup it for me, like Spring do with annotation @Autowired. If you also lazy like me, let's do it.

### How to inject a SessionBean into a ADF ManangedBean
See here: http://codeplay.net/2010/09/14/inject-ejb-to-adf-managed-bean/

