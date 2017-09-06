# What will I do?

### Dependency Injection
- As far as I know, Dependency Injection is a common technique that was supported by lots of Frameworks nowadays. Right? I guess.
Yep, when I started working in the new company, started working with ADF Faces, EJB. I really feel a little bit upset cause ADF Faces doesn't support full injection. It means **you can't inject a SessionBean into a ManagedBean**. Someone will tell that isn't necessary. I also agree, but most the time, you need to declare a remote context or a local context before looking up a SessionBean from Weblogic, such as:

````
          Context ctx = null;

          Hashtable ht = new Hashtable();

          ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");

          ht.put(Context.PROVIDER_URL, "t3://192.9.200.222:7001");

}

````

It's quite backward and I'm too lazy to do that. It's better for me if someone can automatically look up it for me like Spring do with annotation @Autowired. If you also lazy like me, you can use this solution. Even it doesn't work at all, but I think the idea is really good. Read [here](http://codeplay.net/2010/09/14/inject-ejb-to-adf-managed-bean/). I have modified something to make it better.

### Multi-languages
 - Reserved
### Bootstrap 3 template
 - Reserved

