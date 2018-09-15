package com.hgoyal.annotations;

public @interface EnhancementRequest 
{
	int id();
	
	String synopsis();
	
	String engineer() default "[unassigned]";
	
	String date() default "[unknown]";
}
