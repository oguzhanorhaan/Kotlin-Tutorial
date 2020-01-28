# Kotlin-Tutorial
Includes my Kotlin syntax notes  
- KotlinTutorial project is about Kotlin syntax.   
- WeatherApp project demonstrates a simple Retrofit usage example . 
  
![Kotlin-Tutorial](weather.gif)
  
- Movies project demonsrates usages of RxJava, RxAndroid and Retrofit together in Kotlin.
![Kotlin-Tutorial](third.gif)
  
 ## Coroutines notes:  
 #### Why Kotlin Coroutines?  
- So simpler than other methods like RxJava, LiveData … . 
-  Suspend functions suspend the execution of the coroutine without blocking the current thread. Thus, the thread starts to operate another corutine and the CPU is used more efficiently.  
(Suspend functionlar, mevcut threadi bloke etmeden coroutinin yürütülmesini askıya alır. Böylelikle thread başka bir corutinenin işletilmesine başlar ve cpu daha verimli bir şekilde kullanılmış olur.
)
  
-  All coroutines can be exist in a single thread.  

-  delay(1000) -> delays coroutine for 1 second . 
   Thread.sleep(1000) ->delays whole coroutine for 1 second in thread,  
   
-  3 types of coroutines -> . 
 default -> heavy computational interactions like filter,  
IO -> for network and local database interactions, executed on background thread,  
Main -> for doing things on main thread and interacting with UI
  
  
- withContext(Main) {
} —> Switches coroutine context to main thread . 


-  withContext(IO) {   
	val job = withTimeoutOrNull(TIMEOUT_CONSTANT) {   
      val result = getResultFromAPI1()   
      val result2 = getResultFromAPI2()  
		  ...  
	  }  
	if(job == null)  
	{   
	  	//timeout message  
	}  
} 
