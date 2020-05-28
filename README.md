# Kotlin-Tutorial
Includes my Kotlin syntax notes  
- **KotlinTutorial** project is about Kotlin syntax.   
- **WeatherApp** project demonstrates a simple Retrofit usage example . 
  
![Kotlin-Tutorial](weather.gif)
  
- **Movies** project demonsrates usages of RxJava, RxAndroid and Retrofit together in Kotlin.
![Kotlin-Tutorial](third.gif)  

- **andfun_kotlin-android-trivia-starter-code app**   for lesson 3 of the [Android App Development in Kotlin course on Udacity](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012).

The Android Trivia application is an application that asks the user trivia questions about Android development.  It makes use of the Navigation component within Jetpack to move the user between different screens.  Each screen is implemented as a Fragment.
The app navigates using buttons, the Action Bar, and the Navigation Drawer.

  
 ## Coroutines notes:  
 #### Why Kotlin Coroutines?  
 - A **suspending function** is simply a function that can be paused and resumed at a later time. So these type of function can execute o long running operation and wait for it to complete without blocking.  
- So simpler than other methods like RxJava, LiveData … . 
-  Suspend functions suspend the execution of the coroutine without blocking the current thread. Thus, the thread starts to operate another corutine and the CPU is used more efficiently.  
(Suspend functionlar, mevcut threadi bloke etmeden coroutinin yürütülmesini askıya alır. Böylelikle thread başka bir corutinenin işletilmesine başlar ve cpu daha verimli bir şekilde kullanılmış olur.
)    
-  All coroutines can be exist in a single thread.  

-  delay(1000) -> delays coroutine for 1 second . 
   Thread.sleep(1000) ->delays whole coroutine for 1 second in thread,  
   
-  3 types of coroutines ->  
 **default** -> heavy computational interactions like filter,  
**IO** -> for network and local database interactions, executed on background thread,  
**Main** -> for doing things on main thread and interacting with UI
  
  
- withContext(Main) {
} —> Switches coroutine context to main thread . 


- ``` withContext(IO) {   
	val job = withTimeoutOrNull(TIMEOUT_CONSTANT) {   
     val result = getResultFromAPI1()   
     val result2 = getResultFromAPI2()  
		  ...  
	}  
	if(job == null)  
	{   
	  	//timeout message  
	}  
 
---  
#### LiveData
- An observable data holder class that is lifecycle-aware  
- Ensures your UI matches your data state,
- LiveData follows observer pattern
- LiveData notifies Observes when lifecycle state changes
- Clean code structure
- On configuration changes, like device rotation, immediately latest available data is received . 

--- 
#### Dependency Injection  
**Inversion of Control**  = The object you depend on in method or class is not created. In its place comes the object, which is dependent on the outside ready. setCake(cake).  
Dependency Injection is one of the application forms of Inversion of Control.  
**Service Locator:** Service Locator can be thought as a kind of Factory, Abstract Factory design pattern. Depended object achieved from Service Locator. Libraries like **Kodein, Koin** can be thought as service locator.  
**Dagger 2**: Dagger2 is a dependency injection framework. Dagger2 creates dependency graph at compile time by using annotations and we can obtain errors at compile-time if to much dependencies and classes are in a mess.  


- Loosely coupled code
- Easy testing
- Classes are not directly dependent on each other  

**Types of dependency injection and creation order of injection types** :  

Constructor Injection  

Field Injection  

Method Inject  

Field and method injection are only automatically executed if we also do a constructor injection.

---   
#### Other Notes 
- **@Volatile** annotation means this variable immediately visible to all the threads  
- “Unit" in Kotlin is equivalent of "void" in Java.  
- Sealed class defines a closed type. That means all subclasses of data item must be defined in this file. As a result, number of subclasses is known to the compiler and it’s not possible for another part of yourcode to define a new type of data item. Sealed classes can be thought an extended version of Enums. It handles lots of things compared to enums. Sealed classes are abstract and can not be instantiated directly.  
- **DiffUtil:**  Helper for RecyclerView Adapters that calculates differences changes in lists and minimizes modifications.   
- Scoping: Like telling to the object “you are able to exist in desired actives, fragments or components, that can be whole app or a particular parts, if that parts die, you die”.  
- data class: generates getter, setter, equals(), toString(), hashCode() ... methods automatically and provides clean look.  
- **Immutable variable** is one whose value cannot be changed, also known as unchangeable or read-only variable (ex: val). On the other hand the value of the **mutable variable** can be changed (ex: var).

---   
#### Navigation Architecture  
- **Navigation Graph**: The part where we can visualize and edit all the navigations that can be done in the application, even the possible routes that the user can take.
- **NavController**: An object that follows the current position in the navigation chart
- **NavHostFragment** is the parent in the view hierarchy of our current fragment.  
- Navigation graph gives a good insight into how users are going to use your app right
  Gives an idea to developers to how app is complicated to user  
- **Explicit Intents** -> Explicit intent is used to launch an activity using the name of the target activity class and they are typically used to launch other activities within your application.  
- **Implicit Intents** -> Implicit  intents provide an abstract description of the operation to be performed  and they most often are used to launch activities that are exposed by other applications.  
Implicitly launched activities require an intent-filter. An intent-filter used to expose that your activity can respond to an implicit intent with a certain action category and/or type.  
- **SafeArgs Plugin** is a Gradle Plugin that generates code to help guarantee that the arguments on both side matches up while also simplifying argument passing.  
**What are advantages we get from using safe arguments?**    
We get type safety, as navigation generates the action and the argument class from the navigation graph.  
We get argument enforcement, as non-default arguments are required parameters in the action.  

---   
#### Room Database  

- Redefine each entity as a data class and the interactions as a interface and then we use annotations to add metadata to both and Room uses these annotated classes to create tables in the db and queries that act on the db.  

- Room is perfect for offline cache.  

- Data Transfer Objects objects for parsing from network. We separate them from Domain Objects because they contain extra  logic for parsing network results that’s not relevant to what they represent.   
- Domain Objects are the data that our app uses internally. We don’t ever share them over the network or to the database . This way the server can completely change its result without impacting the internal working of our app.  

- It is a good practice to separate DTOs and DOs, this is an example of separation of concerns by keeping them separate we are easily able to change any of them without impacting our app’s entire code.  



