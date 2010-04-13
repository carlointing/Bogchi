import com.grailsrocks.taxonomy.Taxonomy;

class BootStrap {

     def init = { servletContext ->
		def taxonomy1 = new Taxonomy(name: "Cuisine")
		taxonomy1.save()
		def taxonomy2 = new Taxonomy(name: "Type")
		taxonomy2.save()		
	 }
     def destroy = {
     }
} 