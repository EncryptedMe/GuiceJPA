package GuiceServletDemo;

import com.google.inject.ImplementedBy;

@ImplementedBy(SpecsImp1.class)
public interface Specs {
	String getDetails();
}


//Implementation First
class SpecsImp1 implements Specs {
	@Override
	public String getDetails() {
		return "This is spec Implementation1!";
		
	}
}

//Implementation Second
class SpecsImp2 implements Specs {
	@Override
	public String getDetails() {
		return "This is spec Implementation2!";
		
	}
}